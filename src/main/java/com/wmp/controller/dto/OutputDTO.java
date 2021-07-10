package com.wmp.controller.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class OutputDTO {

    private final int share;
    private final int remainder;
    private final String result;

    public static OutputDTO of(String convertData, int outputUnit, String result) {
        int share = convertData.length() / outputUnit;
        int remainder = convertData.length() % outputUnit;

        return new OutputDTO(share, remainder, result);
    }
}
