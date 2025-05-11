package upc.LoremIpsum.lawconnectplatform.consultation.interfaces.rest.transform;

import upc.LoremIpsum.lawconnectplatform.consultation.domain.model.aggregates.Consultation;
import upc.LoremIpsum.lawconnectplatform.consultation.interfaces.rest.resources.ConsultationResource;
import upc.LoremIpsum.lawconnectplatform.feeing.interfaces.rest.resources.PaymentResource;

import java.util.List;

public class ConsultationResourceFromEntityAssembler {
    public static ConsultationResource toResourceFromEntity(Consultation entity, List<PaymentResource> paymentResource) {
        return new ConsultationResource(
                entity.getId(),
                entity.getLawyerId(),
                entity.getClientId(),
                paymentResource,
                entity.getDescription(),
                entity.getConsultationType().toString(),
                entity.getApplicationStatus().toString()
        );
    }
}
