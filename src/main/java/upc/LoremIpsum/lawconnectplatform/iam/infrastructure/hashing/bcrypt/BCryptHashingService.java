package upc.LoremIpsum.lawconnectplatform.iam.infrastructure.hashing.bcrypt;

import upc.LoremIpsum.lawconnectplatform.iam.application.internal.outboundservices.hashing.HashingService;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface BCryptHashingService extends HashingService, PasswordEncoder {
}
