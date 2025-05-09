package upc.LoremIpsum.lawconnectplatform.profiles.interfaces.rest.transform;

import upc.LoremIpsum.lawconnectplatform.profiles.domain.model.commands.AddLawyerTypeCommand;
import upc.LoremIpsum.lawconnectplatform.profiles.interfaces.rest.resources.AddLawyerTypeResource;

public class AddLawyerTypeCommandFromResourceAssembler {
    public static AddLawyerTypeCommand ToCommandFromResource(AddLawyerTypeResource resource) {
        return new AddLawyerTypeCommand(
                resource.lawyerId(),
                resource.lawyerTypeId()
        );
    }
}
