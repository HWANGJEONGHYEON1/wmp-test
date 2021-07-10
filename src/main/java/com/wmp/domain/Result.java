package com.wmp.domain;

import java.util.ArrayList;
import java.util.List;

public class Result {

    private final List<String> results;

    public Result(List<String> englishes, List<String> numbers) {
        results = new ArrayList<>();
        int size = Math.max(englishes.size(), numbers.size());

        for (int i = 0; i < size; i++) {
            if (i < englishes.size()) {
                results.add(englishes.get(i));
            }
            if (i < numbers.size()) {
                results.add(numbers.get(i));
            }
        }
    }

    public String getResultString() {
        return String.join("", results);
    }
}
