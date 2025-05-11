package upc.LoremIpsum.lawconnectplatform.consultation.interfaces.rest.resources;

public record AddPaymentResource(
        Long consultationId,
        Double amount,
        Integer currency
) {
}
