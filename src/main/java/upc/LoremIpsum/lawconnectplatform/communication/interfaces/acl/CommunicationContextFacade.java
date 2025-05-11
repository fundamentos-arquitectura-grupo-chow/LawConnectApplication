package upc.LoremIpsum.lawconnectplatform.communication.interfaces.acl;

import upc.LoremIpsum.lawconnectplatform.communication.domain.model.commands.CreateChatRoomCommand;
import upc.LoremIpsum.lawconnectplatform.communication.domain.model.commands.DeleteChatRoomCommand;
import upc.LoremIpsum.lawconnectplatform.communication.domain.services.ChatRoomCommandService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class CommunicationContextFacade {

    private final ChatRoomCommandService chatRoomCommandService;

    public CommunicationContextFacade(
            @Lazy ChatRoomCommandService chatRoomCommandService
    ) {
        this.chatRoomCommandService = chatRoomCommandService;
    }

    public void createChatRoom(
            Long consultationId
    ){
        chatRoomCommandService.handle(new CreateChatRoomCommand(
                        consultationId
                )
        );
    }

    public void deleteChatRoom(
            Long consultationId
    ){
        chatRoomCommandService.handle(new DeleteChatRoomCommand(
                        consultationId
                )
        );
    }
}
