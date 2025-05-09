package upc.LoremIpsum.lawconnectplatform.profiles.domain.services;

import upc.LoremIpsum.lawconnectplatform.profiles.domain.model.aggregates.Profile;
import upc.LoremIpsum.lawconnectplatform.profiles.domain.model.commands.CreateProfileCommand;

import java.util.Optional;

public interface ProfileCommandService {
    Optional<Profile> handle(CreateProfileCommand command);
}
