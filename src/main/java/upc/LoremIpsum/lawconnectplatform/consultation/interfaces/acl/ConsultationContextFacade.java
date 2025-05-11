package upc.LoremIpsum.lawconnectplatform.consultation.interfaces.acl;

import upc.LoremIpsum.lawconnectplatform.consultation.application.internal.outboundServices.ExternalPaymentConsultationServices;
import upc.LoremIpsum.lawconnectplatform.consultation.domain.model.aggregates.Consultation;
import upc.LoremIpsum.lawconnectplatform.consultation.domain.model.commands.ChangeConsultationStatusCommand;
import upc.LoremIpsum.lawconnectplatform.consultation.domain.model.queries.GetAllPaymentsByConsultationIdQuery;
import upc.LoremIpsum.lawconnectplatform.consultation.domain.model.queries.GetConsultationByIdQuery;
import upc.LoremIpsum.lawconnectplatform.consultation.domain.model.queries.GetConsultationByPaymentIdQuery;
import upc.LoremIpsum.lawconnectplatform.consultation.domain.services.ConsultationCommandService;
import upc.LoremIpsum.lawconnectplatform.consultation.domain.services.ConsultationQueryService;
import upc.LoremIpsum.lawconnectplatform.consultation.interfaces.rest.resources.ConsultationResource;
import upc.LoremIpsum.lawconnectplatform.consultation.interfaces.rest.transform.ConsultationResourceFromEntityAssembler;
import upc.LoremIpsum.lawconnectplatform.feeing.domain.model.aggregates.Payment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultationContextFacade {

    private final ConsultationCommandService consultationCommandService;
    private final ConsultationQueryService consultationQueryService;
    private final ExternalPaymentConsultationServices externalPaymentConsultationServices;

    public ConsultationContextFacade(ConsultationCommandService consultationCommandService, ConsultationQueryService consultationQueryService, ExternalPaymentConsultationServices externalPaymentConsultationServices) {
        this.consultationCommandService = consultationCommandService;
        this.consultationQueryService = consultationQueryService;
        this.externalPaymentConsultationServices = externalPaymentConsultationServices;
    }
    public Optional<Consultation> getConsultationById(Long consultationId){
        return consultationQueryService.handle(new GetConsultationByIdQuery(consultationId));
    }

    public void changeConsultationStatus(Long consultationId){
        consultationCommandService.handle(new ChangeConsultationStatusCommand(consultationId));
    }

    public Optional<Consultation> getConsultationByPaymentId(Long paymentId){
        return consultationQueryService.handle(new GetConsultationByPaymentIdQuery(paymentId));
    }

    public Optional<List<Payment>> getAllPaymentsByConsultationId(Long consultationId){
        return consultationQueryService.handle(new GetAllPaymentsByConsultationIdQuery(consultationId));
    }

    public Optional<ConsultationResource> createConsultationResource(Consultation consultation){
        var paymentsResource = externalPaymentConsultationServices.createPaymentListResource(consultation.getPayments());
        var consultationResource = ConsultationResourceFromEntityAssembler.toResourceFromEntity(consultation, paymentsResource);
        return Optional.of(consultationResource);
    }
}
