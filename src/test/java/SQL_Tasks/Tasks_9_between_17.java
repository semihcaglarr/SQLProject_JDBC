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

    @Test
    public void Task11() {
        List<List<String>> dbList = getListData("SELECT emp_no, salary, to_date FROM salaries WHERE emp_no = '10102' ORDER BY to_date;");

        System.out.println("**** Find the salary increases for employee with employee number '10102' (using the to_date column in salaries) ****");
        System.out.println();

        for (int i = 0; i < dbList.size(); i++) {
            for (int j = 0; j < dbList.get(i).size(); j++) {
                System.out.print(dbList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void Task12() {
        List<List<String>> dbList = getListData("SELECT * FROM employees JOIN salaries ON employees.emp_no = salaries.emp_no ORDER BY salary DESC LIMIT 1;");

        System.out.println("**** Find the employee with the highest salary ****");
        System.out.println();

        for (int i = 0; i < dbList.size(); i++) {
            for (int j = 0; j < dbList.get(i).size(); j++) {
                System.out.print(dbList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }






}
