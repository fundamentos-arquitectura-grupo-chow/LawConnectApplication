package upc.LoremIpsum.lawconnectplatform.communication.infrastructure.persistence.jpa.repositories;

import upc.LoremIpsum.lawconnectplatform.communication.domain.model.aggregates.VideoCall;
import upc.LoremIpsum.lawconnectplatform.consultation.domain.model.aggregates.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoCallRepository extends JpaRepository<VideoCall, Long> {
    List<VideoCall> findAllByConsultation(Consultation consultation);
}
