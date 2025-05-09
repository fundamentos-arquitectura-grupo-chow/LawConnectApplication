package upc.LoremIpsum.lawconnectplatform.followup.interfaces.acl;

import upc.LoremIpsum.lawconnectplatform.followup.domain.model.commands.CreateNotificationCommand;
import upc.LoremIpsum.lawconnectplatform.followup.domain.services.NotificationCommandService;
import upc.LoremIpsum.lawconnectplatform.followup.domain.services.NotificationQueryService;
import org.springframework.stereotype.Service;

@Service
public class FollowUpContextFacade {

    private final NotificationCommandService notificationCommandService;
    private final NotificationQueryService notificationQueryService;

    public FollowUpContextFacade(NotificationCommandService notificationCommandService, NotificationQueryService notificationQueryService) {
        this.notificationCommandService = notificationCommandService;
        this.notificationQueryService = notificationQueryService;
    }

    public void createNotification(
            String title,
            String description,
            Long clientId,
            Long consultationId
    ) {
        notificationCommandService.handle(new CreateNotificationCommand(
                        title,
                        description,
                        clientId,
                        consultationId
                )
        );
    }

}
