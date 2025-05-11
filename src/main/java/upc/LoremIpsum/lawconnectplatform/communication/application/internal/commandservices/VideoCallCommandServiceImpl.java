package upc.LoremIpsum.lawconnectplatform.communication.application.internal.commandservices;

import upc.LoremIpsum.lawconnectplatform.communication.application.internal.outboundServices.ExternalConsultationCommunicationService;
import upc.LoremIpsum.lawconnectplatform.communication.application.internal.outboundServices.ExternalFollowUpCommunicationService;
import upc.LoremIpsum.lawconnectplatform.communication.application.internal.outboundServices.ExternalPaymentCommunicationService;
import upc.LoremIpsum.lawconnectplatform.communication.domain.model.aggregates.VideoCall;
import upc.LoremIpsum.lawconnectplatform.communication.domain.model.commands.CreateVideoCallCommand;
import upc.LoremIpsum.lawconnectplatform.communication.domain.services.VideoCallCommandService;
import upc.LoremIpsum.lawconnectplatform.communication.infrastructure.persistence.jpa.repositories.VideoCallRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VideoCallCommandServiceImpl implements VideoCallCommandService {

    private final VideoCallRepository videoCallRepository;
    private final ExternalConsultationCommunicationService externalConsultationCommunicationService;
    private final ExternalFollowUpCommunicationService externalFollowUpCommunicationService;
    private final ExternalPaymentCommunicationService externalPaymentCommunicationService;

    public VideoCallCommandServiceImpl(VideoCallRepository videoCallRepository, ExternalConsultationCommunicationService externalConsultationCommunicationService, ExternalFollowUpCommunicationService externalFollowUpCommunicationService, ExternalPaymentCommunicationService externalPaymentCommunicationService) {
        this.videoCallRepository = videoCallRepository;
        this.externalConsultationCommunicationService = externalConsultationCommunicationService;
        this.externalFollowUpCommunicationService = externalFollowUpCommunicationService;
        this.externalPaymentCommunicationService = externalPaymentCommunicationService;
    }

    @Override
    public Optional<VideoCall> handle(CreateVideoCallCommand command) {

        var consultation = externalConsultationCommunicationService.getConsultationById(command.consultationId());

        if (consultation.isEmpty()) {
            throw new IllegalArgumentException("Consultation not found");
        }


        var VideoCall = new VideoCall(command, consultation.get());

        videoCallRepository.save(VideoCall);

        externalFollowUpCommunicationService.createNotification(
                "Video Call created",
                command.description(),
                consultation.get().getClientId(),
                consultation.get().getId()
        );

        return Optional.of(VideoCall);
    }
}
