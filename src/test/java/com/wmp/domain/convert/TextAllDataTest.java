package com.wmp.domain.convert;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextAllDataTest {

    TextAllData textAllData;

    @BeforeEach
    void setup() {
        textAllData = new TextAllData();
    }

    @Test
    @DisplayName("문자 그대로 들어온다.")
    void allWord() {
        Assertions.assertThat(textAllData.convert("<html>위메프</html>")).isEqualTo("<html>위메프</html>");
    }

}