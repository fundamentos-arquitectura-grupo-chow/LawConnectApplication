package upc.LoremIpsum.lawconnectplatform.profiles.domain.services;

import upc.LoremIpsum.lawconnectplatform.profiles.domain.model.aggregates.Profile;
import upc.LoremIpsum.lawconnectplatform.profiles.domain.model.queries.GetAllProfilesQuery;
import upc.LoremIpsum.lawconnectplatform.profiles.domain.model.queries.GetProfileByIdQuery;

import java.util.List;
import java.util.Optional;

public interface ProfileQueryService {
    List<Profile> handle(GetAllProfilesQuery query);
    Optional<Profile> handle(GetProfileByIdQuery query);
}
