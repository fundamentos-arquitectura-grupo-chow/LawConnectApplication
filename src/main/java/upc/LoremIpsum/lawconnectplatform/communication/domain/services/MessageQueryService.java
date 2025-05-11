package upc.LoremIpsum.lawconnectplatform.communication.domain.services;

import upc.LoremIpsum.lawconnectplatform.communication.domain.model.entities.MessageItem;
import upc.LoremIpsum.lawconnectplatform.communication.domain.model.queries.GetAllMessagesByChatRoomIdQuery;

import java.util.List;
import java.util.Optional;

public interface MessageQueryService {
    List<MessageItem> handle(GetAllMessagesByChatRoomIdQuery query);
}
