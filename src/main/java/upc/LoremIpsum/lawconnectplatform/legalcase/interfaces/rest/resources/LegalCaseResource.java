package upc.LoremIpsum.lawconnectplatform.legalcase.interfaces.rest.resources;

import upc.LoremIpsum.lawconnectplatform.consultation.interfaces.rest.resources.ConsultationResource;

import java.util.List;

public record LegalCaseResource(
        Long id,
        String title,
        String description,
        String status,
        ConsultationResource consultationId,
        List<DocumentsItemResource> documents
) {
}
