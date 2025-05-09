package upc.LoremIpsum.lawconnectplatform.legalcase.interfaces.rest.transform;

import upc.LoremIpsum.lawconnectplatform.legalcase.domain.model.commands.AddDocumentByLegalCaseIdCommand;
import upc.LoremIpsum.lawconnectplatform.legalcase.interfaces.rest.resources.AddDocumentByLegalCaseIdResource;

public class AddDocumentByLegalCaseIdCommandFromResourceAssembler {
    public static AddDocumentByLegalCaseIdCommand toCommandFromResource(AddDocumentByLegalCaseIdResource resource) {
        return new AddDocumentByLegalCaseIdCommand(
                resource.title(),
                resource.description(),
                resource.type(),
                resource.status(),
                resource.legalCaseId()
        );
    }
}
