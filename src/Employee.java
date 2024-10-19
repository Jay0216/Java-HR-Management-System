import javax.swing.table.DefaultTableModel;
import java.io.*;

public class Employee {
    public String emp_name;

    public String emp_id;

    public String EPF;

    public String Designation;

    public String Department;



    public Employee(String name, String id, String EPF, String Designations, String Department){
        this.emp_name = name;
        this.emp_id = id;
        this.EPF = EPF;
        this.Designation = Designations;
        this.Department = Department;
    }





    public void showEmployeeDetails(DefaultTableModel table_model){

        System.out.println("Employee Details");

        try{
            BufferedReader employee_file_reader = new BufferedReader(new FileReader("D:\\Java Projects\\Automated HR System\\src\\employee_details.txt"));
            String read_line;

            while((read_line = employee_file_reader.readLine()) != null){
                String[] read_specific_part = read_line.split(" ");

                if(read_specific_part.length >= 5){
                    String emp_name = read_specific_part[0];
                    String emp_id = read_specific_part[1];
                    String EPF = read_specific_part[2];
                    String designation = read_specific_part[3];
                    String departament = read_specific_part[4];
                    table_model.addRow(new Object[]{emp_name, emp_id, EPF, designation, departament});
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }



}
