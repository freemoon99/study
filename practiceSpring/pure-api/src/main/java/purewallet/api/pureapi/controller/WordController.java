package purewallet.api.pureapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import purewallet.api.pureapi.domain.Word;
import purewallet.api.pureapi.domain.request.WordCreationRequest;
import purewallet.api.pureapi.service.WordService;

@RestController
@RequestMapping(value = "/api/search")
@RequiredArgsConstructor
public class WordController {
    private final WordService wordService;

    @GetMapping("/get")
    public ResponseEntity<Word> getWord(@RequestBody WordCreationRequest input) {
        return ResponseEntity.ok(wordService.getWord(input));
    }

    @PostMapping("/post")
    public ResponseEntity<Object> addWord(@RequestBody WordCreationRequest input){
        return ResponseEntity.ok(wordService.addWord(input));
    }
}

