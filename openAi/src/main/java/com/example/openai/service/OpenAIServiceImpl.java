package com.example.openai.service;

import com.example.openai.model.Answer;
import com.example.openai.model.CapitalRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import reactor.core.publisher.Flux;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class OpenAIServiceImpl implements OpenAIService{

    private final ChatModel chatModel;

    @Value("classpath:templates/get-capital-prompt.st")
    private Resource getCapitalPrompt;

    @Value("${spring.ai.openai.api-key}")
    private String apiKey;

    @Override
    public Answer getCapital(CapitalRequest capitalRequest) {
        String templateContent;
        try {
            templateContent = StreamUtils.copyToString(getCapitalPrompt.getInputStream(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("Error loading template: " + getCapitalPrompt.getFilename(), e);
        }

        PromptTemplate promptTemplate = new PromptTemplate(templateContent);
        Prompt prompt = promptTemplate.create(Map.of("stateOrCountry", capitalRequest.stateOrCountry()));
        ChatResponse response = chatModel.call(prompt);

        return new Answer(response.getResult().getOutput().getContent());
    }

    // Stream 형식
    @Override
    public Flux<String> getStream(String message) {
        ChatClient chatClient = ChatClient.builder(chatModel).build();
        Flux<String> response = chatClient.prompt().user(message).stream().content();
//        Flux<String> response = chatModel.stream(message);
        return response;
    }

    @Override
    public Answer getMenu() {
        ChatResponse response = ChatClient.builder(new OpenAiChatModel(new OpenAiApi(apiKey)))
                .defaultSystem("너는 양식만 추천해주는 요리 전문가야.")
                .defaultUser("오늘 비가 오는데 저녁을 추천해줘")
                .build()
                .prompt()
                .call()
                .chatResponse();

        return new Answer(response.getResult().getOutput().getContent());
    }
}