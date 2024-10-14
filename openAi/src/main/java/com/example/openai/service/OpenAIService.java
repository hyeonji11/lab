package com.example.openai.service;

import com.example.openai.model.Answer;
import com.example.openai.model.CapitalRequest;

public interface OpenAIService {
    Answer getCapital(CapitalRequest capitalRequest);
}
