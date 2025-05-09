package upc.LoremIpsum.lawconnectplatform.profiles.interfaces.rest.transform;

import upc.LoremIpsum.lawconnectplatform.profiles.domain.model.commands.IncrementPaidServicesCommand;
import upc.LoremIpsum.lawconnectplatform.profiles.interfaces.rest.resources.IncrementPaidServicesResource;

public class IncrementPaidServicesCommandFromResourceAssembler {
    public static IncrementPaidServicesCommand ToCommandFromResource(IncrementPaidServicesResource resource){
        return new IncrementPaidServicesCommand(resource.id());
    }
}
