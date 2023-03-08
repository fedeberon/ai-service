package com.ideaas.common.aiservice.controller;

import com.ideaas.common.aiservice.payload.AnswerResponse;
import com.ideaas.common.aiservice.payload.QuestionRequest;
import com.ideaas.common.aiservice.service.interfaces.IAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("answers")
public class AnswerController {

    private IAnswerService answerService;

    @Autowired
    public AnswerController(final IAnswerService answerService) {
        this.answerService = answerService;
    }

    @PostMapping
    public ResponseEntity<AnswerResponse> getAnswer(@RequestBody QuestionRequest request) {
        final AnswerResponse response = answerService.getAnswer(request);

        return ResponseEntity.ok(response);
    }

}
