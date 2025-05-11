package upc.LoremIpsum.lawconnectplatform.communication.interfaces.rest.transform;

import upc.LoremIpsum.lawconnectplatform.communication.domain.model.aggregates.VideoCall;
import upc.LoremIpsum.lawconnectplatform.communication.interfaces.rest.resources.VideoCallResource;
import upc.LoremIpsum.lawconnectplatform.consultation.interfaces.rest.resources.ConsultationResource;

public class VideoCallResourceFromEntityAssembler {
    public static VideoCallResource toResourceFromEntity(VideoCall entity, ConsultationResource consultationResource){
        return new VideoCallResource(
                entity.getId(),
                consultationResource,
                entity.getDescription(),
                entity.getStatus().toString()
        );
    }
}
