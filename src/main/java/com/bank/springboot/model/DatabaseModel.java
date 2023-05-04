package com.bank.springboot.model;

import com.bank.springboot.until.OperationEnum;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class DatabaseModel implements Serializable {

    private String customerId;
    private String customerName;
    private OperationEnum operation;
    private BigDecimal amount;
    private BigDecimal beforeBalance;
    private BigDecimal afterBalance;
    private String currency;
    private Date createTime;
    private Date updateTime;
}
