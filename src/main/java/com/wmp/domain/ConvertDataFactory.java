package com.wmp.domain;


import com.wmp.domain.convert.ExceptHtmlData;
import com.wmp.domain.convert.ParsingData;
import com.wmp.domain.convert.TextAllData;

public class ConvertDataFactory {

    public static ParsingData create(ParsingType type) {
        if (ParsingType.EXCEPT_HTML == type) {
            return new ExceptHtmlData();
        }
        return new TextAllData();
    }
}
