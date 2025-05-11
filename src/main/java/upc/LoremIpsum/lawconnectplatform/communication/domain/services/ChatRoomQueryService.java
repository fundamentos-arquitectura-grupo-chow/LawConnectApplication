package upc.LoremIpsum.lawconnectplatform.communication.domain.services;

import upc.LoremIpsum.lawconnectplatform.communication.domain.model.aggregates.ChatRoom;
import upc.LoremIpsum.lawconnectplatform.communication.domain.model.queries.GetChatRoomByConsultationIdQuery;

import java.util.Optional;

public interface ChatRoomQueryService {
    Optional<ChatRoom> handle(GetChatRoomByConsultationIdQuery query);
}
