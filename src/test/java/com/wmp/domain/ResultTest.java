package com.wmp.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class ResultTest {

    List<String> englishes;
    List<String> numbers;
    Result result;

    @BeforeEach
    void setup() {
        englishes = Arrays.asList(new String[]{"a", "b", "c"});
        numbers = Arrays.asList(new String[]{"1", "2", "3"});
        result = new Result(englishes, numbers);
    }

    @Test
    @DisplayName("결과 값이 같은지 확인한다.")
    void resultSame() {
        String expectResult = "a1b2c3";
        Assertions.assertThat(result.getResultString()).isEqualTo(expectResult);
    }
}