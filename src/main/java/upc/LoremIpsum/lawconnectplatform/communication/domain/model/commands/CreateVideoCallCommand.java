package upc.LoremIpsum.lawconnectplatform.communication.domain.model.commands;

public record CreateVideoCallCommand(
        Long consultationId,
        String description
) {
}
