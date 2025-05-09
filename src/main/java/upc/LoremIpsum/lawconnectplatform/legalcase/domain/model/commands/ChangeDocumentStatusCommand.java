package upc.LoremIpsum.lawconnectplatform.legalcase.domain.model.commands;

public record ChangeDocumentStatusCommand(Long documentId, Integer status) {
}
