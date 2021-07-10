package com.wmp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wmp.controller.dto.OutputDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
class OutputControllerTest {

    @Autowired
    private WebApplicationContext ctx;

    @Autowired
    ObjectMapper objectMapper;
    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    @DisplayName("값이 동일한지 테스트한다.")
    void checkOutputDTO() throws Exception {
        final MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get("/api/url/parse")
                .param("url", "http://www.naver.com")
                .param("type", "EXCEPT_HTML")
                .param("outputUnit", "11"))
                .andReturn().getResponse();
        Assertions.assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }
}