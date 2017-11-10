package com.jpmorgan.reportingengine.util;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.jpmorgan.reportingengine.constants.ReportingEngineConstants;
import com.jpmorgan.reportingengine.model.EntityBO;

public class ReportingEngineEntityGenericUtil {

	public List<EntityBO> getListOfEntities(final List<EntityBO> entityListBOs) {
		List<EntityBO> entityList = new ArrayList<EntityBO>();
		for (EntityBO entityBO : entityListBOs) {
			if (entityBO.getCurrency().equalsIgnoreCase(ReportingEngineConstants.AED)
					|| entityBO.getCurrency().equalsIgnoreCase(ReportingEngineConstants.SAR)) {

				changeSettleMentDateForAEDandSAR(entityBO);

			} else {
				changeSettlementDate(entityBO);
			}
			if (entityBO.getInstructionType().equalsIgnoreCase(ReportingEngineConstants.SELL_INCOMING_FLAG)) {
				entityBO.setIncomingAmtSettled(
						entityBO.getPricePerUnit() * entityBO.getNumberOfUnits() * entityBO.getAgreedFx());
			} else {
				entityBO.setOutgoingAmtSettled(
						entityBO.getPricePerUnit() * entityBO.getNumberOfUnits() * entityBO.getAgreedFx());
			}

			entityList.add(entityBO);
		}
		return entityList;
	}

	private void changeSettleMentDateForAEDandSAR(final EntityBO entityBO) {
		DayOfWeek dayOfWeek = entityBO.getInstructionDate().getDayOfWeek();
		switch (dayOfWeek) {
		case FRIDAY:
			entityBO.setSettlementDate(entityBO.getSettlementDate().plusDays(2));
			break;
		case SATURDAY:
			entityBO.setSettlementDate(entityBO.getSettlementDate().plusDays(1));
			break;
		default:
			break;
		}
	}

	private void changeSettlementDate(final EntityBO entityBO) {
		DayOfWeek dayOfWeek = entityBO.getInstructionDate().getDayOfWeek();
		switch (dayOfWeek) {
		case SATURDAY:
			entityBO.setSettlementDate(entityBO.getSettlementDate().plusDays(2));
			break;
		case SUNDAY:
			entityBO.setSettlementDate(entityBO.getSettlementDate().plusDays(1));
			break;
		default:
			break;
		}
	}

	public final List<EntityBO> filterEntitiesBasedOnInstructionType(final List<EntityBO> entityInstructionBOs,
			final String transactionType) {
		List<EntityBO> filteredEntityBOs = entityInstructionBOs.stream().filter(
				entityInstructionBO -> transactionType.equalsIgnoreCase(entityInstructionBO.getInstructionType()))
				.collect(Collectors.toList());
		return filteredEntityBOs;
	}

}
