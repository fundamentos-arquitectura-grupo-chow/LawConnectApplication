package upc.LoremIpsum.lawconnectplatform.legalcase.infrastructure.persistence.jpa.repositories;

import upc.LoremIpsum.lawconnectplatform.legalcase.domain.model.aggregates.LegalCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LegalCaseRepository extends JpaRepository<LegalCase, Long> {
    List<LegalCase> findByConsultationId(Long consultationId);
}
