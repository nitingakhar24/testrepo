package com.jpmorgan.reportingengine.client;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.jpmorgan.reportingengine.model.EntityBO;

public class ReportEngineSampleData {

	public static List<EntityBO> getAllData() {
		List<EntityBO> entityInstructionBOs = new ArrayList<EntityBO>();
		EntityBO entityInstructionBO1 = new EntityBO();
		entityInstructionBO1.setEntityName("foo");
		entityInstructionBO1.setAgreedFx(0.5);
		entityInstructionBO1.setCurrency("SGP");
		entityInstructionBO1.setInstructionDate(LocalDate.of(2016, 01, 01));
		entityInstructionBO1.setInstructionType("B");
		entityInstructionBO1.setSettlementDate(LocalDate.of(2016, 01, 02));
		entityInstructionBO1.setNumberOfUnits(200);
		entityInstructionBO1.setPricePerUnit(100.25);
		entityInstructionBOs.add(entityInstructionBO1);

		EntityBO entityInstructionBO2 = new EntityBO();
		entityInstructionBO2.setEntityName("bar");
		entityInstructionBO2.setAgreedFx(0.22);
		entityInstructionBO2.setCurrency("SGP");
		entityInstructionBO2.setInstructionDate(LocalDate.of(2016, 01, 05));
		entityInstructionBO2.setInstructionType("S");
		entityInstructionBO2.setSettlementDate(LocalDate.of(2016, 01, 07));
		entityInstructionBO2.setNumberOfUnits(450);
		entityInstructionBO2.setPricePerUnit(100.25);
		entityInstructionBOs.add(entityInstructionBO2);


		EntityBO entityInstructionBO3 = new EntityBO();
		entityInstructionBO3.setEntityName("foo1");
		entityInstructionBO3.setAgreedFx(0.5);
		entityInstructionBO3.setCurrency("SAR");
		entityInstructionBO3.setInstructionDate(LocalDate.of(2016, 01, 02));
		entityInstructionBO3.setInstructionType("B");
		entityInstructionBO3.setSettlementDate(LocalDate.of(2016, 01, 03));
		entityInstructionBO3.setNumberOfUnits(300);
		entityInstructionBO3.setPricePerUnit(101.25);
		entityInstructionBOs.add(entityInstructionBO3);
		
		EntityBO entityInstructionBO4 = new EntityBO();
		entityInstructionBO4.setEntityName("bar1");
		entityInstructionBO4.setAgreedFx(0.21);
		entityInstructionBO4.setCurrency("SAR");
		entityInstructionBO4.setInstructionDate(LocalDate.of(2016, 01, 06));
		entityInstructionBO4.setInstructionType("S");
		entityInstructionBO4.setSettlementDate(LocalDate.of(2016, 01, 10));
		entityInstructionBO4.setNumberOfUnits(250);
		entityInstructionBO4.setPricePerUnit(100.2);
		entityInstructionBOs.add(entityInstructionBO4);
		
		EntityBO entityInstructionBO5= new EntityBO();
		entityInstructionBO5.setEntityName("bar2");
		entityInstructionBO5.setAgreedFx(0.20);
		entityInstructionBO5.setCurrency("INR");
		entityInstructionBO5.setInstructionDate(LocalDate.of(2017, 10, 22));
		entityInstructionBO5.setInstructionType("S");
		entityInstructionBO5.setSettlementDate(LocalDate.of(2017, 10, 22));
		entityInstructionBO5.setNumberOfUnits(250);
		entityInstructionBO5.setPricePerUnit(100);
		entityInstructionBOs.add(entityInstructionBO5);
		
		EntityBO entityInstructionBO6= new EntityBO();
		entityInstructionBO6.setEntityName("bar3");
		entityInstructionBO6.setAgreedFx(0.20);
		entityInstructionBO6.setCurrency("INR");
		entityInstructionBO6.setInstructionDate(LocalDate.of(2017, 10, 22));
		entityInstructionBO6.setInstructionType("S");
		entityInstructionBO6.setSettlementDate(LocalDate.of(2017, 10, 22));
		entityInstructionBO6.setNumberOfUnits(200);
		entityInstructionBO6.setPricePerUnit(100);
		entityInstructionBOs.add(entityInstructionBO6);


		return entityInstructionBOs;
	}
}