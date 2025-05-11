package upc.LoremIpsum.lawconnectplatform.communication.interfaces.rest.resources;

import upc.LoremIpsum.lawconnectplatform.communication.domain.model.aggregates.ChatRoom;

public record MessageResource (
        Long id,
        String content,
        Long chatRoomId,
        boolean isRead,
        String senderType
) {
}
