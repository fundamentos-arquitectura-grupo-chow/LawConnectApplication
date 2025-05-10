package upc.LoremIpsum.lawconnectplatform.feeing.interfaces.rest.transform;

import upc.LoremIpsum.lawconnectplatform.feeing.domain.model.commands.CompletePaymentCommand;
import upc.LoremIpsum.lawconnectplatform.feeing.interfaces.rest.resources.CompletePaymentResource;

import java.time.LocalDate;

public class CompletePaymentCommandFromResourceAssembler {
    public static CompletePaymentCommand toCommandFromResource(CompletePaymentResource resource, Long paymentId){

        String[] dateParts = resource.expirationDate().split("-");
        int year = Integer.parseInt(dateParts[0]);
        System.out.println(year);
        int month = Integer.parseInt(dateParts[1]);
        System.out.println(month);

        LocalDate expirationDateYYYYMM = LocalDate.of(year, month, 1);

        System.out.println(expirationDateYYYYMM);

        return new CompletePaymentCommand(
                paymentId,
                resource.cardNumber(),
                expirationDateYYYYMM,
                resource.cvv()
        );
    }
}
