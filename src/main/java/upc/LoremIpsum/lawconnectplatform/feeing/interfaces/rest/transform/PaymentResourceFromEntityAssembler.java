package upc.LoremIpsum.lawconnectplatform.feeing.interfaces.rest.transform;

import upc.LoremIpsum.lawconnectplatform.feeing.domain.model.aggregates.Payment;
import upc.LoremIpsum.lawconnectplatform.feeing.interfaces.rest.resources.PaymentResource;

public class PaymentResourceFromEntityAssembler {
    public static PaymentResource toResourceFromEntity(Payment entity){
        return new PaymentResource(
                entity.getId(),
                entity.getClientId(),
                entity.getAmount().paymentAmountToString(),
                entity.getStatus(),
                entity.getConsultationId()
        );
    }
}
