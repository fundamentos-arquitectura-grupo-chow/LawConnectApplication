package upc.LoremIpsum.lawconnectplatform.communication.interfaces.rest.transform;

import upc.LoremIpsum.lawconnectplatform.communication.domain.model.aggregates.Appointment;
import upc.LoremIpsum.lawconnectplatform.communication.interfaces.rest.resources.AppointmentResource;
import upc.LoremIpsum.lawconnectplatform.consultation.interfaces.rest.resources.ConsultationResource;

public class AppointmentResourceFromEntityAssembler {
    public static AppointmentResource toResourceFromEntity(Appointment entity, ConsultationResource consultationResource) {
        return new AppointmentResource(
                entity.getId(),
                entity.getDescription(),
                consultationResource,
                entity.getLocation(),
                entity.getStatus().toString()
        );
    }
}
