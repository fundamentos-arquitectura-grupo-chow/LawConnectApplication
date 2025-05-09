package upc.LoremIpsum.lawconnectplatform.profiles.interfaces.rest.transform;

import upc.LoremIpsum.lawconnectplatform.profiles.domain.model.commands.CreateLawyerCommand;
import upc.LoremIpsum.lawconnectplatform.profiles.interfaces.rest.resources.CreateLawyerResource;

public class CreateLawyerCommandFromResourceAssembler {
    public static CreateLawyerCommand ToCommandFromResource(CreateLawyerResource resource)
    {
        return new CreateLawyerCommand(
                resource.firstName(),
                resource.lastName(),
                resource.email(),
                resource.phoneNumber(),
                resource.address(),
                resource.dni(),
                resource.image_url()
        );
    }
}
