package upc.LoremIpsum.lawconnectplatform.communication.domain.services;

import upc.LoremIpsum.lawconnectplatform.communication.domain.model.aggregates.VideoCall;
import upc.LoremIpsum.lawconnectplatform.communication.domain.model.commands.CreateVideoCallCommand;

import java.util.Optional;

public interface VideoCallCommandService {
    Optional<VideoCall> handle(CreateVideoCallCommand command);
}
