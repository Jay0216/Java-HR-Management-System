import javax.swing.table.DefaultTableModel;
import java.io.*;

public class Admin extends User implements ManageUserLogins {

     private HRAssistant hrAssistant;
     private HRManager hrManager;

     String admin_username;

     String admin_password;

    //String admin_id;

    String fixed_username = "Jayn@3";

    String fixed_password = "12345";









     @Override
     public boolean Login(){




        if(admin_username.equals(null) && admin_password.equals(null)){

            return false;

        }else if(admin_username.equals(fixed_username) && admin_password.equals(fixed_password)){

            return true;
        }else{
            return false;
        }






    }


    public void createManagerAccount(String manager_name, String manager_username, String manager_password){

        System.out.println("Creating Manager Account");


        hrManager = new HRManager();

        hrManager.name = manager_name;
        hrManager.manager_username = manager_username;
        hrManager.setPassword(manager_password);

        saveManagerDetails(hrManager);


    }

    private void saveManagerDetails(HRManager hrManager){
        try{

            FileWriter manager_account_write = new FileWriter("D:\\Java Projects\\Automated HR System\\src\\manager_account_details.txt", true);
            manager_account_write.write(hrManager.name + " " + hrManager.manager_username + " " + hrManager.getPassword() + "\n");
            manager_account_write.close();
            System.out.println("Successfully Created Account");

        }catch(IOException e){
            System.out.println("Error");
            e.printStackTrace();
        }
    }


    public void showManagersAccounts(DefaultTableModel table_model){

        try{
            BufferedReader manager_account_file_read = new BufferedReader(new FileReader("D:\\Java Projects\\Automated HR System\\src\\manager_account_details.txt"));


            String read_line;

            while ((read_line = manager_account_file_read.readLine()) != null) {

                String[] read_specific_line = read_line.split(" ");

                if (read_specific_line.length >= 3) {
                    String readed_name = read_specific_line[0];
                    String readed_username = read_specific_line[1];
                    String readed_password = read_specific_line[2];

                    table_model.addRow(new Object[]{readed_name, readed_username, readed_password});
                }
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }






    public void createAssistantAccount(String assistant_name, String assistant_username, String assistant_password) {

        System.out.println("Creating Assistant Account");


        hrAssistant = new HRAssistant();

        hrAssistant.assistant_name = assistant_name;
        hrAssistant.assistant_username = assistant_username;
        hrAssistant.assistant_password = assistant_password;


        saveAssistantAccounts(hrAssistant);





     }


     private void saveAssistantAccounts(HRAssistant hrAssistant){

            try {

                FileWriter assistant_account_write = new FileWriter("D:\\Java Projects\\Automated HR System\\src\\assistant_account_details.txt", true);
                assistant_account_write.write(hrAssistant.assistant_name + " " + hrAssistant.assistant_username + " " + hrAssistant.assistant_password + "\n");
                assistant_account_write.close();
                System.out.println("Successfully Created Account");





            } catch (IOException e) {
                System.out.println("Error");
                e.printStackTrace();
            }
     }

        public void showAssistantAccounts(DefaultTableModel table_model){

           try{
               BufferedReader assistant_account_file_read = new BufferedReader(new FileReader("D:\\Java Projects\\Automated HR System\\src\\assistant_account_details.txt"));


               String read_line;

               while ((read_line = assistant_account_file_read.readLine()) != null) {

                   String[] read_specific_line = read_line.split(" ");

                   if (read_specific_line.length >= 3) {
                       String readed_name = read_specific_line[0];
                       String readed_username = read_specific_line[1];
                       String readed_password = read_specific_line[2];

                       table_model.addRow(new Object[]{readed_name, readed_username, readed_password});
                   }
               }

           }catch (IOException e){
               e.printStackTrace();
           }
        }





}
