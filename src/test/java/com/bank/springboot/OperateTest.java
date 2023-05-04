package com.bank.springboot;

import com.bank.springboot.model.Input;
import com.bank.springboot.model.Response;
import com.bank.springboot.service.OperateService;
import com.bank.springboot.until.OperationEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import javax.validation.constraints.AssertTrue;
import java.math.BigDecimal;

@SpringBootTest
@AutoConfigureMockMvc
public class OperateTest {

	@Autowired
	private OperateService operateService;

	@Test
	public void operateTest(){
		Input input = new Input();
		input.setCustomerId("1");
		input.setCustomerName("Customer 1");
		input.setCurrency("A$");
		input.setAmount(new BigDecimal(4));
		input.setOperation(OperationEnum.DEPOSIT);

		Response response = operateService.operate(input);
		System.out.println(response.toString());

		Input input2 = new Input();
		input2.setCustomerId("2");
		input2.setCustomerName("Customer 2");
		input2.setCurrency("A$");
		input2.setAmount(new BigDecimal(6));
		input2.setOperation(OperationEnum.DEPOSIT);
		Response response2 = operateService.operate(input2);
		System.out.println(response2.toString());

		Input input3 = new Input();
		input3.setCustomerId("3");
		input3.setCustomerName("Customer 3");
		input3.setCurrency("A$");
		input3.setAmount(new BigDecimal(11));
		input3.setOperation(OperationEnum.WITHDRAW);
		Response response3 = operateService.operate(input3);
		System.out.println(response3.toString());

		Input input4 = new Input();
		input4.setCustomerId("2");
		input4.setCustomerName("Customer 2");
		input4.setCurrency("A$");
		input4.setAmount(new BigDecimal(11));
		input4.setOperation(OperationEnum.WITHDRAW);
		Response response4 = operateService.operate(input4);
		System.out.println(response4.toString());

		Input input5 = new Input();
		input5.setCustomerId("2");
		input5.setCustomerName("Customer 2");
		input5.setCurrency("A$");
		input5.setAmount(new BigDecimal(5));
		input5.setOperation(OperationEnum.WITHDRAW);
		Response response5 = operateService.operate(input5);
		System.out.println(response5.toString());


		//Assert();
	}
}
