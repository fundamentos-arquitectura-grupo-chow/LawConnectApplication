package upc.LoremIpsum.lawconnectplatform.consultation.infrastructure.persistence.jpa.repositories;

import upc.LoremIpsum.lawconnectplatform.consultation.domain.model.aggregates.Consultation;
import upc.LoremIpsum.lawconnectplatform.feeing.domain.model.aggregates.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
    List<Consultation> findAllByLawyerId(Long lawyerId);
    Optional<Consultation> findByPayments(List<Payment> payment);
    List<Consultation> findAllByClientId(Long clientId);
    List<Consultation> findAllByClientIdAndLawyerId(Long clientId, Long lawyerId);
}
