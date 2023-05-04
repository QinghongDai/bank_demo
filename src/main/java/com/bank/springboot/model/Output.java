package com.bank.springboot.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class Output implements Serializable {

    private String customerId;
    private String customerName;
    private BigDecimal balance;
    private BigDecimal bankBalance;
    private String currency;
}
