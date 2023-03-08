package com.ideaas.common.aiservice.service.interfaces;

import com.ideaas.common.aiservice.payload.AnswerResponse;
import com.ideaas.common.aiservice.payload.QuestionRequest;

public interface IAnswerService {

    AnswerResponse getAnswer(QuestionRequest question);
}
