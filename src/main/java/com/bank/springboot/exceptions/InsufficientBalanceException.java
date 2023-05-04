package com.bank.springboot.exceptions;

public class InsufficientBalanceException extends Exception{
    public InsufficientBalanceException(String message){
        //出现异常打印的语句
        super(message);
    }
}

