package com.wmp.domain;

import com.wmp.domain.convert.ExceptHtmlData;
import com.wmp.domain.convert.ParsingData;
import com.wmp.domain.convert.TextAllData;

import java.util.function.Supplier;

public enum ParsingType {

    EXCEPT_HTML(ExceptHtmlData::new),
    ALL(TextAllData::new);

    private final Supplier<ParsingData> type;

    ParsingType(Supplier<ParsingData> type) {
        this.type = type;
    }

    public ParsingData get() {
        return type.get();
    }
}
