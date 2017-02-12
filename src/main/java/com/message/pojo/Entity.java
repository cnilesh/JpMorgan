package com.message.pojo;

import java.math.BigDecimal;
import java.util.Date;

import com.message.enums.Indicator;

public class Entity {
	
	private String entityName;
	
	private Indicator actionIndicator;
	
	private BigDecimal fxRate;
	
	private String currency;
	
	private Date instructionDate;
	
	private Date settlementDate;
	
	private Long units;
	
	private BigDecimal pricePerUnit;
	
	private BigDecimal priceInUSD;

	public BigDecimal getPriceInUSD() {
		return priceInUSD;
	}

	public void setPriceInUSD(BigDecimal priceInUSD) {
		this.priceInUSD = priceInUSD;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public Indicator getActionIndicator() {
		return actionIndicator;
	}

	public void setActionIndicator(Indicator actionIndicator) {
		this.actionIndicator = actionIndicator;
	}

	public BigDecimal getFxRate() {
		return fxRate;
	}

	public void setFxRate(BigDecimal fxRate) {
		this.fxRate = fxRate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Date getInstructionDate() {
		return instructionDate;
	}

	public void setInstructionDate(Date instructionDate) {
		this.instructionDate = instructionDate;
	}

	public Date getSettlementDate() {
		return settlementDate;
	}

	public void setSettlementDate(Date settlementDate) {
		this.settlementDate = settlementDate;
	}

	public Long getUnits() {
		return units;
	}

	public void setUnits(Long units) {
		this.units = units;
	}

	public BigDecimal getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(BigDecimal pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actionIndicator == null) ? 0 : actionIndicator.hashCode());
		result = prime * result + ((entityName == null) ? 0 : entityName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entity other = (Entity) obj;
		if (actionIndicator != other.actionIndicator)
			return false;
		if (entityName == null) {
			if (other.entityName != null)
				return false;
		} else if (!entityName.equals(other.entityName))
			return false;
		return true;
	}

	
}
