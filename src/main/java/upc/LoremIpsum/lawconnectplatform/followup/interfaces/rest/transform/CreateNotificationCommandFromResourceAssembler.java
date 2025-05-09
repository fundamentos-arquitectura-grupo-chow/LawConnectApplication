package upc.LoremIpsum.lawconnectplatform.followup.interfaces.rest.transform;

import upc.LoremIpsum.lawconnectplatform.followup.domain.model.commands.CreateNotificationCommand;
import upc.LoremIpsum.lawconnectplatform.followup.interfaces.rest.resources.CreateNotificationResource;

public class CreateNotificationCommandFromResourceAssembler {
    public static CreateNotificationCommand toCommandFromResource(CreateNotificationResource resource) {
        return new CreateNotificationCommand(
                resource.title(),
                resource.description(),
                resource.clientId(),
                resource.consultationId()
        );
    }
}
