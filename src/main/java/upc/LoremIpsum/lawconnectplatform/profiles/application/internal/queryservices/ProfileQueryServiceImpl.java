package upc.LoremIpsum.lawconnectplatform.profiles.application.internal.queryservices;

import upc.LoremIpsum.lawconnectplatform.profiles.domain.model.aggregates.Profile;
import upc.LoremIpsum.lawconnectplatform.profiles.domain.model.queries.GetAllProfilesQuery;
import upc.LoremIpsum.lawconnectplatform.profiles.domain.model.queries.GetProfileByIdQuery;
import upc.LoremIpsum.lawconnectplatform.profiles.domain.services.ProfileQueryService;
import upc.LoremIpsum.lawconnectplatform.profiles.infrastructure.persistence.jpa.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileQueryServiceImpl implements ProfileQueryService {

    private final ProfileRepository profileRepository;

    public ProfileQueryServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public List<Profile> handle(GetAllProfilesQuery query) {
        return profileRepository.findAll();
    }

    @Override
    public Optional<Profile> handle(GetProfileByIdQuery query) {
        return profileRepository.findById(query.profileId());
    }
}
