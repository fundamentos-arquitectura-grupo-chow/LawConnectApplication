package upc.LoremIpsum.lawconnectplatform.communication.domain.model.aggregates;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import upc.LoremIpsum.lawconnectplatform.communication.domain.model.commands.CreateAppointmentCommand;
import upc.LoremIpsum.lawconnectplatform.communication.domain.model.commands.CreateChatRoomCommand;
import upc.LoremIpsum.lawconnectplatform.communication.domain.model.valueobjects.CommunicationStatus;
import upc.LoremIpsum.lawconnectplatform.communication.domain.model.valueobjects.Messages;
import upc.LoremIpsum.lawconnectplatform.consultation.domain.model.aggregates.Consultation;
import upc.LoremIpsum.lawconnectplatform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class ChatRoom extends AuditableAbstractAggregateRoot<ChatRoom> {

    @OneToOne
    @JoinColumn(name = "consultation", nullable = false)
    private Consultation consultation;

    @Embedded
    private Messages messages;

    public ChatRoom() {
        this.messages = new Messages();
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CommunicationStatus status;

    public ChatRoom(Consultation consultation) {
        this();
        this.consultation = consultation;
        this.status = CommunicationStatus.PENDING;
    }

    public void setStatus(Integer status) {
        this.status = CommunicationStatus.fromId(status);
    }

}
