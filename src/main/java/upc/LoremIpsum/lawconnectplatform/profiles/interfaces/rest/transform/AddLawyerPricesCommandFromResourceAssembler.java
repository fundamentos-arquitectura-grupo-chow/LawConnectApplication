package upc.LoremIpsum.lawconnectplatform.profiles.interfaces.rest.transform;

import upc.LoremIpsum.lawconnectplatform.profiles.domain.model.commands.AddLawyerPricesCommand;
import upc.LoremIpsum.lawconnectplatform.profiles.interfaces.rest.resources.AddLawyerPricesResource;

public class AddLawyerPricesCommandFromResourceAssembler {
    public static AddLawyerPricesCommand ToCommandFromResource(AddLawyerPricesResource resource) {
        return new AddLawyerPricesCommand(
                resource.lawyerId(),
                resource.price()
        );
    }
}
