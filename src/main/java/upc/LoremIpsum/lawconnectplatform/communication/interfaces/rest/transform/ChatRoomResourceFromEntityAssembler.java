package upc.LoremIpsum.lawconnectplatform.communication.interfaces.rest.transform;

import upc.LoremIpsum.lawconnectplatform.communication.domain.model.aggregates.ChatRoom;
import upc.LoremIpsum.lawconnectplatform.communication.interfaces.rest.resources.ChatRoomResource;
import upc.LoremIpsum.lawconnectplatform.consultation.interfaces.rest.resources.ConsultationResource;

public class ChatRoomResourceFromEntityAssembler {
    public static ChatRoomResource toResourceFromEntity(ChatRoom entity, ConsultationResource consultationResource){
        return new ChatRoomResource(
                entity.getId(),
                consultationResource,
                entity.getStatus().toString(),
                entity.getMessages().getMessages().stream().map(MessageResourceFromEntityAssembler::toResourceFromEntity).toList()
        );
    }
}
