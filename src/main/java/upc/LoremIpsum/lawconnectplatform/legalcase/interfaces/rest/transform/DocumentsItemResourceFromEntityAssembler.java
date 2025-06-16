package upc.LoremIpsum.lawconnectplatform.legalcase.interfaces.rest.transform;

import upc.LoremIpsum.lawconnectplatform.legalcase.domain.model.entities.DocumentsItem;
import upc.LoremIpsum.lawconnectplatform.legalcase.interfaces.rest.resources.DocumentsItemResource;

public class DocumentsItemResourceFromEntityAssembler {
    public static DocumentsItemResource toResourceFromEntity(DocumentsItem entity){
        return new DocumentsItemResource(
                entity.getId(),
                entity.getTitle(),
                entity.getType().name(),
                entity.getDescription(),
                entity.getLegalCase().getId(),
                entity.getStatus().name()
        );
    }
}