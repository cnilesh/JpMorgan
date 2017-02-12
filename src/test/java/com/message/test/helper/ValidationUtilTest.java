package com.message.test.helper;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.message.enums.Indicator;
import com.message.exception.MessageException;
import com.message.helper.ValidationUtil;
import com.message.pojo.Entity;

public class ValidationUtilTest {

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	Entity entity = new Entity();
	@Before
	public void setUp(){
		entity.setEntityName("BAR");
		entity.setActionIndicator(Indicator.BUY);
		entity.setCurrency("EUR");
		entity.setFxRate(new BigDecimal("5.00"));
		entity.setPricePerUnit(new BigDecimal("2.5"));
		entity.setUnits(100L);
		entity.setInstructionDate(new Date("11/10/2000"));
		entity.setSettlementDate(new Date("02/11/2017"));
	}
	
	@Test(expected = MessageException.class)
	public void checkForEmptyName() {
		entity.setEntityName("");
		ValidationUtil util = new ValidationUtil();
		util.validate(entity);
		expectedEx.expect(RuntimeException.class);
		expectedEx.expectMessage("Trade Message is empty");
	}
	
	//similar tests can be performed for other validations too
}
