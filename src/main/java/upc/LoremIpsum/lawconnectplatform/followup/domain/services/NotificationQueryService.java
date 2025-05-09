package upc.LoremIpsum.lawconnectplatform.followup.domain.services;

import upc.LoremIpsum.lawconnectplatform.followup.domain.model.aggregates.Notification;
import upc.LoremIpsum.lawconnectplatform.followup.domain.model.queries.GetAllNotificationByConsultationIdQuery;
import upc.LoremIpsum.lawconnectplatform.followup.domain.model.queries.GetAllNotificationsByClientIdQuery;
import upc.LoremIpsum.lawconnectplatform.followup.domain.model.queries.GetNotificationByIdQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface NotificationQueryService {
    List<Notification> handle(GetAllNotificationsByClientIdQuery query);
    List<Notification> handle(GetAllNotificationByConsultationIdQuery query);
    Optional<Notification> handle(GetNotificationByIdQuery query);
}
