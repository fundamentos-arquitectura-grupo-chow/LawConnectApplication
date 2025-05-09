package upc.LoremIpsum.lawconnectplatform.legalcase.interfaces.rest.transform;

import upc.LoremIpsum.lawconnectplatform.consultation.interfaces.rest.resources.ConsultationResource;
import upc.LoremIpsum.lawconnectplatform.legalcase.domain.model.aggregates.LegalCase;
import upc.LoremIpsum.lawconnectplatform.legalcase.interfaces.rest.resources.LegalCaseResource;

public class LegalCaseResourceFromEntityAssembler {
    public static LegalCaseResource toEntityFromResource(LegalCase entity, ConsultationResource consultationResource) {
        return new LegalCaseResource(
                entity.getId(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getStatus().name(),
                consultationResource,
                entity.getDocuments().getDocumentsItems().stream().map(DocumentsItemResourceFromEntityAssembler::toEntityFromResource).toList()
        );
    }
}
