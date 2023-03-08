package com.ideaas.common.aiservice.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionRequest {

    private String question;

    private Format format = Format.HTML;
}
