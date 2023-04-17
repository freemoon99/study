package purewallet.api.pureapi.repository;

import org.springframework.data.repository.CrudRepository;
import purewallet.api.pureapi.domain.Word;

import java.util.Optional;

public interface WordRepository extends CrudRepository<Word, Long> {
    Optional<Word> findByInput(String input);
}
