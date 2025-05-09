package upc.LoremIpsum.lawconnectplatform.profiles.interfaces.rest.transform;

import upc.LoremIpsum.lawconnectplatform.profiles.domain.model.aggregates.Profile;
import upc.LoremIpsum.lawconnectplatform.profiles.interfaces.rest.resources.ProfileResource;

public class ProfileResourceFromEntityAssembler {
    public static ProfileResource ToResourceFromEntity(Profile entity) {
        return new ProfileResource(
                entity.getId(),
                entity.getName().firstName(),
                entity.getName().lastName(),
                entity.getEmail().address(),
                entity.getPhoneNumber(),
                entity.getAddress(),
                entity.getDNI(),
                entity.getImage_url()
        );
    }
}
