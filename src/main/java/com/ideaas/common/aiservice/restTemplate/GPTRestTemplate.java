package com.ideaas.common.aiservice.restTemplate;

import com.ideaas.common.aiservice.payload.Answer;
import com.ideaas.common.aiservice.payload.QuestionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.function.Function;

@Component
public class GPTRestTemplate implements Function<QuestionRequest, Answer> {

    RestTemplate restTemplate;

    @Value("${openai.api.key}")
    private String apiKey;


    @Autowired
    public GPTRestTemplate(final RestTemplateBuilder restTemplate) {
        this.restTemplate = restTemplate.build();
    }

    public Answer apply(final QuestionRequest question) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey); // replace with your actual API key

        String requestBody = "{\"prompt\": \"" + question.getQuestion() + question.getFormat().getDescription() + "\", \"temperature\": 0.5, \"model\": \"text-davinci-003\", \"max_tokens\": 2000 }";

        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);
        ResponseEntity<Answer> response =
                restTemplate.postForEntity("https://api.openai.com/v1/completions",
                        entity,
                        Answer.class);

        return response.getBody();
    }
}
