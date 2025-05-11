package upc.LoremIpsum.lawconnectplatform.consultation.interfaces.rest.transform;

import upc.LoremIpsum.lawconnectplatform.consultation.domain.model.commands.CreateConsultationCommand;
import upc.LoremIpsum.lawconnectplatform.consultation.interfaces.rest.resources.CreateConsultationResource;

public class CreateConsultationCommandFromResourceAssembler {
    public static CreateConsultationCommand toCommandFromResource(CreateConsultationResource resource){
        return new CreateConsultationCommand(
                resource.lawyerId(),
                resource.clientId(),
                resource.description(),
                resource.Currency(),
                resource.type(),
                resource.title()
        );
    }
}
