package upc.LoremIpsum.lawconnectplatform.legalcase.domain.services;

import upc.LoremIpsum.lawconnectplatform.legalcase.domain.model.aggregates.LegalCase;
import upc.LoremIpsum.lawconnectplatform.legalcase.domain.model.queries.GetAllLegalCasesQuery;
import upc.LoremIpsum.lawconnectplatform.legalcase.domain.model.queries.GetLegalCaseByConsultationIdQuery;
import upc.LoremIpsum.lawconnectplatform.legalcase.domain.model.queries.GetLegalCaseByIdQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface LegalCaseQueryService {
    List<LegalCase> handle(GetAllLegalCasesQuery query);
    Optional<LegalCase> handle(GetLegalCaseByIdQuery query);
    Optional<LegalCase> handle(GetLegalCaseByConsultationIdQuery query);
}
