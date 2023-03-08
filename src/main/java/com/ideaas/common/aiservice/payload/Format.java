package com.ideaas.common.aiservice.payload;

import lombok.Getter;

@Getter
public enum Format {

    TEXT(". En formato de texto."),
    HTML(". En formato HTML.");

    Format(final String description) {
        this.description = description;
    }

    private String description;

}
