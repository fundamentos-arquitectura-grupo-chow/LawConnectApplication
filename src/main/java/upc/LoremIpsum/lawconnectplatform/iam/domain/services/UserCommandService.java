package upc.LoremIpsum.lawconnectplatform.iam.domain.services;

import upc.LoremIpsum.lawconnectplatform.iam.domain.model.aggregates.User;
import upc.LoremIpsum.lawconnectplatform.iam.domain.model.commands.SignInCommand;
import upc.LoremIpsum.lawconnectplatform.iam.domain.model.commands.SignUpCommand;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.Optional;

public interface UserCommandService {
    Optional<ImmutablePair<User, String>> handle(SignInCommand command);
    Optional<User> handle(SignUpCommand command);


}
