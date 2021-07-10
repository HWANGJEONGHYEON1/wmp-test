package com.wmp.service;

import com.wmp.controller.dto.OutputDTO;
import com.wmp.controller.dto.SearchDTO;
import com.wmp.domain.ParsingType;
import com.wmp.exception.DomainNameException;
import com.wmp.service.OutputService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OutputServiceTest {

    @Autowired
    OutputService outputService;

    SearchDTO dto;

    @Test
    @DisplayName("타입이 텍스트 전체일 때 몫을 구한다.")
    void allTextGetShare() {
        dto = new SearchDTO("http://localhost:8090/", ParsingType.ALL, 13);
        final OutputDTO parsing = outputService.parsing(dto);

        Assertions.assertThat(parsing.getShare()).isEqualTo(109);
    }

    @Test
    @DisplayName("타입이 HTML 태그 제외 일때 몫을 구한다.")
    void exceptHtmlGetShare() {
        dto = new SearchDTO("http://localhost:8090/", ParsingType.EXCEPT_HTML, 13);
        final OutputDTO parsing = outputService.parsing(dto);

        Assertions.assertThat(parsing.getShare()).isEqualTo(31);
    }

    @Test
    @DisplayName("잘몰된 URL 들어올 시 예외처리한다.")
    void wrongUrl() {
        dto = new SearchDTO("localhost:8090/", ParsingType.EXCEPT_HTML, 13);
        Assertions.assertThatThrownBy(() -> outputService.parsing(dto))
                .isInstanceOf(DomainNameException.class);
    }
}