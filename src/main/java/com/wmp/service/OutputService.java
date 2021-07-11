package com.wmp.service;

import com.wmp.controller.dto.OutputDTO;
import com.wmp.controller.dto.SearchDTO;
import com.wmp.domain.Result;
import com.wmp.domain.convert.ParsingData;
import com.wmp.exception.DomainNameException;
import com.wmp.utils.StringParseUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OutputService {

    private final RestTemplate restTemplate;

    public OutputDTO parsing(SearchDTO searchDTO) {
        validate(searchDTO);
        String data = restTemplate.getForObject(searchDTO.getUrl(), String.class);

        ParsingData parsingData = searchDTO.getType().get();

        String convertData = parsingData.convert(data);

        Result result = new Result(getEnglishesList(convertData), getNumbersList(convertData));

        return OutputDTO.of(convertData, searchDTO.getOutputUnit(), result.getResultString());
    }

    private void validate(SearchDTO searchDTO) {
        if (searchDTO.isNotIncludeHttp()) {
            throw new DomainNameException();
        }
    }

    private List<String> getEnglishesList(String convertData) {
        String englishes = convertData.replaceAll("[^a-zA-Z]", "");
        return StringParseUtils.getEnglishes(englishes);
    }

    private List<String> getNumbersList(String convertData) {
        String numbers = convertData.replaceAll("[^0-9]", "");
        return StringParseUtils.getNumbers(numbers);
    }
}
