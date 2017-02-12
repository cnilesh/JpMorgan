package com.message.helper;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map.Entry;

import com.message.pojo.Entity;
import com.message.processor.Processor;
import com.message.storage.MessageStore;

public class ReportProcessor implements Processor {
	public void process(Entity entity){
		EveryDayTradeProcessor everyDayProcessor = EveryDayTradeProcessor.getInstance();
		System.out.println("-----------------------------------INCOMING MESSAGES------------------------------------");
		for(int i=0 ; i < MessageStore.incomingEntities.size() ; i++){
			Entity incomingEntity = MessageStore.incomingEntities.get(i);
			System.out.println("Rank "+ (int)(i+1) + "   Name:"+incomingEntity.getEntityName()+"   Amount Settle In USD:"+incomingEntity.getPriceInUSD());
		}
		System.out.println("-----------------------------------OUTGOING MESSAGES------------------------------------");
		for(int i=0 ; i < MessageStore.outgoingEntities.size() ; i++){
			Entity outgoingEntity = MessageStore.outgoingEntities.get(i);
			System.out.println("Rank "+ (int)(i+1) + "   Name:"+outgoingEntity.getEntityName()+"   Amount Settle In USD:"+outgoingEntity.getPriceInUSD());
		}
		System.out.println("-----------------------------------OUTGOING MESSAGES DAYWISE SETTLEMENT------------------------------------");
		for(Entry<Date, BigDecimal> entry : everyDayProcessor.getTodaysOutgoingAggregate().entrySet()){
			System.out.println("Date:"+entry.getKey()+"--------------"+"Amount Settled:"+entry.getValue());
		}
		System.out.println("-----------------------------------INCOMING MESSAGES DAYWISE SETTLEMENT------------------------------------");
		for(Entry<Date, BigDecimal> entry : everyDayProcessor.getTodaysIncomingAggregate().entrySet()){
			System.out.println("Date:"+entry.getKey()+"--------------"+"Amount Settled:"+entry.getValue());
		}
	}
}
