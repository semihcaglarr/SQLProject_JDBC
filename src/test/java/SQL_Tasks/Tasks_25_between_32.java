package SQL_Tasks;

import Utilities.DBUtility;
import org.testng.annotations.Test;

import java.util.List;

public class Tasks_25_between_32 extends DBUtility {

    @Test
    public void Task25(){
        List<List<String>> dbList = getListData("SELECT * FROM employees WHERE first_name = 'Annemarie' AND last_name = 'Redmiles';");

        System.out.println("**** List the information (employee number, date of birth, first name, last name, gender, hire date) ****");
        System.out.println("**** Of the employee named 'Annemarie Redmiles' ****");
        System.out.println();

        for (int i = 0; i < dbList.size(); i++) {
            for (int j = 0; j < dbList.get(i).size(); j++) {
                System.out.print(dbList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }


}
