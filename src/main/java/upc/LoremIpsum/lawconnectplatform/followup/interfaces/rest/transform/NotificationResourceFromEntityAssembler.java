package upc.LoremIpsum.lawconnectplatform.followup.interfaces.rest.transform;

import upc.LoremIpsum.lawconnectplatform.followup.domain.model.aggregates.Notification;
import upc.LoremIpsum.lawconnectplatform.followup.interfaces.rest.resources.NotificationResource;

public class NotificationResourceFromEntityAssembler {
    public static NotificationResource toResourceFromEntity(Notification entity){
        return new NotificationResource(
                entity.getId(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getClientId(),
                entity.getConsultationId()
        );
    }
}
