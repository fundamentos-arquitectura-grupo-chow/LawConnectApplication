package upc.LoremIpsum.lawconnectplatform.communication.domain.model.aggregates;

import upc.LoremIpsum.lawconnectplatform.communication.domain.model.commands.CreateAppointmentCommand;
import upc.LoremIpsum.lawconnectplatform.communication.domain.model.valueobjects.CommunicationStatus;
import upc.LoremIpsum.lawconnectplatform.consultation.domain.model.aggregates.Consultation;
import upc.LoremIpsum.lawconnectplatform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Appointment extends AuditableAbstractAggregateRoot<Appointment> {

    @OneToOne
    @JoinColumn(name = "consultation", nullable = false)
    private Consultation consultation;

    private String description;

    private String location;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CommunicationStatus status;

    public Appointment(CreateAppointmentCommand command, Consultation consultation) {
        this.consultation = consultation;
        this.description = command.description();
        this.location = command.location();
        this.status = CommunicationStatus.PENDING;
    }

    public Appointment() {

    }

    public void setStatus(Integer status) {
        this.status = CommunicationStatus.fromId(status);
    }
}
