package upc.LoremIpsum.lawconnectplatform.legalcase.infrastructure.persistence.jpa.repositories;

import upc.LoremIpsum.lawconnectplatform.legalcase.domain.model.aggregates.LegalCase;
import upc.LoremIpsum.lawconnectplatform.legalcase.domain.model.entities.DocumentsItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentsRepository extends JpaRepository<DocumentsItem, Long> {
    List<DocumentsItem> findAllByLegalCase(LegalCase legalCase);
}
