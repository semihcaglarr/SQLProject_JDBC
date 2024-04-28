package SQL_Tasks;

import Utilities.DBUtility;
import org.testng.annotations.Test;

import java.util.List;

public class Tasks_9_between_17 extends DBUtility {

    @Test
    public void Task9() {
        List<List<String>> dbList = getListData("SELECT d.dept_no, d.dept_name, AVG(s.salary) AS average_salary FROM employees e JOIN dept_emp de ON e.emp_no = de.emp_no JOIN salaries s ON e.emp_no = s.emp_no JOIN departments d ON de.dept_no = d.dept_no GROUP BY d.dept_no, d.dept_name;");

        System.out.println("**** Calculate the average salary for each department, including department names ****");
        System.out.println();

        for (int i = 0; i < dbList.size(); i++) {
            for (int j = 0; j < dbList.get(i).size(); j++) {
                System.out.print(dbList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void Task10() {
        List<List<String>> dbList = getListData("SELECT emp_no, salary, from_date, to_date FROM salaries WHERE emp_no = '10102' ORDER BY from_date;");

        System.out.println("**** Calculate the average salary for each department, including department names ****");
        System.out.println();

        for (int i = 0; i < dbList.size(); i++) {
            for (int j = 0; j < dbList.get(i).size(); j++) {
                System.out.print(dbList.get(i).get(j) + " ");
            }
            System.out.println();
        }






    }


}
