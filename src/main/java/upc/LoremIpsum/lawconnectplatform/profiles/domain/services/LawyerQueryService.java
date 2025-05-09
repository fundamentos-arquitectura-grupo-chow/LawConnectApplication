package upc.LoremIpsum.lawconnectplatform.profiles.domain.services;

import upc.LoremIpsum.lawconnectplatform.profiles.domain.model.aggregates.Lawyer;
import upc.LoremIpsum.lawconnectplatform.profiles.domain.model.queries.*;
import upc.LoremIpsum.lawconnectplatform.profiles.domain.model.valueobjects.LawyerType;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface LawyerQueryService {
    List<Lawyer> handle(GetAllLawyersQuery query);
    Optional<Lawyer> handle(GetLawyerByIdQuery query);
    Set<LawyerType> handle(GetLawyerTypeByIdQuery query);
    Optional<Long> handle(GetLawyerIdByEmailQuery query);
}
