package upc.LoremIpsum.lawconnectplatform.profiles.infrastructure.persistence.jpa.repositories;

import upc.LoremIpsum.lawconnectplatform.profiles.domain.model.aggregates.Profile;
import upc.LoremIpsum.lawconnectplatform.profiles.domain.model.valueobjects.EmailAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    boolean existsByEmail(EmailAddress email);
    Optional<Profile> findByEmail(EmailAddress email);
}
