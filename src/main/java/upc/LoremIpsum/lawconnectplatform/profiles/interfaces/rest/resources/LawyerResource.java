package upc.LoremIpsum.lawconnectplatform.profiles.interfaces.rest.resources;

import upc.LoremIpsum.lawconnectplatform.profiles.domain.model.aggregates.Profile;

import java.util.Set;

public record LawyerResource(
        Long id,
        Profile profile,
        Set<String> lawyerTypes,
        Double Prices
) {
}
