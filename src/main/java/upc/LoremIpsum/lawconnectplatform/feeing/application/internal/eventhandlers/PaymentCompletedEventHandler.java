package upc.LoremIpsum.lawconnectplatform.feeing.application.internal.eventhandlers;

import upc.LoremIpsum.lawconnectplatform.feeing.application.internal.outboundServices.ExternalConsultationPaymentService;
import upc.LoremIpsum.lawconnectplatform.feeing.domain.model.events.PaymentCompletedEvent;
import upc.LoremIpsum.lawconnectplatform.feeing.infrastructure.persistence.jpa.repositories.PaymentRepository;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class PaymentCompletedEventHandler {
    private final ExternalConsultationPaymentService externalConsultationPaymentService;
    private final PaymentRepository paymentRepository;

    public PaymentCompletedEventHandler(
            ExternalConsultationPaymentService externalConsultationPaymentService,
            PaymentRepository paymentRepository) {
        this.externalConsultationPaymentService = externalConsultationPaymentService;
        this.paymentRepository = paymentRepository;
    }

    @EventListener(PaymentCompletedEvent.class)
    public void onPaymentCompleted(PaymentCompletedEvent event) {
        var payment = paymentRepository.findById(event.getPaymentId()).orElse(null);
        if (payment != null) {
            externalConsultationPaymentService.changeConsultationStatus(payment.getConsultationId());
        }
    }
}