package upc.LoremIpsum.lawconnectplatform.communication.application.internal.outboundServices;

import upc.LoremIpsum.lawconnectplatform.followup.domain.model.commands.CreateNotificationCommand;
import upc.LoremIpsum.lawconnectplatform.followup.interfaces.acl.FollowUpContextFacade;
import org.springframework.stereotype.Service;

@Service
public class ExternalFollowUpCommunicationService {

    private final FollowUpContextFacade followUpContextFacade;

    public ExternalFollowUpCommunicationService(FollowUpContextFacade followUpContextFacade) {
        this.followUpContextFacade = followUpContextFacade;
    }

    public void createNotification(
            String title,
            String description,
            Long clientId,
            Long consultationId
    ) {
        followUpContextFacade.createNotification(
                        title,
                        description,
                        clientId,
                        consultationId
        );
    }
}
