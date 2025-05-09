package upc.LoremIpsum.lawconnectplatform.legalcase.domain.model.aggregates;

import upc.LoremIpsum.lawconnectplatform.consultation.domain.model.aggregates.Consultation;
import upc.LoremIpsum.lawconnectplatform.legalcase.domain.model.commands.CreateLegalCaseCommand;
import upc.LoremIpsum.lawconnectplatform.legalcase.domain.model.valueobjects.Documents;
import upc.LoremIpsum.lawconnectplatform.legalcase.domain.model.valueobjects.LegalCaseStatus;
import upc.LoremIpsum.lawconnectplatform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
@Entity
public class LegalCase extends AuditableAbstractAggregateRoot<LegalCase> {

    @Column(nullable = false)
    @Size(max = 120)
    private String title;

    @Column(nullable = false)
    @Size(max = 500)
    private String description;

    @Column(nullable = false)
    private LegalCaseStatus status;

    @OneToOne
    @JoinColumn(name = "consultation", nullable = false)
    private Consultation consultation;

    @Embedded
    private Documents documents;

    protected LegalCase() {
        this.documents = new Documents();
        this.status = LegalCaseStatus.OPEN;
    }


    public LegalCase(CreateLegalCaseCommand command, Consultation consultation) {
        this();
        this.title = command.title();
        this.description = command.description();
        this.consultation = consultation;
    }

    public void close() {
        this.status = LegalCaseStatus.CLOSED;
    }

}