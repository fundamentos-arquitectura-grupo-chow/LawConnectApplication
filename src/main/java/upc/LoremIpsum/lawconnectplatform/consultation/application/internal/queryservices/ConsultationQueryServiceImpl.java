package upc.LoremIpsum.lawconnectplatform.consultation.application.internal.queryservices;

import upc.LoremIpsum.lawconnectplatform.consultation.application.internal.outboundServices.ExternalPaymentConsultationServices;
import upc.LoremIpsum.lawconnectplatform.consultation.domain.model.aggregates.Consultation;
import upc.LoremIpsum.lawconnectplatform.consultation.domain.model.queries.*;
import upc.LoremIpsum.lawconnectplatform.consultation.domain.services.ConsultationQueryService;
import upc.LoremIpsum.lawconnectplatform.consultation.infrastructure.persistence.jpa.repositories.ConsultationRepository;
import upc.LoremIpsum.lawconnectplatform.feeing.domain.model.aggregates.Payment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultationQueryServiceImpl implements ConsultationQueryService {
    private final ConsultationRepository consultationRepository;
    private final ExternalPaymentConsultationServices externalPaymentConsultationServices;

    public ConsultationQueryServiceImpl(ConsultationRepository consultationRepository, ExternalPaymentConsultationServices externalPaymentConsultationServices) {
        this.consultationRepository = consultationRepository;
        this.externalPaymentConsultationServices = externalPaymentConsultationServices;
    }

    @Override
    public Optional<Consultation> handle(GetConsultationByIdQuery query) {
        return consultationRepository.findById(query.consultationId());
    }

    @Override
    public Optional<Consultation> handle(GetConsultationByLawyerIdAndPaymentIdQuery query) {
        var payment = externalPaymentConsultationServices.getPaymentById(query.paymentId());
        if (payment.isEmpty()) {
            return Optional.empty();
        }

        // Buscar la consulta por el consultationId del pago
        var consultationId = payment.get().getConsultationId();
        var consultation = consultationRepository.findById(consultationId);

        // Verificar si el lawyerId coincide
        return consultation.filter(c -> c.getLawyerId().equals(query.lawyerId()));
    }

    @Override
    public Optional<Consultation> handle(GetConsultationByPaymentIdQuery query) {
        var payment = externalPaymentConsultationServices.getPaymentById(query.paymentId());
        if (payment.isEmpty()) {
            return Optional.empty();
        }

        // Buscar la consulta por el consultationId del pago
        var consultationId = payment.get().getConsultationId();
        return consultationRepository.findById(consultationId);
    }

    @Override
    public Optional<List<Payment>> handle(GetAllPaymentsByConsultationIdQuery query) {
        // Usar el ExternalPaymentConsultationServices para obtener los pagos por consultationId
        var consultation = consultationRepository.findById(query.consultationId());
        if (consultation.isEmpty()) {
            return Optional.empty();
        }

        // Obtener pagos desde el servicio externo
        var payments = externalPaymentConsultationServices.getPaymentsByConsultationId(query.consultationId());
        return Optional.of(payments);
    }

    @Override
    public List<Consultation> handle(GetAllConsultationsByClientIdQuery query) {
        return consultationRepository.findAllByClientId(query.id());
    }

    @Override
    public List<Consultation> handle(GetAllConsultationsByClientIdAndLawyerIdQuery query) {
        return consultationRepository.findAllByClientIdAndLawyerId(query.clientId(), query.lawyerId());
    }

    @Override
    public List<Consultation> handle(GetAllConsultationsByLawyerIdQuery query) {
        return consultationRepository.findAllByLawyerId(query.lawyerId());
    }
}