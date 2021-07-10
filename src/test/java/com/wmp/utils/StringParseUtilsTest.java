package com.wmp.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class StringParseUtilsTest {

    @Test
    @DisplayName("숫자를 리스트 변환한다.")
    void numberToList() {
        String numbers = "12345";
        List<String> numberList = Arrays.asList(numbers.split(""));
        Assertions.assertThat(StringParseUtils.getNumbers(numbers)).isEqualTo(numberList);
    }

    @Test
    @DisplayName("영어 스트링을 리스트 변환한다.")
    void englishToList() {
        String numbers = "abcde";
        List<String> englishList = Arrays.asList(numbers.split(""));
        Assertions.assertThat(StringParseUtils.getNumbers(numbers)).isEqualTo(englishList);
    }

}