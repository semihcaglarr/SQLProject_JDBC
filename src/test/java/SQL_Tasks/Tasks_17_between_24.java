package SQL_Tasks;

import Utilities.DBUtility;
import org.testng.annotations.Test;

import java.util.List;

public class Tasks_17_between_24 extends DBUtility {

    @Test
    public void Task17() {
        List<List<String>> dbList = getListData("SELECT d.dept_name AS department, e.first_name, e.last_name, AVG(s.salary) AS avg_salary FROM employees e INNER JOIN dept_emp de ON e.emp_no = de.emp_no INNER JOIN departments d ON de.dept_no = d.dept_no INNER JOIN salaries s ON e.emp_no = s.emp_no GROUP BY department ORDER BY avg_salary DESC;");

        System.out.println("**** Identify the employees in each department who have the highest average salary ****");
        System.out.println("**** List the department name, employee's first name, last name, and the average salary ****");
        System.out.println("**** Order the results by average salary in descending order, showing only those with the highest average salary within their department ****");
        System.out.println();

        //System.out.printf("%-20s %-20s %-20s %-10s\n", "Department", "First Name", "Last Name", "Avg Salary");
        for (int i = 0; i < dbList.size(); i++) {
            for (int j = 0; j < dbList.get(i).size(); j += dbList.get(i).size()) {
                System.out.printf("%-20s %-20s %-20s %-10s", dbList.get(i).get(j), dbList.get(i).get(j + 1), dbList.get(i).get(j + 2), dbList.get(i).get(j + 3));
            }
            System.out.println();
        }
    }
}
