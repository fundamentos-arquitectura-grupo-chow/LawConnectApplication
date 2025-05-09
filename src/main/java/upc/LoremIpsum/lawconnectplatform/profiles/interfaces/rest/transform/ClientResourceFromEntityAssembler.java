package upc.LoremIpsum.lawconnectplatform.profiles.interfaces.rest.transform;

import upc.LoremIpsum.lawconnectplatform.profiles.domain.model.aggregates.Client;
import upc.LoremIpsum.lawconnectplatform.profiles.interfaces.rest.resources.ClientResource;

public class ClientResourceFromEntityAssembler {
    public static ClientResource ToResourceFromEntity(Client entity){
        return new ClientResource(
                entity.getId(),
                entity.getProfile(),
                entity.getConsultationCount(),
                entity.getPaidServices()
        );
    }
}
