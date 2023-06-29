package project.itss.group11.itss.service.Impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import project.itss.group11.itss.model.Form;
import project.itss.group11.itss.model.FormDatabase;
import project.itss.group11.itss.model.LogInfor;
import project.itss.group11.itss.model.TimekeepingOverview;
import project.itss.group11.itss.repository.FormDataRepository;
import project.itss.group11.itss.repository.Impl.FormDataRepositoryImpl;
import project.itss.group11.itss.service.IFormOverviewService;

import java.util.List;

public class FormOverviewServiceImpl implements IFormOverviewService {
    FormDataRepository formDataRepository = new FormDataRepositoryImpl();
    Form form = new Form();
    @Override
    public ObservableList<Form> getFormData(){
        ObservableList<Form> forms = FXCollections.observableArrayList();
        List<FormDatabase> formDatabases = formDataRepository.getFormData();
        for(FormDatabase formDatabase : formDatabases){
            form.setIdnv(formDatabase.getIdnhanvien());
            form.setNewT(formDatabase.getNewtime());
            form.setOldT(formDatabase.getOldtime());
            forms.add(form);
        }
        return forms;
    }
}
