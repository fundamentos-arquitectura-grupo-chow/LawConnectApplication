package upc.LoremIpsum.lawconnectplatform.profiles.domain.model.commands;

public record AddLawyerTypeCommand (
        Long lawyerId,
        Integer lawyerTypeId
) {
}
