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

    @Test
    public void Task18() {
        List<List<String>> dbList = getListData("SELECT first_name, last_name, hire_date FROM employees WHERE hire_date < '1990-01-01' ORDER BY first_name ASC, last_name ASC LIMIT 10000;");

        System.out.println("**** List the names, last names, and hire dates in alphabetical order of all employees hired before January 01, 1990 ****");
        System.out.println();

        for (int i = 0; i < dbList.size(); i++) {
            for (int j = 0; j < dbList.get(i).size(); j++) {
                System.out.print(dbList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void Task19() {
        List<List<String>> dbList = getListData("SELECT first_name, last_name, hire_date FROM employees WHERE hire_date BETWEEN '1985-01-01' AND '1989-12-31' ORDER BY hire_date ASC LIMIT 10000;");

        System.out.println("**** List the names, last names, hire dates of all employees hired ****");
        System.out.println("**** Between January 01, 1985 and December 31, 1989, sorted by hire date ****");
        System.out.println();

        for (int i = 0; i < dbList.size(); i++) {
            for (int j = 0; j < dbList.get(i).size(); j++) {
                System.out.print(dbList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void Task20(){
        List<List<String>> dbList = getListData("SELECT e.first_name, e.last_name, e.hire_date, s.salary FROM employees e JOIN salaries s ON e.emp_no = s.emp_no WHERE e.hire_date BETWEEN '1985-01-01' AND '1989-12-31' AND e.emp_no IN (SELECT emp_no FROM dept_emp WHERE dept_no IN (SELECT dept_no FROM departments WHERE dept_name = 'Sales')) ORDER BY s.salary DESC LIMIT 10000;");

        System.out.println("**** List the names, last names, hire dates, and salaries of all employees ****");
        System.out.println("**** In the Sales department who were hired between January 01, 1985 and December 31, 1989, sorted by salary in descending order. ****");
        System.out.println();

        for (int i = 0; i < dbList.size(); i++) {
            for (int j = 0; j < dbList.get(i).size(); j++) {
                System.out.print(dbList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

}

