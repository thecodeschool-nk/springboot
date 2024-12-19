package com.thecodeschool.springrest.controller;

import com.thecodeschool.springrest.service.ErrorCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/config")
public class ErrorCodeController {
    @Autowired
    private ErrorCodeService errorCodeService;

    @GetMapping()
    public String getError() {
        return errorCodeService.highestPriorityErrorCode(List.of("ERR11", "ERR4", "ERR3"));
    }
}
