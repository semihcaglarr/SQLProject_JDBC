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

    @Test
    public void Task13() {
        List<List<String>> dbList = getListData("SELECT emp_no, salary, to_date FROM salaries WHERE (emp_no, to_date) IN (SELECT emp_no, MAX(to_date) FROM salaries GROUP BY emp_no);");

        System.out.println("**** Find the latest salaries for each employee ****");
        System.out.println();

        for (int i = 0; i < dbList.size(); i++) {
            for (int j = 0; j < dbList.get(i).size(); j++) {
                System.out.print(dbList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void Task14() {
        List<List<String>> dbList = getListData("SELECT e.first_name, e.last_name, MAX(s.salary) AS highest_salary FROM employees e INNER JOIN dept_emp de ON e.emp_no = de.emp_no INNER JOIN departments d ON de.dept_no = d.dept_no INNER JOIN salaries s ON e.emp_no = s.emp_no WHERE d.dept_name = 'Sales' GROUP BY e.first_name, e.last_name ORDER BY highest_salary DESC LIMIT 1;");

        System.out.println("**** List the first name, last name, and highest salary of employees in the 'Sales' department ****");
        System.out.println("**** Order the list by highest salary descending and only show the employee with the highest salary ****");
        System.out.println();

        for (int i = 0; i < dbList.size(); i++) {
            for (int j = 0; j < dbList.get(i).size(); j++) {
                System.out.print(dbList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void Task15() {
        List<List<String>> dbList = getListData("SELECT e.first_name, e.last_name, MAX(s.salary) AS max_salary FROM employees e INNER JOIN dept_emp de ON e.emp_no = de.emp_no INNER JOIN departments d ON de.dept_no = d.dept_no INNER JOIN salaries s ON e.emp_no = s.emp_no WHERE d.dept_name = 'Research' GROUP BY e.first_name, e.last_name ORDER BY max_salary DESC LIMIT 1;");

        System.out.println("**** Find the Employee with the Highest Salary Average in the Research Department ****");
        System.out.println();

        for (int i = 0; i < dbList.size(); i++) {
            for (int j = 0; j < dbList.get(i).size(); j++) {
                System.out.print(dbList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    @Test
        public void Task16() {
            List<List<String>> dbList = getListData("SELECT d.dept_name AS department, e.first_name, e.last_name, MAX(s.salary) AS max_salary FROM employees e INNER JOIN dept_emp de ON e.emp_no = de.emp_no INNER JOIN departments d ON de.dept_no = d.dept_no INNER JOIN salaries s ON e.emp_no = s.emp_no GROUP BY d.dept_name ORDER BY max_salary DESC;");

            System.out.println("**** For each department, identify the employee with the highest single salary ever recorded ****");
            System.out.println("**** List the department name, employee's first name, last name, and the peak salary amount ****");
            System.out.println("**** Ordered by the peak salary in descending order ****");
            System.out.println();

            // Define column widths for better formatting
            final int departmentWidth = 21;
            final int firstNameWidth = 15;
            final int lastNameWidth = 15;
            final int salaryWidth = 10;

            // Print header row
            System.out.format("%-" + departmentWidth + "s", "Department");
            System.out.format("%-" + firstNameWidth + "s", "First Name");
            System.out.format("%-" + lastNameWidth + "s", "Last Name");
            System.out.format("%" + salaryWidth + "s\n", "Salary");

            // Print separator line
            for (int i = 0; i < departmentWidth + firstNameWidth + lastNameWidth + salaryWidth + 6; i++) {
                System.out.print("-");
            }
            System.out.println();

            // Iterate through each row and format using String.format
            for (List<String> row : dbList) {
                String formattedRow = String.format("%-" + departmentWidth + "s", row.get(0)) +
                        String.format("%-" + firstNameWidth + "s", row.get(1)) +
                        String.format("%-" + lastNameWidth + "s", row.get(2)) +
                        String.format("%" + salaryWidth + "d", Integer.parseInt(row.get(3)));
                System.out.println(formattedRow);
            }
        }

    }















