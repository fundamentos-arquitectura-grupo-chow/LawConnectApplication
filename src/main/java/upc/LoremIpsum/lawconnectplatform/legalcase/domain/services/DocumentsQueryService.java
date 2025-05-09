package upc.LoremIpsum.lawconnectplatform.legalcase.domain.services;

import upc.LoremIpsum.lawconnectplatform.legalcase.domain.model.entities.DocumentsItem;
import upc.LoremIpsum.lawconnectplatform.legalcase.domain.model.queries.GetAllDocumentsByLegalCaseQuery;
import upc.LoremIpsum.lawconnectplatform.legalcase.domain.model.queries.GetDocumentByIdQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface DocumentsQueryService {
    List<DocumentsItem> handle(GetAllDocumentsByLegalCaseQuery query);
    Optional<DocumentsItem> handle(GetDocumentByIdQuery query);
}
