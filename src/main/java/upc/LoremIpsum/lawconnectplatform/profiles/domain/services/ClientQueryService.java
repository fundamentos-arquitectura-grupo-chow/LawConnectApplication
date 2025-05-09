package upc.LoremIpsum.lawconnectplatform.profiles.domain.services;

import upc.LoremIpsum.lawconnectplatform.profiles.domain.model.aggregates.Client;
import upc.LoremIpsum.lawconnectplatform.profiles.domain.model.queries.GetAllClientsQuery;
import upc.LoremIpsum.lawconnectplatform.profiles.domain.model.queries.GetClientByIdQuery;
import upc.LoremIpsum.lawconnectplatform.profiles.domain.model.queries.GetClientIdByEmailQuery;

import java.util.List;
import java.util.Optional;

public interface ClientQueryService {
    List<Client> handle(GetAllClientsQuery query);
    Optional<Client> handle(GetClientByIdQuery query);
    Optional<Long> handle(GetClientIdByEmailQuery query);
}
