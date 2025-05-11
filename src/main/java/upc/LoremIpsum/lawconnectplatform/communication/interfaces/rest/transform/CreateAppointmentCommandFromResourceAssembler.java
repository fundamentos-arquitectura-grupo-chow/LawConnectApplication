package upc.LoremIpsum.lawconnectplatform.communication.interfaces.rest.transform;

import upc.LoremIpsum.lawconnectplatform.communication.domain.model.commands.CreateAppointmentCommand;
import upc.LoremIpsum.lawconnectplatform.communication.interfaces.rest.resources.CreateAppointmentResource;

public class CreateAppointmentCommandFromResourceAssembler {
    public static CreateAppointmentCommand toCommandFromResource(CreateAppointmentResource resource){
        return new CreateAppointmentCommand(
                resource.consultationId(),
                resource.description(),
                resource.location()
        );
    }
}
