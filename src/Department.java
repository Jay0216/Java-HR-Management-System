import javax.swing.table.DefaultTableModel;
import java.io.*;

public class Department {

    public String department_name;

    public String department_id;









    public void showDepartmentDetails(DefaultTableModel table_model){

        System.out.println("Getting department data from the file");

        try{
            BufferedReader department_file_read = new BufferedReader(new FileReader("D:\\Java Projects\\Automated HR System\\src\\department_details.txt"));
            String read_line;

            while((read_line = department_file_read.readLine()) != null){
                String[] read_specific_line = read_line.split(" ");

                if(read_specific_line.length >= 2){
                    String dep_name = read_specific_line[0];
                    String dep_id = read_specific_line[1];
                    table_model.addRow(new Object[]{dep_name, dep_id});
                }

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
