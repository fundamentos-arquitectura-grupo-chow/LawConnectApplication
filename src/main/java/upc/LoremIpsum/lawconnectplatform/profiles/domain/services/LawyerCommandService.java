package upc.LoremIpsum.lawconnectplatform.profiles.domain.services;

import upc.LoremIpsum.lawconnectplatform.profiles.domain.model.aggregates.Lawyer;
import upc.LoremIpsum.lawconnectplatform.profiles.domain.model.commands.AddLawyerPricesCommand;
import upc.LoremIpsum.lawconnectplatform.profiles.domain.model.commands.AddLawyerTypeCommand;
import upc.LoremIpsum.lawconnectplatform.profiles.domain.model.commands.CreateLawyerCommand;

import java.util.Optional;

public interface LawyerCommandService {
    Optional<Lawyer> handle(CreateLawyerCommand command);
    void handle(AddLawyerPricesCommand command);
    void handle(AddLawyerTypeCommand command);
}
