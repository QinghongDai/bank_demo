package com.bank.springboot.service.impl;

import com.bank.springboot.exceptions.InsufficientBalanceException;
import com.bank.springboot.model.Input;
import com.bank.springboot.model.Output;
import com.bank.springboot.model.Response;
import com.bank.springboot.service.OperateService;
import com.bank.springboot.until.DataMemory;
import com.bank.springboot.until.ResponseCodeEnum;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OperateServiceImpl implements OperateService{
    @Override
    public Response operate(Input input) {
        //TODO Verify that the parameters

        return packageResponse(input);
    }

    private Response packageResponse(Input input) {
        Response response = new Response();
        response.setCode(ResponseCodeEnum.SUCCESS.getCode());
        response.setErrorMsg(ResponseCodeEnum.SUCCESS.getDescription());
        try {
            handleBalance(input);
        } catch (InsufficientBalanceException e) {
            response.setCode(ResponseCodeEnum.INSUFFICIENT_BALANCE.getCode());
            response.setErrorMsg(e.getMessage());
        } catch (Exception e) {
            response.setCode(ResponseCodeEnum.FAIL.getCode());
            response.setErrorMsg(e.getMessage());
        }

        response.setData(covertData(input));
        return response;
    }

    private Output covertData(Input input) {
        Output output = new Output();
        output.setCustomerId(input.getCustomerId());
        output.setCustomerName(input.getCustomerName());
        output.setBalance(DataMemory.getBalance(DataMemory.PRE_CUSTOMER_INFO_KEY + input.getCustomerId()));
        output.setBankBalance(DataMemory.getBalance(DataMemory.BANK_BALANCE));
        output.setCurrency(input.getCurrency());
        return output;
    }

    private void handleBalance(Input input) throws InsufficientBalanceException {
        String customerKey = DataMemory.PRE_CUSTOMER_INFO_KEY + input.getCustomerId();
        BigDecimal balance = DataMemory.getBalance(customerKey);
        switch (input.getOperation()){
            case WITHDRAW:
                if (balance.compareTo(input.getAmount()) >= 0) {
                    DataMemory.DATA_MAP.put(customerKey, (balance.subtract(input.getAmount())).toString());
                    DataMemory.DATA_MAP.put(DataMemory.BANK_BALANCE, (DataMemory.getBalance(DataMemory.BANK_BALANCE).subtract(input.getAmount())).toString());
                } else {
                    throw new InsufficientBalanceException(ResponseCodeEnum.INSUFFICIENT_BALANCE.getDescription());
                }
                break;
            case DEPOSIT:
                DataMemory.DATA_MAP.put(customerKey, (input.getAmount().add(balance)).toString());
                DataMemory.DATA_MAP.put(DataMemory.BANK_BALANCE, (DataMemory.getBalance(DataMemory.BANK_BALANCE).add(input.getAmount())).toString());
                break;
            default:
                break;
        }

    }
}
