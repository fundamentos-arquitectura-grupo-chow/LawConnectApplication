package upc.LoremIpsum.lawconnectplatform.communication.interfaces.rest.transform;

import upc.LoremIpsum.lawconnectplatform.communication.domain.model.commands.CreateVideoCallCommand;
import upc.LoremIpsum.lawconnectplatform.communication.interfaces.rest.resources.CreateVideoCallResource;

public class CreateVideoCallCommandFromResourceAssembler {
    public static CreateVideoCallCommand toCommandFromResource(CreateVideoCallResource resource){
        return new CreateVideoCallCommand(
                resource.consultationId(),
                resource.description()
        );
    }
}
