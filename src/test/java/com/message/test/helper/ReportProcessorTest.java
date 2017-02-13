package com.message.test.helper;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import com.message.enums.Indicator;
import com.message.helper.EveryDayTradeProcessor;
import com.message.pojo.Entity;
import com.message.processor.Processor;

public class ReportProcessorTest {
	Entity entity = new Entity();
	Entity entity2 = new Entity();
	
	@Before
	public void setUp(){
		entity.setEntityName("SAR");
		entity.setActionIndicator(Indicator.BUY);
		entity.setCurrency("USD");
		entity.setFxRate(new BigDecimal("5.00"));
		entity.setPricePerUnit(new BigDecimal("2.5"));
		entity.setUnits(100L);
		entity.setInstructionDate(new Date("11/10/2000"));
		entity.setSettlementDate(new Date("02/11/2017"));
		
		entity2.setEntityName("BAR");
		entity2.setActionIndicator(Indicator.BUY);
		entity2.setCurrency("USD");
		entity2.setFxRate(new BigDecimal("10.00"));
		entity2.setPricePerUnit(new BigDecimal("2.5"));
		entity2.setUnits(100L);
		entity2.setInstructionDate(new Date("11/10/2000"));
		entity2.setSettlementDate(new Date("02/11/2017"));
	}
	
	@Test
	public void checkForTodaysCollection(){
		Processor processor = Processor.newProcessor();
		processor.process(entity);
		processor.process(entity2);
		EveryDayTradeProcessor everydayProcessor = EveryDayTradeProcessor.getInstance();
		assertEquals(everydayProcessor.getTodaysOutgoingAggregate().get(new Date("02/13/2017")).compareTo(new BigDecimal("3750.00")), 0);
	}
}
