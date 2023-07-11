package project.itss.group11.itss.test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import project.itss.group11.itss.Until.ConnectionPool;
import project.itss.group11.itss.Until.Constant;
import project.itss.group11.itss.controller.ImportFileChamCongController;
import project.itss.group11.itss.model.ImportFileChamCongModel;
import project.itss.group11.itss.model.LogInfor;

public class importFileChamCongTest {
	@Test
	public void testInputRows() {
		ImportFileChamCongModel importFileChamCongModel = new ImportFileChamCongModel();
		List<String[]> test = new ArrayList<>();
		String[] test1 = {"20203333", "01/04/2023 04:20", "1"};
		test.add(test1);
		importFileChamCongModel.inputRows(test);
		
		ArrayList<LogInfor> inputList = new ArrayList<>();
		LogInfor logInfor = new LogInfor();
		logInfor.setDevice(1);
		logInfor.setEmployeeID(20203333);
		LocalDateTime localDateTime = LocalDateTime.of(
	            2023, Month.APRIL, 1, 4, 20);
		logInfor.setTimeStamp(localDateTime);
		inputList.add(logInfor);
		
		assertEquals(importFileChamCongModel.getInputList(),inputList);
	}

	@Test
	public void testCheckDuplicate1() {
		Constant.pool = ConnectionPool.getInstance("etc/database.config");
		LogInfor logInfor = new LogInfor();
		logInfor.setDevice(2);
		logInfor.setEmployeeID(20204939);
		LocalDateTime localDateTime = LocalDateTime.of(
	            2023, Month.JUNE, 1, 7, 34, 56);
		logInfor.setTimeStamp(localDateTime);
		ImportFileChamCongModel importFileChamCongModel = new ImportFileChamCongModel();
		ArrayList<LogInfor> inputList = new ArrayList<LogInfor>();
		inputList.add(logInfor);
		importFileChamCongModel.setInputList(inputList);
		importFileChamCongModel.checkDuplicate();
		
		ArrayList<Boolean> isDuplicate = new ArrayList<>();
		isDuplicate.add(false);
		
		assertEquals(importFileChamCongModel.getIsDuplicate(),isDuplicate);
	}
	
	@Test
	public void testCheckDuplicate2() {
		Constant.pool = ConnectionPool.getInstance("etc/database.config");
		LogInfor logInfor = new LogInfor();
		logInfor.setDevice(1);
		logInfor.setEmployeeID(20204939);
		LocalDateTime localDateTime = LocalDateTime.of(
	            2023, Month.JUNE, 1, 7, 34, 56);
		logInfor.setTimeStamp(localDateTime);
		ImportFileChamCongModel importFileChamCongModel = new ImportFileChamCongModel();
		ArrayList<LogInfor> inputList = new ArrayList<LogInfor>();
		inputList.add(logInfor);
		importFileChamCongModel.setInputList(inputList);
		importFileChamCongModel.checkDuplicate();
		
		ArrayList<Boolean> isDuplicate = new ArrayList<>();
		isDuplicate.add(true);
		
		assertEquals(importFileChamCongModel.getIsDuplicate(),isDuplicate);
	}
	
//	@Test(expected = Exception.class)
//	public void testHandleCsvInput1() {
//		Constant.pool = ConnectionPool.getInstance("etc/database.config");
//		ImportFileChamCongController importFileChamCongController = new ImportFileChamCongController();
//		File file = new File("etc/test.csv");
//		boolean check = importFileChamCongController.handleCsvInput(file);
//		System.out.println(check);
//		assertEquals(check,false);
//	}
//	
//	@Test
//	public void testInputRows() {
//		Constant.pool = ConnectionPool.getInstance("etc/database.config");
//		ImportFileChamCongController importFileChamCongController = new ImportFileChamCongController();
//		File file = new File("etc/Book1.csv");
//		boolean check = importFileChamCongController.handleCsvInput(file);
//		System.out.println(check);
//		assertEquals(check,true);
//	}
}
