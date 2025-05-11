package upc.LoremIpsum.lawconnectplatform.consultation.application.internal.outboundServices;

import upc.LoremIpsum.lawconnectplatform.communication.interfaces.acl.CommunicationContextFacade;
import org.springframework.stereotype.Service;

@Service
public class ExternalCommunicationConsultationService {

    private final CommunicationContextFacade communicationContextFacade;

    public ExternalCommunicationConsultationService(CommunicationContextFacade communicationContextFacade) {
        this.communicationContextFacade = communicationContextFacade;
    }

    public void createChatRoom(
            Long consultationId
    ){
        communicationContextFacade.createChatRoom(
                consultationId
            );
    }

    public void deleteChatRoom(
            Long consultationId
    ){
        communicationContextFacade.deleteChatRoom(
                consultationId
            );
    }
}
