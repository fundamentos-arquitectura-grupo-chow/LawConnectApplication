package upc.LoremIpsum.lawconnectplatform.iam.domain.services;

import upc.LoremIpsum.lawconnectplatform.iam.domain.model.commands.SeedRolesCommand;

public interface RoleCommandService {
    void handle(SeedRolesCommand command);
}
