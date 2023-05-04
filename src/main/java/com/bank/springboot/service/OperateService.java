package com.bank.springboot.service;

import com.bank.springboot.model.Input;
import com.bank.springboot.model.Response;

public interface OperateService {
    Response operate(Input input);
}
