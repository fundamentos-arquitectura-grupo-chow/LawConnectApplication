package upc.LoremIpsum.lawconnectplatform.consultation.domain.services;

import upc.LoremIpsum.lawconnectplatform.consultation.domain.model.aggregates.Consultation;
import upc.LoremIpsum.lawconnectplatform.consultation.domain.model.queries.*;
import upc.LoremIpsum.lawconnectplatform.feeing.domain.model.aggregates.Payment;

import java.util.List;
import java.util.Optional;

public interface ConsultationQueryService {
    List<Consultation> handle(GetAllConsultationsByLawyerIdQuery query);
    Optional<Consultation> handle(GetConsultationByIdQuery query);
    Optional<Consultation> handle(GetConsultationByLawyerIdAndPaymentIdQuery query);
    Optional<Consultation> handle(GetConsultationByPaymentIdQuery query);
    Optional<List<Payment>> handle(GetAllPaymentsByConsultationIdQuery query);
    List<Consultation> handle(GetAllConsultationsByClientIdQuery query);
    List<Consultation> handle(GetAllConsultationsByClientIdAndLawyerIdQuery query);
}
