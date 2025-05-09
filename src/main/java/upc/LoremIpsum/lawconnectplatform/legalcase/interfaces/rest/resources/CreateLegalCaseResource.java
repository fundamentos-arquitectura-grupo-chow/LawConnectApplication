package upc.LoremIpsum.lawconnectplatform.legalcase.interfaces.rest.resources;

public record CreateLegalCaseResource (
        String title,
        String description,
        Long consultationId
){
}
