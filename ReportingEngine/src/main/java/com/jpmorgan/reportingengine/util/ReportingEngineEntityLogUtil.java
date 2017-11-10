package com.jpmorgan.reportingengine.util;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;
import com.jpmorgan.reportingengine.constants.ReportingEngineConstants;
import com.jpmorgan.reportingengine.model.EntityBO;

public class ReportingEngineEntityLogUtil {

	final static Logger logger = Logger.getLogger(ReportingEngineEntityLogUtil.class.getName());

	public void log(String transactionType, LocalDate key, double total) {
		if (transactionType.equalsIgnoreCase(ReportingEngineConstants.SELL_INCOMING_FLAG)) {
			logger.info("Total incoming amount settled on " + key + " is = " + total + "$");

		} else {
			logger.info("Total outgoing amount settled on " + key + " is = " + total + "$");

		}
	}

	public void log(String transactionType, LocalDate key, List<EntityBO> value) {
		if (transactionType.equalsIgnoreCase(ReportingEngineConstants.SELL_INCOMING_FLAG)) {
			logger.info(
					"Total incoming amount settled on " + key + " is = " + value.get(0).getIncomingAmtSettled() + "$");

		} else {
			logger.info(
					"Total outgoing amount settled on " + key + " is = " + value.get(0).getOutgoingAmtSettled() + "$");

		}
	}

	public void log(List<EntityBO> entityBOs, String transactionType) {
		int rankIndex = 1;
		if (transactionType.equalsIgnoreCase(ReportingEngineConstants.SELL_INCOMING_FLAG)) {

			logger.info("-----------------Ranking entities based on Sell instruction-------------");
			for (EntityBO entityBO : entityBOs) {
				logger.info("Entity " + entityBO.getEntityName() + " is ranked " + rankIndex);
				rankIndex++;
			}

		} else {
			rankIndex = 1;
			logger.info("-----------------Ranking entities based on Buy instruction-------------");
			for (EntityBO entityBO : entityBOs) {
				logger.info("Entity " + entityBO.getEntityName() + " is ranked " + rankIndex);
				rankIndex++;
			}
		}

	}

}
