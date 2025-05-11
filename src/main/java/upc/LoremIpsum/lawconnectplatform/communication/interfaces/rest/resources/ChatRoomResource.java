package upc.LoremIpsum.lawconnectplatform.communication.interfaces.rest.resources;

import upc.LoremIpsum.lawconnectplatform.communication.domain.model.entities.MessageItem;
import upc.LoremIpsum.lawconnectplatform.consultation.domain.model.aggregates.Consultation;
import upc.LoremIpsum.lawconnectplatform.consultation.interfaces.rest.resources.ConsultationResource;

import java.util.List;

public record ChatRoomResource(
        Long id,
        ConsultationResource consultation,
        String status,
        List<MessageResource> messages
) {
}
