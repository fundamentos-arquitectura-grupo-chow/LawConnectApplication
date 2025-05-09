package upc.LoremIpsum.lawconnectplatform.legalcase.application.internal.outboundServices;

import upc.LoremIpsum.lawconnectplatform.followup.interfaces.acl.FollowUpContextFacade;
import org.springframework.stereotype.Service;

@Service
public class ExternalFollowUpLegalCaseService {

    private final FollowUpContextFacade followUpContextFacade;

    public ExternalFollowUpLegalCaseService(FollowUpContextFacade followUpContextFacade) {
        this.followUpContextFacade = followUpContextFacade;
    }

    public void createNotification(
            String title,
            String description,
            Long clientId,
            Long consultationId
    ){
      followUpContextFacade.createNotification(
              title,
              description,
              clientId,
              consultationId
      );
    }

}
