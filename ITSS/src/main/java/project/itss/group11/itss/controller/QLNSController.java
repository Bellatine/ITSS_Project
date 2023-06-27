package project.itss.group11.itss.controller;

import project.itss.group11.itss.view.QLNSView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import javafx.scene.input.MouseEvent;
import project.itss.group11.itss.controller.TemplateController;
import project.itss.group11.itss.model.ImportFileChamCongModel;
import project.itss.group11.itss.view.TemplateView;

public class QLNSController{
	QLNSView qlnsView;
	ImportFileChamCongModel importFileChamCongModel = new ImportFileChamCongModel();
	public QLNSController(QLNSView qlnsView) {
		this.qlnsView = qlnsView;
	}
	
	public void handleCsvInput(File file) {
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (file != null) {
			 //openFile(file);
			CSVReader reader = new CSVReader(fileReader);
			List<String[]> rows = null;
			try {
				rows = reader.readAll();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (CsvException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			importFileChamCongModel.inputRows(rows);
			importFileChamCongModel.checkDuplicate();
			
		}
	}
	
	public void handleShowTable() {
		qlnsView.showTable(importFileChamCongModel.getInputList(), importFileChamCongModel.getIsDuplicate());
	}
}
