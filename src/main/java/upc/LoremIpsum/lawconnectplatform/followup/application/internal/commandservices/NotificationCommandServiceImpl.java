package upc.LoremIpsum.lawconnectplatform.followup.application.internal.commandservices;

import upc.LoremIpsum.lawconnectplatform.followup.domain.model.aggregates.Notification;
import upc.LoremIpsum.lawconnectplatform.followup.domain.model.commands.CreateNotificationCommand;
import upc.LoremIpsum.lawconnectplatform.followup.domain.model.commands.DeleteNotificationCommand;
import upc.LoremIpsum.lawconnectplatform.followup.domain.services.NotificationCommandService;
import upc.LoremIpsum.lawconnectplatform.followup.infrastructure.persistence.jpa.repositories.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NotificationCommandServiceImpl implements NotificationCommandService {

    private final NotificationRepository notificationRepository;

    public NotificationCommandServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public Optional<Notification> handle(CreateNotificationCommand command) {

        var notification = new Notification(command);

        notificationRepository.save(notification);

        return Optional.of(notification);
    }

    @Override
    public void handle(DeleteNotificationCommand command) {
        notificationRepository.deleteById(command.notificationId());
    }
}
