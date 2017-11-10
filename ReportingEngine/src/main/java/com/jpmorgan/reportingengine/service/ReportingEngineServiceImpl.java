package com.jpmorgan.reportingengine.service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.jpmorgan.reportingengine.client.ReportEngineSampleData;
import com.jpmorgan.reportingengine.constants.ReportingEngineConstants;
import com.jpmorgan.reportingengine.model.EntityBO;
import com.jpmorgan.reportingengine.util.ReportingEngineEntityGenericUtil;
import com.jpmorgan.reportingengine.util.ReportingEngineEntityLogUtil;

public class ReportingEngineServiceImpl implements ReportingEngineService {

	final ReportingEngineEntityGenericUtil reportingEngineEntityGenericUtil = new ReportingEngineEntityGenericUtil();
	final ReportingEngineEntityLogUtil reportingEngineEntityLogUtil = new ReportingEngineEntityLogUtil();

	@Override
	public List<EntityBO> getListOfEntities(final String instructionType) {
		final List<EntityBO> entityBOs = reportingEngineEntityGenericUtil
				.filterEntitiesBasedOnInstructionType(ReportEngineSampleData.getAllData(), instructionType);
		return reportingEngineEntityGenericUtil.getListOfEntities(entityBOs);

	}

	@Override
	public void calculateSettledAmount(final List<EntityBO> entityBOs, final String instructionType) {
		final Map<LocalDate, List<EntityBO>> reportingEngineMap = entityBOs.stream()
				.collect(Collectors.groupingBy(EntityBO::getInstructionDate));
		reportingEngineMap.forEach((key, value) -> {
			double total = 0.0;
			if (value.size() > 1) {
				for (EntityBO entityBO : value) {
					total = instructionType.equalsIgnoreCase(ReportingEngineConstants.SELL_INCOMING_FLAG)
							? total + entityBO.getIncomingAmtSettled() : total + entityBO.getOutgoingAmtSettled();
				}
				reportingEngineEntityLogUtil.log(instructionType, key, total);

			} else {
				reportingEngineEntityLogUtil.log(instructionType, key, value);
			}
		});
	}

	@Override
	public void calculateRankings(final List<EntityBO> entityBOs, final String instructionType) {
		entityBOs.sort(Comparator.comparing(EntityBO::getIncomingAmtSettled).reversed());
		reportingEngineEntityLogUtil.log(entityBOs, instructionType);
	}
}
