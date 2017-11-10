package com.jpmorgan.reportingengine.model;

import java.time.LocalDate;
import java.util.Objects;

public class EntityBO {

	private String entityName;
	private String instructionType;
	private double agreedFx;
	private String currency;
	private LocalDate instructionDate;
	private LocalDate settlementDate;
	private int numberOfUnits;
	private double pricePerUnit;
	private double incomingAmtSettled;
	private double outgoingAmtSettled;

	public double getOutgoingAmtSettled() {
		return outgoingAmtSettled;
	}

	public void setOutgoingAmtSettled(double outgoingAmtSettled) {
		this.outgoingAmtSettled = outgoingAmtSettled;
	}

	public double getIncomingAmtSettled() {
		return incomingAmtSettled;
	}

	public void setIncomingAmtSettled(double incomingAmtSettled) {
		this.incomingAmtSettled = incomingAmtSettled;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getInstructionType() {
		return instructionType;
	}

	public void setInstructionType(String instructionType) {
		this.instructionType = instructionType;
	}

	public double getAgreedFx() {
		return agreedFx;
	}

	public void setAgreedFx(double agreedFx) {
		this.agreedFx = agreedFx;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public LocalDate getInstructionDate() {
		return instructionDate;
	}

	public void setInstructionDate(LocalDate instructionDate) {
		this.instructionDate = instructionDate;
	}

	public LocalDate getSettlementDate() {
		return settlementDate;
	}

	public void setSettlementDate(LocalDate settlementDate) {
		this.settlementDate = settlementDate;
	}

	public int getNumberOfUnits() {
		return numberOfUnits;
	}

	public void setNumberOfUnits(int numberOfUnits) {
		this.numberOfUnits = numberOfUnits;
	}

	public double getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	@Override
	public boolean equals(Object object) {

		if (object == this)
			return true;
		if (!(object instanceof EntityBO)) {
			return false;
		}
		EntityBO entityInstructionBO = (EntityBO) object;
		return Objects.equals(settlementDate, entityInstructionBO.getSettlementDate());
	}

	@Override
	public int hashCode() {
		return Objects.hash(settlementDate);
	}

}
