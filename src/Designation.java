import javax.swing.table.DefaultTableModel;
import java.io.*;

public class Designation {

     String designation_name;

     String designation_id;



    public void showDesignationsDetails(DefaultTableModel table_model){


        try{
            BufferedReader designation_file_read = new BufferedReader(new FileReader("D:\\Java Projects\\Automated HR System\\src\\designation_details.txt"));


            String read_line;

            while((read_line = designation_file_read.readLine()) != null){

                String[] read_specific_line = read_line.split(" ");

                if(read_specific_line.length >= 2){
                    String readed_desig_name = read_specific_line[0];
                    String readed_desig_id = read_specific_line[1];

                    table_model.addRow(new Object[]{readed_desig_name, readed_desig_id});
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }






}
