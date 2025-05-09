package upc.LoremIpsum.lawconnectplatform.profiles.interfaces.rest.transform;

import upc.LoremIpsum.lawconnectplatform.profiles.domain.model.commands.IncrementConsultationsMadeCommand;
import upc.LoremIpsum.lawconnectplatform.profiles.interfaces.rest.resources.IncrementConsultationsMadeResource;

public class IncrementsConsultationsMadeCommandFromResourceAssembler {
    public static IncrementConsultationsMadeCommand ToCommandFromResource(IncrementConsultationsMadeResource resource){
        return new IncrementConsultationsMadeCommand(
                resource.id()
        );
    }
}
