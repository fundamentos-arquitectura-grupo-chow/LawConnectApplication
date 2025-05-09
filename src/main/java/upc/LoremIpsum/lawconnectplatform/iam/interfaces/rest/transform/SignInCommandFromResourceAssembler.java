package upc.LoremIpsum.lawconnectplatform.iam.interfaces.rest.transform;

import upc.LoremIpsum.lawconnectplatform.iam.domain.model.commands.SignInCommand;
import upc.LoremIpsum.lawconnectplatform.iam.interfaces.rest.resources.SignInResource;

public class SignInCommandFromResourceAssembler {
    public static SignInCommand toCommandFromResource(SignInResource signInResource) {
        return new SignInCommand(signInResource.username(), signInResource.password());
    }
}
