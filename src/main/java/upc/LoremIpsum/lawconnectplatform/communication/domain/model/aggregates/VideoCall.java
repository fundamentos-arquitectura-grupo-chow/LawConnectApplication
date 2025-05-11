package upc.LoremIpsum.lawconnectplatform.communication.domain.model.aggregates;

import upc.LoremIpsum.lawconnectplatform.communication.domain.model.commands.CreateVideoCallCommand;
import upc.LoremIpsum.lawconnectplatform.communication.domain.model.valueobjects.CommunicationStatus;
import upc.LoremIpsum.lawconnectplatform.consultation.domain.model.aggregates.Consultation;
import upc.LoremIpsum.lawconnectplatform.legalcase.domain.model.valueobjects.DocumentsStatus;
import upc.LoremIpsum.lawconnectplatform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class VideoCall extends AuditableAbstractAggregateRoot<VideoCall> {

    @OneToOne
    @JoinColumn(name = "consultation", nullable = false)
    private Consultation consultation;

    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CommunicationStatus status;

    public VideoCall(CreateVideoCallCommand command, Consultation consultation) {
        this.description = command.description();
        this.status = CommunicationStatus.PENDING;
        this.consultation = consultation;
    }

    public VideoCall() {

    }

    public void setStatus(Integer status) {
        this.status = CommunicationStatus.fromId(status);
    }
}
