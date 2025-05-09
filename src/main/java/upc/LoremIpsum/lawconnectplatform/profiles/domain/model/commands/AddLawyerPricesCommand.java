package upc.LoremIpsum.lawconnectplatform.profiles.domain.model.commands;

public record AddLawyerPricesCommand(
        Long lawyerId,
        double price
) {
}
