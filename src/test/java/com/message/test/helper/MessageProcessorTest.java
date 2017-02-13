package com.message.test.helper;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import com.message.helper.DateUtil;
import com.message.pojo.Entity;

public class MessageProcessorTest {
	Entity entity = new Entity();
	
	@Test
	public void checkIfDateFallsOnWeekend(){
		Date date = new Date("02/12/2017");
		assertEquals(DateUtil.isWorkWeekForCurrency("USD", date),true);
	}
	
	@Test
	public void checkAdjustedSettlementDateForUSD(){
		Date date = new Date("02/12/2017");
		entity.setCurrency("USD");
		entity.setSettlementDate(date);
		assertEquals(DateUtil.getWorkingSettlementDate(entity).compareTo(new Date("02/13/2017")), 0);
	}
	
	@Test
	public void checkAdjustedSettlementDateForAED(){
		Date date = new Date("02/11/2017");
		entity.setCurrency("AED");
		entity.setSettlementDate(date);
		assertEquals(DateUtil.getWorkingSettlementDate(entity).compareTo(new Date("02/12/2017")), 0);
	}
}
