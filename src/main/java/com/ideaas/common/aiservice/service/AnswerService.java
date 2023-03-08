package com.ideaas.common.aiservice.service;

import com.ideaas.common.aiservice.payload.Answer;
import com.ideaas.common.aiservice.payload.AnswerResponse;
import com.ideaas.common.aiservice.payload.QuestionRequest;
import com.ideaas.common.aiservice.service.interfaces.IAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class AnswerService implements IAnswerService {

    private Function<QuestionRequest, Answer> answerRestTemplate;

    @Autowired
    public AnswerService(Function<QuestionRequest, Answer> answerRestTemplate) {
        this.answerRestTemplate = answerRestTemplate;
    }

    public AnswerResponse getAnswer(final QuestionRequest question) {
       final Answer answer = answerRestTemplate.apply(question);

       return AnswerResponse.builder().answer(answer.getChoices().get(0).getText()).build();
   }
}
