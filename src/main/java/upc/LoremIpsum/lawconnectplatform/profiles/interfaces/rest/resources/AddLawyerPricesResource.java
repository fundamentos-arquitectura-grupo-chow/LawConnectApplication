package upc.LoremIpsum.lawconnectplatform.profiles.interfaces.rest.resources;

public record AddLawyerPricesResource(
        Long lawyerId,
        double price
) {
}
