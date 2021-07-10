package com.wmp.controller;

import com.wmp.controller.dto.OutputDTO;
import com.wmp.controller.dto.SearchDTO;
import com.wmp.service.OutputService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class OutputController {

    private final OutputService outputService;

    @GetMapping(value = "/api/url/parse")
    public OutputDTO parseRequestUri(SearchDTO searchDTO) {
        log.info("===== parseRequestUri");
        System.out.println(searchDTO.getOutputUnit());
        return outputService.parsing(searchDTO);
    }
}
