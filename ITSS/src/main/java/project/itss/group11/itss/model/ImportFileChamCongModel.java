package project.itss.group11.itss.model;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import project.itss.group11.itss.model.LogInfor;

public class ImportFileChamCongModel {
	private ArrayList<LogInfor> existedList = new ArrayList<LogInfor>();
	private ArrayList<LogInfor> inputList = new ArrayList<LogInfor>();
	private ArrayList<LogInfor> writeToDBList = new ArrayList<LogInfor>();
	private ArrayList<Boolean> isDuplicate = new ArrayList<Boolean>();
	
	public ArrayList<LogInfor> getInputList() {
		return inputList;
	}

	public ArrayList<Boolean> getIsDuplicate() {
		return isDuplicate;
	}

	public ImportFileChamCongModel() {
		// TODO Auto-generated constructor stub
	}
	
	public void checkDuplicate() {
//		for(int i=0; i< inputList.size();i++) {
//			if(existedList.contains(inputList.get(i)))
//				isDuplicate.
//		}
		for(LogInfor logInfor: inputList) {
			if(existedList.contains(logInfor))
				isDuplicate.add(true);
			else
				isDuplicate.add(false);
		}
	}
	
	public void inputRows(List<String[]> rows) {
		for(String[] row: rows) {
			System.out.println("Input a row");
//			System.out.println(row[0]);
//			System.out.println(row[1]);
//			System.out.println(row[2]);
//			StringBuilder builder = new StringBuilder();
//	        for (int i = 0; i < row[0].length(); i++) {
//	            char c = row[0].charAt(i);
//	            if(c > 47 && c < 58){
//	                builder.append(c);
//	            }
//	            System.out.println(c);
//	        }
			LogInfor temp = new LogInfor();
			
//			int id = Integer.parseInt(builder.toString());
			int id = Integer.parseInt(row[0]);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
			LocalDateTime timeStamp = LocalDateTime.parse(row[1], formatter);
			int device = Integer.parseInt(row[2]);
			temp.setEmployeeID(id);
			temp.setTimeStamp(timeStamp);
			temp.setDevice(device);
			inputList.add(temp);
			System.out.println("Inputed a row");
		}
	}
}
