package upc.LoremIpsum.lawconnectplatform.iam.interfaces.rest.transform;

import upc.LoremIpsum.lawconnectplatform.iam.domain.model.entities.Role;
import upc.LoremIpsum.lawconnectplatform.iam.interfaces.rest.resources.RoleResource;

public class RoleResourceFromEntityAssembler {
    public static RoleResource toResourceFromEntity(Role role) {
        return new RoleResource(role.getId(), role.getStringName());
    }
}
