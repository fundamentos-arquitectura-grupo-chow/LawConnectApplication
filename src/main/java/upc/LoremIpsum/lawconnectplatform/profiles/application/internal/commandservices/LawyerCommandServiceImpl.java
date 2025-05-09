package upc.LoremIpsum.lawconnectplatform.profiles.application.internal.commandservices;

import upc.LoremIpsum.lawconnectplatform.profiles.application.internal.outboundServices.ExternalIAMProfileService;
import upc.LoremIpsum.lawconnectplatform.profiles.domain.model.aggregates.Lawyer;
import upc.LoremIpsum.lawconnectplatform.profiles.domain.model.aggregates.Profile;
import upc.LoremIpsum.lawconnectplatform.profiles.domain.model.commands.AddLawyerPricesCommand;
import upc.LoremIpsum.lawconnectplatform.profiles.domain.model.commands.AddLawyerTypeCommand;
import upc.LoremIpsum.lawconnectplatform.profiles.domain.model.commands.CreateLawyerCommand;
import upc.LoremIpsum.lawconnectplatform.profiles.domain.model.valueobjects.EmailAddress;
import upc.LoremIpsum.lawconnectplatform.profiles.domain.services.LawyerCommandService;
import upc.LoremIpsum.lawconnectplatform.profiles.infrastructure.persistence.jpa.repositories.LawyerRepository;
import upc.LoremIpsum.lawconnectplatform.profiles.infrastructure.persistence.jpa.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LawyerCommandServiceImpl implements LawyerCommandService {

    private final LawyerRepository lawyerRepository;
    private final ProfileRepository profileRepository;
    private final ExternalIAMProfileService externalIAMProfileService;


    public LawyerCommandServiceImpl(LawyerRepository lawyerRepository, ProfileRepository profileRepository, ExternalIAMProfileService externalIAMProfileService) {
        this.lawyerRepository = lawyerRepository;
        this.profileRepository = profileRepository;
        this.externalIAMProfileService = externalIAMProfileService;
    }

    @Override
    public Optional<Lawyer> handle(CreateLawyerCommand command) {

        var profileId = profileRepository.findByEmail(new EmailAddress(command.email()));
        var profile = new Profile();

        if (profileId.isEmpty()) {
            var userId = externalIAMProfileService.getUserIdByUsername(command.email());
            profile = new Profile(command, userId);
        } else {
            throw new IllegalArgumentException("Lawyer already exists");
        }

        var lawyer = new Lawyer(profile);

        profileRepository.save(profile);
        lawyerRepository.save(lawyer);

        return Optional.of(lawyer);
    }

    @Override
    public void handle(AddLawyerPricesCommand command) {
        if (lawyerRepository.findById(command.lawyerId()).isEmpty()) {
            throw new IllegalArgumentException("Lawyer not found");
        }
        var lawyer = lawyerRepository.findById(command.lawyerId()).get();
        lawyer.setPrices(command);

        lawyerRepository.save(lawyer);
    }

    @Override
    public void handle(AddLawyerTypeCommand command) {
        if (lawyerRepository.findById(command.lawyerId()).isEmpty()) {
            throw new IllegalArgumentException("Lawyer not found");
        }
        var lawyer = lawyerRepository.findById(command.lawyerId()).get();
        lawyer.addLawyerType(command);

        lawyerRepository.save(lawyer);
    }
}
