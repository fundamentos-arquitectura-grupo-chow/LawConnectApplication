package upc.LoremIpsum.lawconnectplatform.communication.interfaces.rest.resources;

public record CreateVideoCallResource(
        Long consultationId,
        String description,
        String location
) {
}
