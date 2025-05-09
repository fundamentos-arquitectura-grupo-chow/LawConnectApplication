package upc.LoremIpsum.lawconnectplatform.profiles.domain.services;

import upc.LoremIpsum.lawconnectplatform.profiles.domain.model.aggregates.Client;
import upc.LoremIpsum.lawconnectplatform.profiles.domain.model.commands.CreateClientCommand;
import upc.LoremIpsum.lawconnectplatform.profiles.domain.model.commands.IncrementConsultationsMadeCommand;
import upc.LoremIpsum.lawconnectplatform.profiles.domain.model.commands.IncrementPaidServicesCommand;

import java.util.Optional;

public interface ClientCommandService {
    Optional<Client> handle(CreateClientCommand command);
    void handle(IncrementPaidServicesCommand command);
    void handle(IncrementConsultationsMadeCommand command);
}
