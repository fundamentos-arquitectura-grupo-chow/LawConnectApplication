package upc.LoremIpsum.lawconnectplatform.profiles.interfaces.rest.transform;

import upc.LoremIpsum.lawconnectplatform.profiles.domain.model.aggregates.Lawyer;
import upc.LoremIpsum.lawconnectplatform.profiles.domain.model.valueobjects.LawyerType;
import upc.LoremIpsum.lawconnectplatform.profiles.interfaces.rest.resources.LawyerResource;

import java.util.Set;
import java.util.stream.Collectors;

public class LawyerResourceFromEntityAssembler {
    public static LawyerResource ToEntityFromResource(Lawyer entity) {
        Set<String> lawyerTypeStrings = entity.getLawyerTypes().stream()
                .map(LawyerType::name)
                .collect(Collectors.toSet());


        return new LawyerResource(
                entity.getId(),
                entity.getProfile(),
                lawyerTypeStrings,
                entity.getPrices()
        );
    }
}
