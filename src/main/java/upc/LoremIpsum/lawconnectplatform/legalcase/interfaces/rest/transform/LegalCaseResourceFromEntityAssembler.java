package upc.LoremIpsum.lawconnectplatform.legalcase.interfaces.rest.transform;

import upc.LoremIpsum.lawconnectplatform.legalcase.domain.model.aggregates.LegalCase;
import upc.LoremIpsum.lawconnectplatform.legalcase.interfaces.rest.resources.LegalCaseResource;

public class LegalCaseResourceFromEntityAssembler {
    public static LegalCaseResource toResourceFromEntity(LegalCase entity) {
        return new LegalCaseResource(
                entity.getId(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getStatus().name(),
                entity.getConsultationId(),
                entity.getDocuments().getDocumentsItems().stream()
                        .map(DocumentsItemResourceFromEntityAssembler::toResourceFromEntity)
                        .toList()
        );
    }
}