package project.itss.group11.itss.repository.Impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import project.itss.group11.itss.Until.Constant;
import project.itss.group11.itss.model.LogInfor;
import project.itss.group11.itss.repository.LogInforRepository;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class LogInforRepositoryImpl implements LogInforRepository {
    private static final Logger logger = LogManager.getLogger(LogInforRepositoryImpl.class);
    private static final String q1 = "SELECT id,timestamp,device FROM logcc WHERE EXTRACT(DAY FROM timestamp) = ? and id=?";
    private static final String q2 = "SELECT id,timestamp,device FROM logcc WHERE EXTRACT(MONTH FROM timestamp) = ? and id=?";
    @Override
    public List<LogInfor> getLogInforByDay(int day,int user_id) {

        List<LogInfor> logInfors = new ArrayList<>();
        try{
            Connection connection = Constant.pool.getConnection();

            PreparedStatement stmt = connection.prepareStatement(q1);

            stmt.setInt(1,day);
            stmt.setInt(2,user_id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                LogInfor logInfor = new LogInfor();
                logInfor.setID(rs.getString("id"));
                logInfor.setTimeStamp(rs.getTimestamp("timestamp").toLocalDateTime());
                logInfor.setDevice(rs.getInt("device"));
                logInfors.add(logInfor);
            }
            rs.close();
            stmt.close();
            Constant.pool.releaseConnection(connection);
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return logInfors;
    }

    @Override
    public List<LogInfor> getLogInforByMonth(int month, int id) {
        List<LogInfor> logInfors = new ArrayList<>();
        try{
            Connection connection = Constant.pool.getConnection();

            PreparedStatement stmt = connection.prepareStatement(q2);

            stmt.setInt(1,month);
            stmt.setInt(2,id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                LogInfor logInfor = new LogInfor();
                logInfor.setID(rs.getString("id"));
                logInfor.setTimeStamp(rs.getTimestamp("timestamp").toLocalDateTime());
                logInfor.setDevice(rs.getInt("device"));
                logInfors.add(logInfor);
            }
            rs.close();
            stmt.close();
            Constant.pool.releaseConnection(connection);
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return logInfors;
    }
}
