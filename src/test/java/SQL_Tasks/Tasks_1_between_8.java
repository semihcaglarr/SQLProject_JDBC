package SQL_Tasks;

import Utilities.DBUtility;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.List;

public class Tasks_1_between_8 extends DBUtility {

    @Test
    public void Task3() throws SQLException {
        DBConnectionOpen();

        ResultSet rs = sorguEkrani.executeQuery("SELECT AVG(salary) AS average_salary FROM salaries;");

        rs.next();

        System.out.println("**** Calculate the average salary of all employees ****");
        System.out.println();

        System.out.println(rs.getString(1));


        DBConnectionClose();

    }

    @Test
    public void Task8() {
        List<List<String>> dbList = getListData("SELECT de.dept_no, AVG(s.salary) AS average_salary FROM dept_emp de JOIN salaries s ON de.emp_no = s.emp_no GROUP BY de.dept_no;");

        System.out.println("**** Calculate the average salary for each department (by department number or department name) ****");
        System.out.println("By Department No");
        System.out.println();

        for (int i = 0; i < dbList.size(); i++) {
            for (int j = 0; j < dbList.get(i).size(); j++) {
                System.out.print(dbList.get(i).get(j) + " ");
            }
            System.out.println();
        }

        System.out.println("-------------------------------------------------------------");

        List<List<String>> dbList1 = getListData("SELECT dept_name, AVG(salary) AS avg_salary FROM departments JOIN dept_emp ON departments.dept_no = dept_emp.dept_no JOIN salaries ON dept_emp.emp_no = salaries.emp_no GROUP BY departments.dept_no;");

        System.out.println("By Department Name");
        System.out.println();

        for (int i = 0; i < dbList1.size(); i++) {
            for (int j = 0; j < dbList1.get(i).size(); j++) {
                System.out.print(dbList1.get(i).get(j) + " ");
            }
            System.out.println();
        }

    }




}
