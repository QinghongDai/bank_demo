package com.bank.springboot.controller;

import com.bank.springboot.model.Input;
import com.bank.springboot.model.Response;
import com.bank.springboot.service.OperateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperateCotroller {
    @Autowired
    OperateService operateService;

    @PostMapping("/operate")
    public Response operate(@Validated @RequestBody Input input) {
        return operateService.operate(input);
    }
}
