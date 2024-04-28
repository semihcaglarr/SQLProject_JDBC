package SQL_Tasks;

import Utilities.DBUtility;
import org.testng.annotations.Test;

import java.sql.*;

public class Tasks_1_between_8 extends DBUtility {

    @Test
    public void CalculatetheAverageSalaryofAllEmployees3() throws SQLException {
        DBConnectionOpen();

        ResultSet rs = sorguEkrani.executeQuery("SELECT AVG(salary) AS average_salary FROM salaries;");

        rs.next();

        System.out.println("Average Salary of all Employees : " + rs.getString(1));


        DBConnectionClose();

    }


}
