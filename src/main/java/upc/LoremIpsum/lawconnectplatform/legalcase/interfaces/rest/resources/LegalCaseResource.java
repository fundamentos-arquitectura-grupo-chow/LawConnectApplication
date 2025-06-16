package upc.LoremIpsum.lawconnectplatform.legalcase.interfaces.rest.resources;

import java.util.List;

public record LegalCaseResource(
        Long id,
        String title,
        String description,
        String status,
        Long consultationId,
        List<DocumentsItemResource> documents
) {
}
