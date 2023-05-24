package purewallet.api.pureapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import purewallet.api.pureapi.domain.Word;
import purewallet.api.pureapi.domain.request.WordCreationRequest;
import purewallet.api.pureapi.repository.WordRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WordService {
    private final WordRepository wordRepository;

    public Word getWord(WordCreationRequest input) {
        Optional<Word> word = wordRepository.findByInput(input.getInput());
        if (word.isPresent()) {
            return word.get();
        }
        throw new EntityNotFoundException("can not find word given input");
    }
    public Object addWord(WordCreationRequest word) {
        Optional<Word> duplication = wordRepository.findByInput(word.getInput());
        if (duplication.isPresent()){
            return word.getResult();
        }
        Word toCreate = new Word();
        BeanUtils.copyProperties(word, toCreate);
        return wordRepository.save(toCreate);
    }
}
