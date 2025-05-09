package upc.LoremIpsum.lawconnectplatform.followup.domain.services;

import upc.LoremIpsum.lawconnectplatform.followup.domain.model.aggregates.Notification;
import upc.LoremIpsum.lawconnectplatform.followup.domain.model.commands.CreateNotificationCommand;
import upc.LoremIpsum.lawconnectplatform.followup.domain.model.commands.DeleteNotificationCommand;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface NotificationCommandService {
    Optional<Notification> handle(CreateNotificationCommand command);
    void handle(DeleteNotificationCommand command);
}
