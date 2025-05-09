package upc.LoremIpsum.lawconnectplatform.followup.domain.model.commands;

public record CreateNotificationCommand(
        String title,
        String description,
        Long clientId,
        Long legalCaseId
) {
}
