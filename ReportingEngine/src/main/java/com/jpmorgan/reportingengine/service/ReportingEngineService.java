package com.jpmorgan.reportingengine.service;

import java.util.List;

import com.jpmorgan.reportingengine.model.EntityBO;

public interface ReportingEngineService

{
	/**
	 * List entities based on filter passed as instruction type like SELL ("S") or BUY ("B")
	 * Includes settlement date modification logic if instruction date falls on weekend.
	 * And populates Incoming or Outgoing settlement amount logic
	 * @param instructionType
	 * @return List of EntityBO
	 */
	List<EntityBO> getListOfEntities(final String instructionType);

	/**
	 * Displays settled amount in USD based on instruction type like SELL ("S") or BUY ("B")
	 * @param entityBOs
	 * @param instructionType
	 */
	void calculateSettledAmount(final List<EntityBO> entityBOs, final String instructionType);

	/**
	 * Displays ranking of entities based on on instruction type like SELL ("S") or BUY ("B")
	 * @param entityBOs
	 * @param instructionType
	 */
	void calculateRankings(final List<EntityBO> entityBOs, final String instructionType);

}
