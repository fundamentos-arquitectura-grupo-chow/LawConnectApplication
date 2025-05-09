package upc.LoremIpsum.lawconnectplatform.iam.interfaces.rest.transform;

import upc.LoremIpsum.lawconnectplatform.iam.domain.model.commands.SignUpCommand;
import upc.LoremIpsum.lawconnectplatform.iam.domain.model.entities.Role;
import upc.LoremIpsum.lawconnectplatform.iam.interfaces.rest.resources.SignUpResource;

import java.util.ArrayList;

public class SignUpCommandFromResourceAssembler {
    public static SignUpCommand toCommandFromResource(SignUpResource resource) {
        var roles = resource.roles() != null ? resource.roles().stream().map(name -> Role.toRoleFromName(name)).toList() : new ArrayList<Role>();
        return new SignUpCommand(
                resource.email(),
                resource.password(),
                roles,
                resource.firstName(),
                resource.lastName(),
                resource.phoneNumber(),
                resource.address(),
                resource.dni(),
                resource.image_url()
        );
    }
}
