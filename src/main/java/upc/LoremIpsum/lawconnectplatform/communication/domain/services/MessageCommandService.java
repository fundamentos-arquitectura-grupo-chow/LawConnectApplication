package upc.LoremIpsum.lawconnectplatform.communication.domain.services;

import upc.LoremIpsum.lawconnectplatform.communication.domain.model.commands.AddMessageByChatRoomIdCommand;


public interface MessageCommandService {
    void handle(AddMessageByChatRoomIdCommand command);
}
