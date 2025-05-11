package upc.LoremIpsum.lawconnectplatform.communication.domain.services;

import upc.LoremIpsum.lawconnectplatform.communication.domain.model.aggregates.VideoCall;
import upc.LoremIpsum.lawconnectplatform.communication.domain.model.queries.GetAllVideoCallsByConsultationId;

import java.util.List;
import java.util.Optional;

public interface VideoCallQueryService {
    List<VideoCall> handle(GetAllVideoCallsByConsultationId query);
}
