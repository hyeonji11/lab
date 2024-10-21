package com.example.openai.service;

import com.example.openai.model.Answer;
import com.example.openai.model.CapitalRequest;
import reactor.core.publisher.Flux;

public interface OpenAIService {
    Answer getCapital(CapitalRequest capitalRequest);
    Flux<String> getStream(String message);
}
