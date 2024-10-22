package com.example.openai.controller;

import com.example.openai.model.Answer;
import com.example.openai.model.CapitalRequest;
import com.example.openai.service.OpenAIService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
public class QuestionController {

    private final OpenAIService openAIService;

    @PostMapping("/capital")
    public Answer getCapital(@RequestBody CapitalRequest capitalRequest) {
        return this.openAIService.getCapital(capitalRequest);
    }

    @GetMapping("/ai/stream")
    public Flux<String> getCapital(@RequestParam String message) {
        return this.openAIService.getStream(message);
    }

    @GetMapping("/menu")
    public Answer getMenu() {
        return this.openAIService.getMenu();
    }
}
