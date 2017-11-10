package com.jpmorgan.reportingengine.client;

import com.jpmorgan.reportingengine.constants.ReportingEngineConstants;
import com.jpmorgan.reportingengine.service.ReportingEngineService;
import com.jpmorgan.reportingengine.service.ReportingEngineServiceImpl;

public class ReportingEngineClient {
	public static void main(String[] args) {
		final ReportingEngineService reportingEngineService = new ReportingEngineServiceImpl();

		// 1) Amount in USD settled incoming everyday
		reportingEngineService.calculateSettledAmount(reportingEngineService.getListOfEntities(ReportingEngineConstants.SELL_INCOMING_FLAG),
				ReportingEngineConstants.SELL_INCOMING_FLAG);

		// 2) Amount in USD settled incoming everyday
		reportingEngineService.calculateSettledAmount(reportingEngineService.getListOfEntities(ReportingEngineConstants.BUY_OUTGOING_FLAG),
				ReportingEngineConstants.BUY_OUTGOING_FLAG);

		// 3 Entity rankings with SELL instruction
		reportingEngineService.calculateRankings(reportingEngineService.getListOfEntities(ReportingEngineConstants.SELL_INCOMING_FLAG),
				ReportingEngineConstants.SELL_INCOMING_FLAG);

		// 4 Entity rankings with BUY instruction
		reportingEngineService.calculateRankings(reportingEngineService.getListOfEntities(ReportingEngineConstants.BUY_OUTGOING_FLAG),
				ReportingEngineConstants.BUY_OUTGOING_FLAG);

	}
}
