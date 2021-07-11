package com.wmp.service;

import com.wmp.controller.dto.OutputDTO;
import com.wmp.controller.dto.SearchDTO;
import com.wmp.domain.ParsingType;
import com.wmp.exception.DomainNameException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import static org.mockito.BDDMockito.given;

@SpringBootTest
class OutputServiceTest {

    @Autowired
    OutputService outputService;
    @MockBean
    RestTemplate restTemplate;

    SearchDTO dto;
    String url;
    String expectedData;
    int outputUnit = 13;

    @BeforeEach
    void setUp() {
        url = "http://www.naver.com";
        expectedData = "<html>\n" +
                "<head><title>302 Found</title></head>\n" +
                "<body>\n" +
                "<center><h1>302 Found</h1></center>\n" +
                "<hr><center> NWS </center>\n" +
                "</body>\n" +
                "</html>";
    }

    @Test
    @DisplayName("타입이 텍스트 전체일 때 몫을 구한다.")
    void allTextGetShare() {
        dto = new SearchDTO(url, ParsingType.ALL, outputUnit);
        given(restTemplate.getForObject(dto.getUrl(), String.class)).willReturn(expectedData);
        final OutputDTO parsing = outputService.parsing(dto);

        Assertions.assertThat(parsing.getShare()).isEqualTo(10);
    }

    @Test
    @DisplayName("타입이 HTML 태그 제외 일때 몫을 구한다.")
    void exceptHtmlGetShare() {
        dto = new SearchDTO(url, ParsingType.EXCEPT_HTML, outputUnit);
        given(restTemplate.getForObject(dto.getUrl(), String.class)).willReturn(expectedData);
        final OutputDTO parsing = outputService.parsing(dto);

        Assertions.assertThat(parsing.getShare()).isEqualTo(2);
    }

    @Test
    @DisplayName("잘몰된 URL 들어올 시 예외처리한다.")
    void wrongUrl() {
        dto = new SearchDTO("www.naver.com", ParsingType.EXCEPT_HTML, outputUnit);
        Assertions.assertThatThrownBy(() -> outputService.parsing(dto))
                .isInstanceOf(DomainNameException.class);
    }
}