package upc.LoremIpsum.lawconnectplatform.feeing.domain.model.aggregates;

import upc.LoremIpsum.lawconnectplatform.feeing.domain.model.commands.CompletePaymentCommand;
import upc.LoremIpsum.lawconnectplatform.feeing.domain.model.commands.CreatePaymentCommand;
import upc.LoremIpsum.lawconnectplatform.feeing.domain.model.events.PaymentCompletedEvent;
import upc.LoremIpsum.lawconnectplatform.feeing.domain.model.valueObjects.*;
import upc.LoremIpsum.lawconnectplatform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
public class Payment extends AuditableAbstractAggregateRoot<Payment> {

    @Column(name = "consultation_id")
    private Long consultationId;

    private Long clientId;

    @Embedded
    private PaymentAmount amount;

    @Setter
    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    @Embedded
    private Card card;

    public Payment(CreatePaymentCommand command) {
        this();
        this.consultationId = command.consultationId();
        this.amount = new PaymentAmount(
                command.amount(),
                Currency.fromId(command.currency())
        );
        this.clientId = command.clientId();
        this.status = PaymentStatus.PENDIENTE;
        this.card = new Card();
    }

    public Payment() {}

    public void updateCard(CompletePaymentCommand command) {
        this.card = new Card(command.cardNumber(), command.expirationDate(), command.cvv());
    }

    public void finishProject() {
        this.registerEvent(new PaymentCompletedEvent(this, this.getId()));
    }
}