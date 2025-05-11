package upc.LoremIpsum.lawconnectplatform.consultation.domain.model.commands;

public record CreateConsultationCommand(
        Long lawyerId,
        Long clientId,
        String description,
        Integer Currency,
        Integer type,
        String title
) {
}
