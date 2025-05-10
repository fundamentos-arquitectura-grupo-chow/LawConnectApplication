package upc.LoremIpsum.lawconnectplatform.feeing.interfaces.rest.resources;

import upc.LoremIpsum.lawconnectplatform.feeing.domain.model.valueObjects.PaymentStatus;

public record PaymentResource(
        Long id,
        Long clientId,
        String amount,
        PaymentStatus status,
        Long consultationId
){

}
