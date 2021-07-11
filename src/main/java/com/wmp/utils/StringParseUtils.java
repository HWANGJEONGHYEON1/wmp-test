package com.wmp.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringParseUtils {

    public static List<String> getNumbers(String numbers) {
        return Arrays.stream(numbers.split(""))
                .sorted()
                .collect(Collectors.toList());
    }

    public static List<String> getEnglishes(String english) {
        return Arrays.stream(english.split(""))
                .sorted(StringParseUtils::compareTo)
                .collect(Collectors.toList());
    }

    private static int compareTo(String o1, String o2) {
        int res = o1.compareToIgnoreCase(o2);
        return (res == 0) ? o1.compareTo(o2) : res;
    }
}
