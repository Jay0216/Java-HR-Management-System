import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

class HRAssistant extends User implements ManageEmployees, ManageUserLogins {

    String assistant_name;

    String assistant_username;

    String assistant_password;

    private Employee employee;



    @Override

    public void addEmployees(String name, String id, String EPF, String Designations, String Departament){

        System.out.println("Employees added by Assistant");


        employee = new Employee(name, id, EPF, Designations, Departament);

        saveEmployeeDetails(employee);



    }

    private void saveEmployeeDetails(Employee employee){

        try(FileWriter employeed_details_write = new FileWriter("D:\\Java Projects\\Automated HR System\\src\\employee_details.txt", true)) {



            employeed_details_write.write(employee.emp_name + " " + employee.emp_id + " " + employee.EPF + " " + employee.Designation + " " + employee.Department + "\n");


            employeed_details_write.close();
            System.out.println("Employee Created Success");

        }

        catch (IOException e){
            System.out.println("Error");
            e.printStackTrace();
        }



        //System.out.println("Employee Name is : " + emp_name);
        //System.out.println("Employeed id is : " + emp_id);
    }


    @Override

    public void searchEmployees(DefaultTableModel table_model, String search_cat, String search_name)  {

        System.out.println("Searching Employees By Assistant");



        String filePath = "D:\\Java Projects\\Automated HR System\\src\\employee_details.txt";
        String searched_result = null;

        try (BufferedReader employee_file_read = new BufferedReader(new FileReader(filePath))) {
            String read_line;

            while ((read_line = employee_file_read.readLine()) != null) {

                if (search_cat.equals("Name") && read_line.contains(search_name)) {
                    searched_result = read_line;
                    break;
                }else if(search_cat.equals("EPF") && read_line.contains(search_name)) {
                    searched_result = read_line;
                    break;
                }else if(search_cat.equals("Employee ID") && read_line.contains(search_name)){
                    searched_result = read_line;
                    break;
                }else if(search_cat.equals("Department") && read_line.contains(search_name)){
                    searched_result = read_line;
                    break;
                }else if(search_cat.equals("Designation") && read_line.contains(search_name)){
                    searched_result = read_line;
                    break;
                }

            }

            if (searched_result != null) {
                System.out.println("The Data Was Found: " + read_line);


                String[] search_criteria = searched_result.split(" ");

                String name = search_criteria[0];
                String emp_id = search_criteria[1];
                String EPF = search_criteria[2];
                String designation = search_criteria[3];
                String department = search_criteria[4];

                if(search_name.equals(name)){
                    try (BufferedWriter search_results_file_write = new BufferedWriter(new FileWriter("D:\\Java Projects\\Automated HR System\\src\\search_results.txt"))) {
                        search_results_file_write.write(read_line);
                        search_results_file_write.newLine();
                    }

                    try (BufferedReader search_file_read = new BufferedReader(new FileReader("D:\\Java Projects\\Automated HR System\\src\\search_results.txt"))) {
                        String searched_line;

                        while ((searched_line = search_file_read.readLine()) != null) {
                            String[] specific_parts = searched_line.split(" ");

                            if (specific_parts.length >= 5) {
                                String search_emp_name = specific_parts[0];
                                String search_emp_id = specific_parts[1];
                                String search_emp_epf = specific_parts[2];
                                String search_designation = specific_parts[3];
                                String search_department = specific_parts[4];
                                table_model.addRow(new Object[]{search_emp_name + " " + search_emp_id + " " + search_emp_epf + " " + search_designation + " " + search_department});
                            }
                        }
                    }
                }else if(search_name.equals(emp_id)){
                    try (BufferedWriter search_results_file_write = new BufferedWriter(new FileWriter("D:\\Java Projects\\Automated HR System\\src\\search_results.txt"))) {
                        search_results_file_write.write(read_line);
                        search_results_file_write.newLine();
                    }

                    try (BufferedReader search_file_read = new BufferedReader(new FileReader("D:\\Java Projects\\Automated HR System\\src\\search_results.txt"))) {
                        String searched_line;

                        while ((searched_line = search_file_read.readLine()) != null) {
                            String[] specific_parts = searched_line.split(" ");

                            if (specific_parts.length >= 5) {
                                String search_emp_name = specific_parts[0];
                                String search_emp_id = specific_parts[1];
                                String search_emp_epf = specific_parts[2];
                                String search_designation = specific_parts[3];
                                String search_department = specific_parts[4];
                                table_model.addRow(new Object[]{search_emp_name + " " + search_emp_id + " " + search_emp_epf + " " + search_designation + " " + search_department});
                            }
                        }
                    }
                }else if(search_name.equals(EPF)){
                    try (BufferedWriter search_results_file_write = new BufferedWriter(new FileWriter("D:\\Java Projects\\Automated HR System\\src\\search_results.txt"))) {
                        search_results_file_write.write(read_line);
                        search_results_file_write.newLine();
                    }

                    try (BufferedReader search_file_read = new BufferedReader(new FileReader("D:\\Java Projects\\Automated HR System\\src\\search_results.txt"))) {
                        String searched_line;

                        while ((searched_line = search_file_read.readLine()) != null) {
                            String[] specific_parts = searched_line.split(" ");

                            if (specific_parts.length >= 5) {
                                String search_emp_name = specific_parts[0];
                                String search_emp_id = specific_parts[1];
                                String search_emp_epf = specific_parts[2];
                                String search_designation = specific_parts[3];
                                String search_department = specific_parts[4];
                                table_model.addRow(new Object[]{search_emp_name + " " + search_emp_id + " " + search_emp_epf + " " + search_designation + " " + search_department});
                            }
                        }
                    }
                }else if(search_name.equals(designation)){
                    try (BufferedWriter search_results_file_write = new BufferedWriter(new FileWriter("D:\\Java Projects\\Automated HR System\\src\\search_results.txt"))) {
                        search_results_file_write.write(read_line);
                        search_results_file_write.newLine();
                    }

                    try (BufferedReader search_file_read = new BufferedReader(new FileReader("D:\\Java Projects\\Automated HR System\\src\\search_results.txt"))) {
                        String searched_line;

                        while ((searched_line = search_file_read.readLine()) != null) {
                            String[] specific_parts = searched_line.split(" ");

                            if (specific_parts.length >= 5) {
                                String search_emp_name = specific_parts[0];
                                String search_emp_id = specific_parts[1];
                                String search_emp_epf = specific_parts[2];
                                String search_designation = specific_parts[3];
                                String search_department = specific_parts[4];
                                table_model.addRow(new Object[]{search_emp_name + " " + search_emp_id + " " + search_emp_epf + " " + search_designation + " " + search_department});
                            }
                        }
                    }
                }else if(search_name.equals(department)){
                    try (BufferedWriter search_results_file_write = new BufferedWriter(new FileWriter("D:\\Java Projects\\Automated HR System\\src\\search_results.txt"))) {
                        search_results_file_write.write(read_line);
                        search_results_file_write.newLine();
                    }

                    try (BufferedReader search_file_read = new BufferedReader(new FileReader("D:\\Java Projects\\Automated HR System\\src\\search_results.txt"))) {
                        String searched_line;

                        while ((searched_line = search_file_read.readLine()) != null) {
                            String[] specific_parts = searched_line.split(" ");

                            if (specific_parts.length >= 5) {
                                String search_emp_name = specific_parts[0];
                                String search_emp_id = specific_parts[1];
                                String search_emp_epf = specific_parts[2];
                                String search_designation = specific_parts[3];
                                String search_department = specific_parts[4];
                                table_model.addRow(new Object[]{search_emp_name + " " + search_emp_id + " " + search_emp_epf + " " + search_designation + " " + search_department});
                            }
                        }
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "Employee Not Found", "Error", JOptionPane.ERROR_MESSAGE);
                }




            } else {
                System.out.println("The Data was not found");

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }

    @Override

    public boolean Login() {

        System.out.println("Hr Assistant Login..");
        String username = null;


        try {

            BufferedReader manager_accounts_read = new BufferedReader(new FileReader("D:\\Java Projects\\Automated HR System\\src\\assistant_account_details.txt"));

            String read_line_data_1;


            while ((read_line_data_1 = manager_accounts_read.readLine()) != null) {


                if (read_line_data_1.contains(assistant_username)) {
                    username = read_line_data_1;
                    break;
                }
            }


            if (username != null) {
                System.out.println("The Username Was Found");

                System.out.println(username);

            }
            // need to implement the exact login
            else {
                System.out.println("Username and Password is NotFound..");
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        String[] specific_parts = username.split(" ");

        String hrass_username = specific_parts[1];
        String hrass_password = specific_parts[2];


        if (hrass_username.equals(assistant_username) && hrass_password.equals(assistant_password)){

            return true;

        }
        else{
            return false;
        }




    }
}



