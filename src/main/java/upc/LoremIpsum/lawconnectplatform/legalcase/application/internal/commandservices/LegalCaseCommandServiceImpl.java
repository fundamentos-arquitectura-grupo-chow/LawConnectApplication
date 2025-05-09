package upc.LoremIpsum.lawconnectplatform.legalcase.application.internal.commandservices;

import upc.LoremIpsum.lawconnectplatform.legalcase.application.internal.outboundServices.ExternalConsultationLegalCaseService;
import upc.LoremIpsum.lawconnectplatform.legalcase.domain.model.aggregates.LegalCase;
import upc.LoremIpsum.lawconnectplatform.legalcase.domain.model.commands.CloseLegalCaseCommand;
import upc.LoremIpsum.lawconnectplatform.legalcase.domain.model.commands.CreateLegalCaseCommand;
import upc.LoremIpsum.lawconnectplatform.legalcase.domain.model.commands.DeleteLegalCaseCommand;
import upc.LoremIpsum.lawconnectplatform.legalcase.domain.services.LegalCaseCommandService;
import upc.LoremIpsum.lawconnectplatform.legalcase.infrastructure.persistence.jpa.repositories.LegalCaseRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LegalCaseCommandServiceImpl implements LegalCaseCommandService {

    private final LegalCaseRepository legalCaseRepository;
    private final ExternalConsultationLegalCaseService externalConsultationLegalCaseService;

    public LegalCaseCommandServiceImpl(LegalCaseRepository legalCaseRepository, ExternalConsultationLegalCaseService externalConsultationLegalCaseService) {
        this.legalCaseRepository = legalCaseRepository;
        this.externalConsultationLegalCaseService = externalConsultationLegalCaseService;
    }

    @Override
    public Optional<LegalCase> handle(CreateLegalCaseCommand command) {

        var consultation = externalConsultationLegalCaseService.getConsultationById(command.consultationId());

        var legalCase = new LegalCase(command, consultation.get());
        legalCaseRepository.save(legalCase);

        return Optional.of(legalCase);
    }

    @Override
    public void handle(CloseLegalCaseCommand command) {
            var legalCase = legalCaseRepository.findById(command.legalCaseId());
            legalCase.ifPresent(LegalCase::close);
            legalCaseRepository.save(legalCase.get());
    }

    @Override
    public void handle(DeleteLegalCaseCommand command) {
        var legalCase = legalCaseRepository.findById(command.legalCaseId());
        legalCase.ifPresent(legalCaseRepository::delete);
    }


}
