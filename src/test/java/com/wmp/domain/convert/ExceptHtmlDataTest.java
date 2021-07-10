package com.wmp.domain.convert;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExceptHtmlDataTest {

    ExceptHtmlData exceptHtmlData;

    @BeforeEach
    void setup() {
        exceptHtmlData = new ExceptHtmlData();
    }

    @Test
    @DisplayName("HTML 태그가 삭제된다.")
    void removeHTML() {
        Assertions.assertThat(exceptHtmlData.convert("<html>위메프</html>")).isEqualTo("위메프");
    }

}