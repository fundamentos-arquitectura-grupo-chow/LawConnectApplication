package upc.LoremIpsum.lawconnectplatform.legalcase.interfaces.rest.transform;

import upc.LoremIpsum.lawconnectplatform.legalcase.domain.model.commands.CreateLegalCaseCommand;
import upc.LoremIpsum.lawconnectplatform.legalcase.interfaces.rest.resources.CreateLegalCaseResource;

public class CreateLegalCaseCommandFromResourceAssembler {
    public static CreateLegalCaseCommand toCommandFromResource(CreateLegalCaseResource resource) {
        return new CreateLegalCaseCommand(
                resource.title(),
                resource.description(),
                resource.consultationId()
        );
    }
}
