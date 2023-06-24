package project.itss.group11.itss.service.Impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import project.itss.group11.itss.model.LogInfor;
import project.itss.group11.itss.model.TimekeepingOverview;
import project.itss.group11.itss.service.IEmployeeTimekeepingOverview;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EmployeeTimekeepingOverviewImpl implements IEmployeeTimekeepingOverview {

    @Override
    public int getDay(int Month,int year) {
        List<Integer> month31day = new ArrayList<>(List.of(1, 3, 5, 7, 8, 10,12));
        List<Integer> month30day = new ArrayList<>(List.of(4,6,9,11));
        if(month31day.contains(Month))
            return 31;
        if(month30day.contains(Month))
            return 30;
        if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
            return 29;
        else return 28;
    }

    @Override
    public String getStartTime(LocalDateTime time) {
        return time.getHour()+":"+time.getMinute();
    }

    @Override
    public String getEndTime(LocalDateTime time) {
        return time.getHour()+":"+time.getMinute();
    }

    @Override
    public String getReturnEarlyTime(LocalDateTime returningTime, LocalDateTime endTime) {
       boolean isReturningEarly = returningTime.getHour()*3600 + returningTime.getMinute()*60 + returningTime.getSecond()
               < endTime.getHour()*3600 + endTime.getMinute()*60 + endTime.getSecond();
       if(isReturningEarly)
           return "Yes";
       else
           return "No";
    }

    @Override
    public String getComeLateTime(LocalDateTime comingTime, LocalDateTime startTime) {
        boolean isComeLate = comingTime.getHour()*3600 + comingTime.getMinute()*60 + comingTime.getSecond()
                > startTime.getHour()*3600 + startTime.getMinute()*60 + startTime.getSecond();
        if(isComeLate)
            return "Yes";
        else
            return "No";
    }

    @Override
    public ObservableList<TimekeepingOverview> getTimekeepingByMonth(LocalDate time,LocalDateTime start, LocalDateTime end) {
        ObservableList<TimekeepingOverview> timekeepingOverviews = FXCollections.observableArrayList();
        List<LogInfor> logInfors = new ArrayList<>();
        // data to test
        LocalDateTime date1 = LocalDateTime.of(2023, 6, 24, 9, 00, 0);
        LocalDateTime date2 = LocalDateTime.of(2023, 6, 24, 17, 0, 0);
        LocalDateTime date3 = LocalDateTime.of(2023, 5, 23, 7, 00, 0);
        LocalDateTime date4 = LocalDateTime.of(2023, 5, 23, 18, 0, 0);
        // test
        TimekeepingOverview t1 = new TimekeepingOverview(date1.getDayOfMonth()
                , getStartTime(date1),getEndTime(date2),getComeLateTime(date1,start),
                getReturnEarlyTime(date2,end));
        TimekeepingOverview t2 = new TimekeepingOverview(date3.getDayOfMonth()
                , getStartTime(date3),getEndTime(date4),getComeLateTime(date3,start),
                getReturnEarlyTime(date4,end));

            timekeepingOverviews.add(t1);

            timekeepingOverviews.add(t2);


        return timekeepingOverviews;
    }
}
