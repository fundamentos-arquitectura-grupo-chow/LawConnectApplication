package upc.LoremIpsum.lawconnectplatform.feeing.domain.services;

import upc.LoremIpsum.lawconnectplatform.feeing.domain.model.aggregates.Payment;
import upc.LoremIpsum.lawconnectplatform.feeing.domain.model.commands.CompletePaymentCommand;
import upc.LoremIpsum.lawconnectplatform.feeing.domain.model.commands.CreatePaymentCommand;
import upc.LoremIpsum.lawconnectplatform.feeing.domain.model.commands.DeletePaymentCommand;

import java.util.Optional;

public interface PaymentCommandService {
    Optional<Payment> handle(CreatePaymentCommand command);
    Optional<Payment> handle(CompletePaymentCommand command);
    void handle(DeletePaymentCommand command);
}
