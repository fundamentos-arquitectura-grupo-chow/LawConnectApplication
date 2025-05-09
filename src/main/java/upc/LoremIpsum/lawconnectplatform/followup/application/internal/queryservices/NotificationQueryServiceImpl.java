package upc.LoremIpsum.lawconnectplatform.followup.application.internal.queryservices;

import upc.LoremIpsum.lawconnectplatform.followup.domain.model.aggregates.Notification;
import upc.LoremIpsum.lawconnectplatform.followup.domain.model.queries.GetAllNotificationByConsultationIdQuery;
import upc.LoremIpsum.lawconnectplatform.followup.domain.model.queries.GetAllNotificationsByClientIdQuery;
import upc.LoremIpsum.lawconnectplatform.followup.domain.model.queries.GetNotificationByIdQuery;
import upc.LoremIpsum.lawconnectplatform.followup.domain.services.NotificationQueryService;
import upc.LoremIpsum.lawconnectplatform.followup.infrastructure.persistence.jpa.repositories.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationQueryServiceImpl implements NotificationQueryService {

    private final NotificationRepository notificationRepository;

    public NotificationQueryServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public List<Notification> handle(GetAllNotificationsByClientIdQuery query) {
        return notificationRepository.findAllByClientId(query.clientId());
    }

    @Override
    public List<Notification> handle(GetAllNotificationByConsultationIdQuery query) {
        return notificationRepository.findAllByConsultationId(query.consultationId());
    }

    @Override
    public Optional<Notification> handle(GetNotificationByIdQuery query) {
        return notificationRepository.findById(query.Id());
    }
}
