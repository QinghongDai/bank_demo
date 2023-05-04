package com.bank.springboot.model;

import com.bank.springboot.until.OperationEnum;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class Input implements Serializable {

    private String customerId;
    private String customerName;
    private OperationEnum operation;
    private BigDecimal amount;
    private String currency;
}
