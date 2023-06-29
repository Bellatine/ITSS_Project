package project.itss.group11.itss.repository.Impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import project.itss.group11.itss.Until.Constant;
import project.itss.group11.itss.model.Form;
import project.itss.group11.itss.model.FormDatabase;
import project.itss.group11.itss.model.LogInfor;
import project.itss.group11.itss.repository.FormDataRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FormDataRepositoryImpl implements FormDataRepository {
    private static final Logger logger = LogManager.getLogger(LogInforRepositoryImpl.class);
    private static final String getFormData = "SELECT * FROM form JOIN logcc ON form.idlog = logcc.id WHERE status = 'false'";

    @Override
    public ObservableList<FormDatabase> getFormData() {

        ObservableList<FormDatabase> formDatabases = FXCollections.observableArrayList();
        try{
            Connection connection = Constant.pool.getConnection();
            PreparedStatement stmt = connection.prepareStatement(getFormData);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                FormDatabase formDatabase = new FormDatabase();
                formDatabase.setIdnhanvien(rs.getInt("idnhanvien"));
                formDatabase.setNewtime(rs.getTimestamp("newtime").toLocalDateTime());
                formDatabase.setIdlog(rs.getInt("idlog"));
                formDatabase.setOldtime(rs.getTimestamp("timestamp").toLocalDateTime());
                formDatabases.add(formDatabase);
            }
            rs.close();
            stmt.close();
            Constant.pool.releaseConnection(connection);
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return formDatabases;
    }

}

