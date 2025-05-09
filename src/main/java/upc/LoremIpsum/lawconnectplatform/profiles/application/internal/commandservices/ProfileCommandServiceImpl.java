package upc.LoremIpsum.lawconnectplatform.profiles.application.internal.commandservices;

import upc.LoremIpsum.lawconnectplatform.profiles.domain.model.aggregates.Profile;
import upc.LoremIpsum.lawconnectplatform.profiles.domain.model.commands.CreateProfileCommand;
import upc.LoremIpsum.lawconnectplatform.profiles.domain.model.valueobjects.EmailAddress;
import upc.LoremIpsum.lawconnectplatform.profiles.domain.services.ProfileCommandService;
import upc.LoremIpsum.lawconnectplatform.profiles.infrastructure.persistence.jpa.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileCommandServiceImpl implements ProfileCommandService {

    private final ProfileRepository profileRepository;

    public ProfileCommandServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Optional<Profile> handle(CreateProfileCommand command) {
        var emailAddress = new EmailAddress(command.email());
        if (profileRepository.existsByEmail(emailAddress))
            throw new IllegalArgumentException(
                    "Profile with email " + command.email() + " already exists");
        var profile = new Profile(command);
        profileRepository.save(profile);
        return Optional.of(profile);
    }
}
