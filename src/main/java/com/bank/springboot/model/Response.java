package com.bank.springboot.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Response implements Serializable {

    private String code;
    private String errorMsg;
    private Output data;
}
