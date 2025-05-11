package upc.LoremIpsum.lawconnectplatform.consultation.domain.model.aggregates;

import upc.LoremIpsum.lawconnectplatform.consultation.domain.model.commands.CreateConsultationCommand;
import upc.LoremIpsum.lawconnectplatform.consultation.domain.model.events.CreateChatRoomEvent;
import upc.LoremIpsum.lawconnectplatform.consultation.domain.model.events.CreateDefaultPaymentEvent;
import upc.LoremIpsum.lawconnectplatform.consultation.domain.model.valueobjects.ApplicationStatus;
import upc.LoremIpsum.lawconnectplatform.consultation.domain.model.valueobjects.ConsultationType;
import upc.LoremIpsum.lawconnectplatform.feeing.domain.model.aggregates.Payment;
import upc.LoremIpsum.lawconnectplatform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
public class Consultation extends AuditableAbstractAggregateRoot<Consultation> {

    private Long lawyerId;

    private Long clientId;

    @OneToMany(mappedBy = "consultation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Payment> payments = new ArrayList<>();

    @Column(nullable = false)
    @Size(max = 500)
    private String description;

    private ConsultationType consultationType;

    private ApplicationStatus applicationStatus;

    public Consultation() {
        this.description = "";
    }

    public Consultation(CreateConsultationCommand command) {
        this();
        this.lawyerId = command.lawyerId();
        this.description = command.description();
        this.consultationType = ConsultationType.fromId(command.type());
        this.applicationStatus = ApplicationStatus.PENDING;
        this.clientId = command.clientId();
    }

    public void setApplicationAccepted() {
        this.applicationStatus = ApplicationStatus.APPROVED;
    }

    public void setApplicationDenied() {
        this.applicationStatus = ApplicationStatus.REJECTED;
    }

    public void createDefaultPayment(Long consultationId, Long clientId, Double amount, Integer currency) {
        this.registerEvent(new CreateDefaultPaymentEvent(this,consultationId, clientId, amount, currency));
    }

    public void createChatRoom() {
        System.out.println("Creating chat room");
        this.registerEvent(new CreateChatRoomEvent(this, this.getId()));
        System.out.println("Chat room created");
    }

    public void addPayment(Payment payment) {
        System.out.println("Adding payment");
        this.payments.add(payment);
    }
}
