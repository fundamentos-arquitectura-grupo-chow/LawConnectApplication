package upc.LoremIpsum.lawconnectplatform.communication.interfaces.rest.transform;

import upc.LoremIpsum.lawconnectplatform.communication.domain.model.entities.MessageItem;
import upc.LoremIpsum.lawconnectplatform.communication.interfaces.rest.resources.MessageResource;

public class MessageResourceFromEntityAssembler {
    public static MessageResource toResourceFromEntity(MessageItem entity){
        return new MessageResource(
                entity.getId(),
                entity.getContent(),
                entity.getChatRoom().getId(),
                entity.isRead(),
                entity.getSenderType().toString()
        );
    }
}
