package upc.LoremIpsum.lawconnectplatform.profiles.interfaces.rest.resources;

import upc.LoremIpsum.lawconnectplatform.profiles.domain.model.aggregates.Profile;

public record ClientResource(
        Long id,
        Profile profile,
        Integer consultationCount,
        Integer paidServices
) {
}
