import javax.swing.table.DefaultTableModel;
import java.io.IOException;

public  interface ManageEmployees {


     void addEmployees(String name, String id, String EPF, String Designations, String Departament);
     void searchEmployees(DefaultTableModel table_model, String search_cat, String search_name);



}
