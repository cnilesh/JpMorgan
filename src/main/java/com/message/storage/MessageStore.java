package com.message.storage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.message.comparator.MessageComparator;
import com.message.pojo.Entity;

public class MessageStore {
	
	private MessageStore(){
		
	}
	
	public static MessageStore getInstance(){
		return INSTANCE;
	}
	
	private static final MessageStore INSTANCE = new MessageStore();
	
	public static List<Entity> outgoingEntities = new ArrayList<Entity>();
	
	public static List<Entity> incomingEntities = new ArrayList<Entity>();
	
	MessageComparator comparator = new MessageComparator();
	
	public void storeOutgoingEntities(Entity entity){
		outgoingEntities.add(entity);
		Collections.sort(outgoingEntities,comparator);
	}
	
	public void storeIncomingEntities(Entity entity){
		incomingEntities.add(entity);
		Collections.sort(incomingEntities,comparator);
	}
}
