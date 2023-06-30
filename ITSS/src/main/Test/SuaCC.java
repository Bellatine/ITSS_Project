import org.junit.Assert;
import org.junit.Test;
import project.itss.group11.itss.service.*;

import java.time.LocalDateTime;

public class EmployeeTimekeepingOverviewTest {

    IFormOverviewService formOverviewService = new FormOverviewServiceImpl();

    @Test
    public void test1() {
        ObservableList<Form> dataList = formOverviewService.getFormData();
        for (Form form : dataList) {
            System.out.println(form.idform);
        }
    }
}
