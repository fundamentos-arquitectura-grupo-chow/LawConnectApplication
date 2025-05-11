package upc.LoremIpsum.lawconnectplatform.consultation.interfaces.rest.transform;

import upc.LoremIpsum.lawconnectplatform.consultation.domain.model.commands.CreatePaymentByConsultationIdCommand;
import upc.LoremIpsum.lawconnectplatform.consultation.interfaces.rest.resources.AddPaymentResource;

public class CreatePaymentCommandFromResourceAssembler {
    public static CreatePaymentByConsultationIdCommand toCommandFromResource(AddPaymentResource resource){
        return new CreatePaymentByConsultationIdCommand(
                resource.consultationId(),
                resource.amount(),
                resource.currency()
        );
    }
}
