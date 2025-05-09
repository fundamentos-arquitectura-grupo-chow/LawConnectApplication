package upc.LoremIpsum.lawconnectplatform.legalcase.domain.services;

import upc.LoremIpsum.lawconnectplatform.legalcase.domain.model.commands.AddDocumentByLegalCaseIdCommand;
import upc.LoremIpsum.lawconnectplatform.legalcase.domain.model.commands.ChangeDocumentStatusCommand;
import org.springframework.stereotype.Service;

@Service
public interface DocumentsCommandService {
    void handle(AddDocumentByLegalCaseIdCommand command);
    void handle(ChangeDocumentStatusCommand command);
}
