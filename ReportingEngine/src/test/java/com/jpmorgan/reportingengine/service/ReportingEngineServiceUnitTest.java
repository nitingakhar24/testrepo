package com.jpmorgan.reportingengine.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.jpmorgan.reportingengine.model.EntityBO;

public class ReportingEngineServiceUnitTest

{
	private ReportingEngineService reportingEngineServiceImpl;
	public static String BUY_OUTGOING_FLAG = "B";
	public static String SELL_INCOMING_FLAG = "S";
	public static String INVALID__INSTRUCTION_FLAG = "X";

	@Before
	public void setUp() {
		reportingEngineServiceImpl = new ReportingEngineServiceImpl();
	}

	@Test
	public void shouldReturnListWithNoRecordsWithInvalidInstructionType() {
		List<EntityBO> results = reportingEngineServiceImpl.getListOfEntities(INVALID__INSTRUCTION_FLAG);
		assertEquals(0, results.size());
	}

	@Test
	public void shouldReturnListWithSellInstructionType() {
		List<EntityBO> results = reportingEngineServiceImpl.getListOfEntities(SELL_INCOMING_FLAG);
		boolean sellFlag = results.stream()
				.allMatch(entityBO -> entityBO.getInstructionType().equalsIgnoreCase(SELL_INCOMING_FLAG));
		assertTrue("The list contains of entities with Sell instruction", sellFlag);

	}

	@Test
	public void shouldReturnListWithBuyInstructionType() {
		List<EntityBO> results = reportingEngineServiceImpl.getListOfEntities(BUY_OUTGOING_FLAG);
		boolean sellFlag = results.stream()
				.allMatch(entityBO -> entityBO.getInstructionType().equalsIgnoreCase(BUY_OUTGOING_FLAG));
		assertTrue("The list contains of entities with Buy instruction", sellFlag);

	}

	@Test
	public void shouldDisplayEntitiesWithSellInstructionType() {
		reportingEngineServiceImpl.calculateSettledAmount(
				reportingEngineServiceImpl.getListOfEntities(SELL_INCOMING_FLAG), SELL_INCOMING_FLAG);
	}

	@Test
	public void shouldDisplayEntitiesWithBuyInstructionType() {
		reportingEngineServiceImpl.calculateSettledAmount(
				reportingEngineServiceImpl.getListOfEntities(BUY_OUTGOING_FLAG), BUY_OUTGOING_FLAG);
	}
	
	@After
	public void tearDown()
	{
		reportingEngineServiceImpl = null;
	}

}
