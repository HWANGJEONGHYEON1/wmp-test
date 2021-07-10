package com.wmp.domain.convert;

public class ExceptHtmlData implements ParsingData {

    @Override
    public String convert(String data) {
        return removeHtmlTag(data);
    }

    private String removeHtmlTag(String response) {
        return response.replaceAll("<([^>]+)>", "");
    }
}
