package upc.LoremIpsum.lawconnectplatform.communication.infrastructure.persistence.jpa.repositories;

import upc.LoremIpsum.lawconnectplatform.communication.domain.model.aggregates.ChatRoom;
import upc.LoremIpsum.lawconnectplatform.consultation.domain.model.aggregates.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {
    Optional<ChatRoom> findByConsultation(Consultation consultation);
}
