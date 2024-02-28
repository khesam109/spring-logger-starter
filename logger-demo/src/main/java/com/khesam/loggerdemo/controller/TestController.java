package com.khesam.loggerdemo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.khesam.logger.model.LogContext;
import com.khesam.logger.model.SystemInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    private final ObjectMapper objectMapper;

    @Autowired
    public TestController(
            @Qualifier("logger-serializer") ObjectMapper objectMapper
    ) {
        this.objectMapper = objectMapper;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Void> test() throws JsonProcessingException {
        LogContext logContext = new LogContext();
        logContext.setSystemInfo(new SystemInfo("name", "node", "ip", "id"));

        System.out.println(objectMapper.writeValueAsString(logContext));

        return ResponseEntity.noContent().build();
    }
}
