package upc.LoremIpsum.lawconnectplatform.communication.interfaces.rest.resources;

import upc.LoremIpsum.lawconnectplatform.consultation.domain.model.aggregates.Consultation;
import upc.LoremIpsum.lawconnectplatform.consultation.interfaces.rest.resources.ConsultationResource;

public record VideoCallResource(
        Long id,
        ConsultationResource consultation,
        String description,
        String status
) {
}
