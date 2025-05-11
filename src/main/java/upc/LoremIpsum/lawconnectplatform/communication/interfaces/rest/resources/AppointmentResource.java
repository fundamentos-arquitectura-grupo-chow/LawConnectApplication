package upc.LoremIpsum.lawconnectplatform.communication.interfaces.rest.resources;

import upc.LoremIpsum.lawconnectplatform.consultation.domain.model.aggregates.Consultation;
import upc.LoremIpsum.lawconnectplatform.consultation.interfaces.rest.resources.ConsultationResource;

public record AppointmentResource(
        Long id,
        String description,
        ConsultationResource consultation,
        String location,
        String status
) {
}
