package com.wmp.controller.dto;

import com.wmp.domain.ParsingType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SearchDTO {

    private String url;
    private ParsingType type;
    private int outputUnit;

    public boolean isNotIncludeHttp() {
        return !(url.startsWith("https://") || url.startsWith("http://"));
    }
}
