package upc.LoremIpsum.lawconnectplatform.feeing.application.internal.queryServices;

import upc.LoremIpsum.lawconnectplatform.consultation.domain.model.queries.GetAllPaymentsByConsultationIdQuery;
import upc.LoremIpsum.lawconnectplatform.feeing.application.internal.outboundServices.ExternalConsultationPaymentService;
import upc.LoremIpsum.lawconnectplatform.feeing.domain.model.aggregates.Payment;
import upc.LoremIpsum.lawconnectplatform.feeing.domain.model.queries.GetAllPaymentByClientIdQuery;
import upc.LoremIpsum.lawconnectplatform.feeing.domain.model.queries.GetPaymentByIdQuery;
import upc.LoremIpsum.lawconnectplatform.feeing.domain.services.PaymentQueryService;
import upc.LoremIpsum.lawconnectplatform.feeing.infrastructure.persistence.jpa.repositories.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentQueryServiceImpl implements PaymentQueryService {
    private final PaymentRepository paymentRepository;
    private final ExternalConsultationPaymentService externalConsultationPaymentService;

    public PaymentQueryServiceImpl(PaymentRepository paymentRepository, ExternalConsultationPaymentService externalConsultationPaymentService) {
        this.paymentRepository = paymentRepository;
        this.externalConsultationPaymentService = externalConsultationPaymentService;
    }

    @Override
    public List<Payment> handle(GetAllPaymentsByConsultationIdQuery query) {
        boolean exists = externalConsultationPaymentService.existsConsultationById(query.consultationId());
        if (!exists) {
            return List.of();
        }
        return paymentRepository.findAllByConsultationId(query.consultationId());
    }

    @Override
    public List<Payment> handle(GetAllPaymentByClientIdQuery query) {
        return paymentRepository.findAllByClientId(query.clientId());
    }

    @Override
    public Optional<Payment> handle(GetPaymentByIdQuery query) {
        return paymentRepository.findById(query.paymentId());
    }
}
