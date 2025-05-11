package upc.LoremIpsum.lawconnectplatform.communication.application.internal.outboundServices;

import upc.LoremIpsum.lawconnectplatform.feeing.domain.model.aggregates.Payment;
import upc.LoremIpsum.lawconnectplatform.feeing.interfaces.acl.PaymentContextFacade;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExternalPaymentCommunicationService {

    private final PaymentContextFacade paymentContextFacade;

    public ExternalPaymentCommunicationService(PaymentContextFacade paymentContextFacade) {
        this.paymentContextFacade = paymentContextFacade;
    }

    public Optional<Payment> getPaymentById(Long paymentId) {
        return paymentContextFacade.getPaymentById(paymentId);
    }
}
