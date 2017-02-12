package com.message.test.helper;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import com.message.helper.DateUtil;

public class MessageProcessorTest {
	
	@Test
	public void checkIfDateFallsOnWeekend(){
		Date date = new Date("02/12/2017");
		assertEquals(DateUtil.isWorkWeekForCurrency("USD", date),true);
	}
}
