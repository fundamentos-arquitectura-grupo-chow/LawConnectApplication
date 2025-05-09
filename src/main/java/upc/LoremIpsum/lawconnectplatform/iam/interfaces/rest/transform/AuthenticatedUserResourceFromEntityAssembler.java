package upc.LoremIpsum.lawconnectplatform.iam.interfaces.rest.transform;

import upc.LoremIpsum.lawconnectplatform.iam.domain.model.aggregates.User;
import upc.LoremIpsum.lawconnectplatform.iam.interfaces.rest.resources.AuthenticatedUserResource;

public class AuthenticatedUserResourceFromEntityAssembler {
    public static AuthenticatedUserResource toResourceFromEntity(User user, String token) {
        return new AuthenticatedUserResource(
                user.getId(),
                user.getUsername(),
                token,
                user.getRoles().toString()
        );
    }
}
