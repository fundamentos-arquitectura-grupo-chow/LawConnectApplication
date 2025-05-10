package upc.LoremIpsum.lawconnectplatform.feeing.application.internal.commandServices;

import upc.LoremIpsum.lawconnectplatform.feeing.application.internal.outboundServices.ExternalConsultationPaymentService;
import upc.LoremIpsum.lawconnectplatform.feeing.domain.model.aggregates.Payment;
import upc.LoremIpsum.lawconnectplatform.feeing.domain.model.commands.CompletePaymentCommand;
import upc.LoremIpsum.lawconnectplatform.feeing.domain.model.commands.CreatePaymentCommand;
import upc.LoremIpsum.lawconnectplatform.feeing.domain.model.commands.DeletePaymentCommand;
import upc.LoremIpsum.lawconnectplatform.feeing.domain.model.valueObjects.PaymentStatus;
import upc.LoremIpsum.lawconnectplatform.feeing.domain.services.PaymentCommandService;
import upc.LoremIpsum.lawconnectplatform.feeing.infrastructure.persistence.jpa.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentCommandServiceImpl implements PaymentCommandService {

    private final PaymentRepository paymentRepository;
    private final ExternalConsultationPaymentService externalConsultationPaymentService;

    public PaymentCommandServiceImpl(
            PaymentRepository paymentRepository,
            @Lazy ExternalConsultationPaymentService externalConsultationPaymentService1) {
        this.paymentRepository = paymentRepository;
        this.externalConsultationPaymentService = externalConsultationPaymentService1;
    }

    @Override
    public Optional<Payment> handle(CreatePaymentCommand command) {
        var consultation = externalConsultationPaymentService.getConsultationById(command.consultationId());
        var payment = new Payment(command, consultation.get());
        System.out.println("Payment created");
        paymentRepository.save(payment);
        return Optional.of(payment);
    }

    @Override
    public Optional<Payment> handle(CompletePaymentCommand command) {

        if (command.cardNumber().length()!=16 || command.cvv().length()!=3){
            return Optional.empty();
        }

        var payment = paymentRepository.findById(command.paymentId());
        if (payment.isEmpty()){
            return Optional.empty();
        }
        payment.get().updateCard(command);
        System.out.println("Payment updated");
        payment.get().setStatus(PaymentStatus.COMPLETADO);
        System.out.println("Payment updated");

        payment.get().finishProject();

        paymentRepository.save(payment.get());
        return payment;
    }

    @Override
    public void handle(DeletePaymentCommand command) {
        var payment = paymentRepository.findById(command.PaymentId());
        if (payment.isEmpty()) {
            throw new IllegalArgumentException("Payment not found");
        }
        paymentRepository.deleteById(command.PaymentId());
    }
}
