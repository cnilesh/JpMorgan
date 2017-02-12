package com.message.main;

import java.math.BigDecimal;
import java.util.Date;

import com.message.enums.Indicator;
import com.message.helper.EveryDayTradeProcessor;
import com.message.helper.ReportProcessor;
import com.message.pojo.Entity;
import com.message.processor.Processor;

public class MainMessageReceiver {
	public static void main(String args[]){
		Entity entity = new Entity();
		entity.setEntityName("SAR");
		entity.setActionIndicator(Indicator.BUY);
		entity.setCurrency("USD");
		entity.setFxRate(new BigDecimal("5.00"));
		entity.setPricePerUnit(new BigDecimal("2.5"));
		entity.setUnits(100L);
		entity.setInstructionDate(new Date("11/10/2000"));
		entity.setSettlementDate(new Date("02/11/2017"));
		
		Entity entity1 = new Entity();
		entity1.setEntityName("FOO");
		entity1.setActionIndicator(Indicator.SELL);
		entity1.setCurrency("USD");
		entity1.setFxRate(new BigDecimal("29.50"));
		entity1.setPricePerUnit(new BigDecimal("2.5"));
		entity1.setUnits(100L);
		entity1.setInstructionDate(new Date("10/10/2000"));
		entity1.setSettlementDate(new Date("02/11/2017"));
		
		Entity entity2 = new Entity();
		entity2.setEntityName("BAR");
		entity2.setActionIndicator(Indicator.BUY);
		entity2.setCurrency("USD");
		entity2.setFxRate(new BigDecimal("10.00"));
		entity2.setPricePerUnit(new BigDecimal("2.5"));
		entity2.setUnits(100L);
		entity2.setInstructionDate(new Date("11/10/2000"));
		entity2.setSettlementDate(new Date("02/11/2017"));
		
		Processor processor =   Processor.newProcessor();
		processor.process(entity);
//		EveryDayTradeProcessor process = EveryDayTradeProcessor.getInstance();
//		process.process(entity);
		
		processor.process(entity1);
//		process.process(entity1);
		
		processor.process(entity2);
//		process.process(entity2);
		Processor reportProcessor = new ReportProcessor();
		reportProcessor.process(entity1);
	}
}
