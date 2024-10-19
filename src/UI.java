import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;



public class UI {

    private static JFrame manager;
    //private static JFrame assistant_frame;

    public static void ManagerLoginUI(){
        System.out.println("Login UI");






        //in this add employee panel need to create table and add employees
        JFrame login = new JFrame();

        JLabel main_label = new JLabel("HR Manager Portal");

        main_label.setBounds(210, 80, 300, 40);
        main_label.setFont(new Font("Poppins", Font.BOLD, 18));



        JLabel username_label = new JLabel("Username");
        username_label.setBounds(195, 180, 300, 40);
        username_label.setFont(new Font("Poppins", Font.PLAIN, 12));

        JTextField text_input_1 = new JTextField();
        text_input_1.setBounds(195, 210, 200, 20);



        JLabel password_label = new JLabel("Password");
        password_label.setBounds(195, 250, 300, 40);
        password_label.setFont(new Font("Poppins", Font.PLAIN, 12));


        JTextField text_input_2 = new JTextField();
        text_input_2.setBounds(195, 280, 200, 20);





        JButton login_btn = new JButton("Login");

        login_btn.setBounds(215, 350, 150, 30);
        login_btn.setFont(new Font("Poppins", Font.PLAIN, 11));

        login_btn.addActionListener(e -> {



            HRManager hrManager = new HRManager();

            hrManager.manager_username = text_input_1.getText();
            hrManager.setPassword(text_input_2.getText());

            if(hrManager.Login()){

                JOptionPane.showMessageDialog(null, "Login Success", "Success", JOptionPane.INFORMATION_MESSAGE);
                HR_Manager_UI();

                login.setVisible(false);


            }else if(text_input_1.getText().isEmpty() && text_input_2.getText().isEmpty()){
                System.out.println("Login Failed");

                JOptionPane.showMessageDialog(null, "Please Fill Username and Password", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });


        JLabel note = new JLabel("Please use Admin Created Account Credentials");
        note.setBounds(160, 380, 300, 40);
        note.setFont(new Font("Poppins", Font.PLAIN, 11));

        login.add(main_label);
        login.add(login_btn);
        login.add(username_label);
        login.add(password_label);
        login.add(text_input_1);
        login.add(text_input_2);
        login.add(note);


        login.setSize(600, 600);
        login.setLayout(null);
        login.setResizable(false);
        login.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        login.setVisible(true);



    }

    public static void main(String[] args){

        //executing Main UI Method
        MainUI();


    }


    public static void MainUI(){
        JFrame frame = new JFrame();


        frame.setTitle("HR Automated System");

        JLabel main_label = new JLabel("Automated HR System");
        main_label.setBounds(180, 30, 300, 40);
        main_label.setFont(new Font("Poppins", Font.BOLD, 18));


        JLabel sub_label = new JLabel("Please Select a Mode");
        sub_label.setBounds(120, 80, 300, 80);
        sub_label.setFont(new Font("Poppins", Font.PLAIN, 12));



        JButton admin_btn = new JButton("Admin Mode");
        admin_btn.setBounds(208, 180, 150, 30);
        admin_btn.setFont(new Font("Poppins", Font.PLAIN, 11));
        admin_btn.addActionListener(e -> {
            Admin_LoginUI();

            frame.setVisible(false);
        });


        JButton manager_btn = new JButton("Manager Mode");

        manager_btn.setBounds(208, 230, 150, 30);
        manager_btn.addActionListener(e -> {
            ManagerLoginUI();

            frame.setVisible(false);
        });
        manager_btn.setFont(new Font("Poppins", Font.PLAIN, 11));


        JButton assistant_btn = new JButton("Assistant Mode");
        assistant_btn.setBounds(208, 280, 150, 30);
        assistant_btn.setFont(new Font("Poppins", Font.PLAIN, 11));

        assistant_btn.addActionListener(e -> {
            HR_Assistant_LoginUI();

            frame.setVisible(false);
        });




        frame.add(main_label);
        frame.add(sub_label);

        frame.add(admin_btn);
        frame.add(manager_btn);
        frame.add(assistant_btn);

        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
    }






    // use panel for replace the same screen with different tabs

    public static void HR_Manager_UI(){





        System.out.println("Hr Manager UI");


        manager = new JFrame();

        manager.setTitle("HR Manager Mode");
        manager.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        manager.setSize(800, 700);

        JTabbedPane tabbedPane = new JTabbedPane();


        JPanel addEmployeePanel = createManagerPanel("Employees");
        JPanel addDepartmentPanel = createManagerPanel("Departments");
        JPanel addDesignationsPanel = createManagerPanel("Designations");
        JPanel SearchPanel = createManagerPanel("Search");




        JButton add_employees_btn = new JButton("Create Employee");
        add_employees_btn.addActionListener(e -> {
            System.out.println("Creating Employee...");

            HR_Manager_Employee_Input_UI("Employee");




            //HRManager hrManager = new HRManager();

            //hrManager.addEmployees();

            //HRAssistant hrAssistant = new HRAssistant();

            //hrAssistant.addEmployees();



        });

        JButton search_employees_btn = new JButton("Add Department");
        search_employees_btn.addActionListener(e -> {
            System.out.println("Adding Departments");

            HR_Manager_Department_Input_UI("Department");
        });


        JButton add_designations_btn = new JButton("Add Designations");
        add_designations_btn.addActionListener(e -> {
            System.out.println("Adding Designations");


            HR_Manager_Designations_Input_UI("Designation");
        });

        JButton search_btn = new JButton("Search Employees");
        search_btn.addActionListener(e -> {
            System.out.println("Adding Designations");


            HR_Manager_Search_Input_UI("Search");
        });



        addEmployeePanel.add(createManagerTable("Employee", new String[]{"Employee Name", "Employee ID", "EPF", "Designation", "Department"}), BorderLayout.CENTER);
        addEmployeePanel.add(add_employees_btn, BorderLayout.SOUTH);

        addDepartmentPanel.add(createManagerTable("Department", new String[]{"Department Name", "Department ID"}), BorderLayout.CENTER);
        addDepartmentPanel.add(search_employees_btn, BorderLayout.SOUTH);

        addDesignationsPanel.add(createManagerTable("Designation", new String[]{"Designation Name", "Designation ID"}), BorderLayout.CENTER);
        addDesignationsPanel.add(add_designations_btn, BorderLayout.SOUTH);


        SearchPanel.add(createManagerTable("Search", new String[]{"Search Results"}), BorderLayout.CENTER);
        SearchPanel.add(search_btn, BorderLayout.SOUTH);


        tabbedPane.addTab("Add Employee", addEmployeePanel);
        tabbedPane.addTab("Add Departments", addDepartmentPanel);
        tabbedPane.addTab("Add Designation", addDesignationsPanel);
        tabbedPane.addTab("Search Employees", SearchPanel);


        manager.add(tabbedPane);





        manager.setResizable(false);
        manager.setVisible(true);

    }

    private static JPanel createManagerPanel(String tabName) {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel("This is the " + tabName + " Tab");
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.add(label, BorderLayout.NORTH);
        return panel;


    }

    private static Map<String, JTable> tables_manager = new HashMap<>();

    private static JScrollPane createManagerTable(String tableName, String[] columnNames) {


        DefaultTableModel model = new DefaultTableModel(null, columnNames);




        if (tableName.equals("Employee")) {
            Employee employee = new Employee(null, null, null, null, null);
            employee.showEmployeeDetails(model);
        } else if(tableName.equals("Designation")){
            Designation designation = new Designation();
            designation.showDesignationsDetails(model);
        } else if(tableName.equals("Department")){
            Department department = new Department();
            department.showDepartmentDetails(model);
        }

        JTable table = new JTable(model);
        tables_manager.put(tableName, table);

        return new JScrollPane(table);
    }


    public static void HR_Manager_Employee_Input_UI(String tableName){

        JFrame manager_input_frame_1 = new JFrame("Create Employee");
        manager_input_frame_1.setSize(400, 500);

        JLabel name_label = new JLabel("Name");
        name_label.setBounds(140, 30, 100, 40);

        JTextField name_Field = new JTextField(20);
        name_Field.setBounds(120, 60, 150, 20);

        JLabel id_label = new JLabel("ID");
        id_label.setBounds(140, 90, 100, 40);

        JTextField id_Field = new JTextField(20);
        id_Field.setBounds(120, 120, 150, 20);


        JLabel designation_label = new JLabel("Designation");
        designation_label.setBounds(140, 150, 100, 40);

        JTextField designation_Field = new JTextField(20);
        designation_Field.setBounds(120, 180, 150, 20);

        JLabel EPF_label = new JLabel("EPF");
        EPF_label.setBounds(140, 210, 100, 40);

        JTextField EPF_Field = new JTextField(20);
        EPF_Field.setBounds(120, 240, 150, 20);

        JLabel department_label = new JLabel("Department");
        department_label.setBounds(140, 270, 100, 40);

        JTextField department_Field = new JTextField(20);
        department_Field.setBounds(120, 300, 150, 20);


        JButton create_btn = new JButton("Create");
        create_btn.setBounds(140, 350, 100, 30);

        create_btn.addActionListener(e -> {
            DefaultTableModel model = (DefaultTableModel) tables_manager.get(tableName).getModel();
            model.addRow(new Object[]{name_Field.getText(), id_Field.getText(), EPF_Field.getText(), designation_Field.getText(), department_Field.getText()});

            HRManager hrManager = new HRManager();
            hrManager.addEmployees(name_Field.getText(), id_Field.getText(), EPF_Field.getText(), designation_Field.getText(), department_Field.getText());
            manager_input_frame_1.dispose();
        });

        manager_input_frame_1.add(name_label);
        manager_input_frame_1.add(name_Field);

        manager_input_frame_1.add(id_label);
        manager_input_frame_1.add(id_Field);

        manager_input_frame_1.add(designation_label);
        manager_input_frame_1.add(designation_Field);

        manager_input_frame_1.add(EPF_label);
        manager_input_frame_1.add(EPF_Field);

        manager_input_frame_1.add(department_label);
        manager_input_frame_1.add(department_Field);

        manager_input_frame_1.add(create_btn);


        manager_input_frame_1.setLayout(null);
        manager_input_frame_1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        manager_input_frame_1.setVisible(true);
        manager_input_frame_1.setResizable(false);

    }


    public static void HR_Manager_Department_Input_UI(String tableName){

        JFrame manager_input_frame_1 = new JFrame("Create Department");
        manager_input_frame_1.setSize(400, 300);

        JLabel name_label = new JLabel("Name (ex - IT, Marketing)");
        name_label.setBounds(140, 30, 100, 40);

        JTextField name_Field = new JTextField(20);
        name_Field.setBounds(120, 60, 150, 20);

        JLabel id_label = new JLabel("ID");
        id_label.setBounds(140, 90, 100, 40);

        JTextField id_Field = new JTextField(20);
        id_Field.setBounds(120, 120, 150, 20);


        JButton create_btn = new JButton("Create");
        create_btn.setBounds(140, 160, 100, 30);

        create_btn.addActionListener(e -> {

            HRManager hrManager = new HRManager();
            hrManager.addDepartments(name_Field.getText(), id_Field.getText());
            DefaultTableModel model = (DefaultTableModel) tables_manager.get(tableName).getModel();
            model.addRow(new Object[]{name_Field.getText(), id_Field.getText()});
            manager_input_frame_1.dispose();
        });

        manager_input_frame_1.add(name_label);
        manager_input_frame_1.add(name_Field);

        manager_input_frame_1.add(id_label);
        manager_input_frame_1.add(id_Field);

        manager_input_frame_1.add(create_btn);


        manager_input_frame_1.setLayout(null);
        manager_input_frame_1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        manager_input_frame_1.setVisible(true);
        manager_input_frame_1.setResizable(false);

    }


    public static void HR_Manager_Designations_Input_UI(String tableName){

        JFrame manager_input_frame_1 = new JFrame("Create Designation");
        manager_input_frame_1.setSize(400, 300);

        JLabel name_label = new JLabel("Name (ex- IT_Manager, IT_Lecturer");
        name_label.setBounds(140, 30, 100, 40);

        JTextField name_Field = new JTextField(20);
        name_Field.setBounds(120, 60, 150, 20);

        JLabel id_label = new JLabel("ID");
        id_label.setBounds(140, 90, 100, 40);

        JTextField id_Field = new JTextField(20);
        id_Field.setBounds(120, 120, 150, 20);


        JButton create_btn = new JButton("Create");
        create_btn.setBounds(140, 160, 100, 30);

        create_btn.addActionListener(e -> {

            HRManager hrManager = new HRManager();
            hrManager.addDesignations(name_Field.getText(), id_Field.getText());
            DefaultTableModel model = (DefaultTableModel) tables_manager.get(tableName).getModel();
            model.addRow(new Object[]{name_Field.getText(), id_Field.getText()});
            manager_input_frame_1.dispose();
        });

        manager_input_frame_1.add(name_label);
        manager_input_frame_1.add(name_Field);

        manager_input_frame_1.add(id_label);
        manager_input_frame_1.add(id_Field);

        manager_input_frame_1.add(create_btn);


        manager_input_frame_1.setLayout(null);
        manager_input_frame_1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        manager_input_frame_1.setVisible(true);
        manager_input_frame_1.setResizable(false);

    }



    public static void HR_Manager_Search_Input_UI(String tableName) {

            JFrame manager_input_frame_1 = new JFrame("Employee Searching");
            manager_input_frame_1.setSize(400, 300);

            JLabel searchByLabel = new JLabel("Search By:");
            searchByLabel.setBounds(140, 30, 100, 40);

            String[] searchOptions = {"EPF", "Name", "Department", "Designation", "Employee ID"};
            JComboBox<String> searchComboBox = new JComboBox<>(searchOptions);
            searchComboBox.setBounds(120, 60, 150, 20);

            JTextField searchField = new JTextField(20);
            searchField.setBounds(120, 90, 150, 20);

            JButton searchButton = new JButton("Search");
            searchButton.setBounds(140, 130, 100, 30);

            searchButton.addActionListener(e -> {
                String selectedSearch = (String) searchComboBox.getSelectedItem();
                String searchText = searchField.getText();

                DefaultTableModel model = (DefaultTableModel) tables_manager.get(tableName).getModel();
                HRManager hrManager = new HRManager();
                // Pass selected search criteria and text to searchEmployees method
                hrManager.searchEmployees(model, selectedSearch, searchText);
                manager_input_frame_1.dispose();
            });

            manager_input_frame_1.add(searchByLabel);
            manager_input_frame_1.add(searchComboBox);
            manager_input_frame_1.add(searchField);
            manager_input_frame_1.add(searchButton);

            manager_input_frame_1.setLayout(null);
            manager_input_frame_1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            manager_input_frame_1.setVisible(true);
            manager_input_frame_1.setResizable(false);
    }












    public static void HR_Assistant_LoginUI(){
        System.out.println("HR Assistant Login UI");

        JFrame assistant_login_frame = new JFrame();

        assistant_login_frame.setTitle("HR Assistant Mode");

        JLabel main_label = new JLabel("HR Assistant Portal");

        main_label.setBounds(210, 80, 300, 40);
        main_label.setFont(new Font("Poppins", Font.BOLD, 18));


        JLabel username_label = new JLabel("Username");
        username_label.setBounds(195, 180, 300, 40);
        username_label.setFont(new Font("Poppins", Font.PLAIN, 12));

        JTextField text_input_1 = new JTextField();
        text_input_1.setBounds(195, 210, 200, 20);



        JLabel password_label = new JLabel("Password");
        password_label.setBounds(195, 250, 300, 40);
        password_label.setFont(new Font("Poppins", Font.PLAIN, 12));


        JTextField text_input_2 = new JTextField();
        text_input_2.setBounds(195, 280, 200, 20);





        JButton login_btn = new JButton("Login");

        login_btn.setBounds(215, 350, 150, 30);
        login_btn.setFont(new Font("Poppins", Font.PLAIN, 11));

        login_btn.addActionListener(e -> {


            HRAssistant hrAssistant = new HRAssistant();

            hrAssistant.assistant_username = text_input_1.getText();
            hrAssistant.assistant_password = text_input_2.getText();

            hrAssistant.Login();

            if(hrAssistant.Login()){

                JOptionPane.showMessageDialog(null, "Login Success", "Success", JOptionPane.INFORMATION_MESSAGE);
                HR_Assistant_UI();

                assistant_login_frame.setVisible(false);


            }else if(text_input_1.getText().isEmpty() && text_input_2.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Please Fill All Fields", "Error", JOptionPane.ERROR_MESSAGE);

                System.out.println("Login Failed");


            }


        });

        JLabel note = new JLabel("Please use Admin Created Account Credentials");
        note.setBounds(160, 380, 300, 40);
        note.setFont(new Font("Poppins", Font.PLAIN, 11));

        assistant_login_frame.add(main_label);
        assistant_login_frame.add(username_label);
        assistant_login_frame.add(text_input_1);

        assistant_login_frame.add(password_label);
        assistant_login_frame.add(text_input_2);

        assistant_login_frame.add(login_btn);
        assistant_login_frame.add(note);



        assistant_login_frame.setSize(600, 600);
        assistant_login_frame.setLayout(null);
        assistant_login_frame.setResizable(false);
        assistant_login_frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        assistant_login_frame.setVisible(true);
    }


    public static void HR_Assistant_UI(){


        System.out.println("HR Assistant UI");



        JFrame assistant_frame = new JFrame();
        assistant_frame.setTitle("HR Assistant Mode");
        assistant_frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        assistant_frame.setSize(800, 700);


        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel addEmployeePanel = createAssistantPanel("Employees");
        JPanel searchEmployeePanel = createAssistantPanel("Search");


        JButton add_employees_btn = new JButton("Create Employee");
        add_employees_btn.addActionListener(e -> {
            System.out.println("Creating Employee...");



            Asssitant_Employee_Input_UI("Employee");

        });

        JButton search_employees_btn = new JButton("Search Employee");
        search_employees_btn.addActionListener(e -> {
            System.out.println("Searching Employees");

            Asssitant_Search_Input_UI("Search");
        });



        addEmployeePanel.add(createAssistantTable("Employee", new String[]{"Employee Name", "Employee ID", "EPF", "Designation", "Department"}), BorderLayout.CENTER);
        addEmployeePanel.add(add_employees_btn, BorderLayout.SOUTH);

        searchEmployeePanel.add(createAssistantTable("Search", new String[]{"Search Result"}), BorderLayout.CENTER);
        searchEmployeePanel.add(search_employees_btn, BorderLayout.SOUTH);

        tabbedPane.addTab("Add Employee", addEmployeePanel);
        tabbedPane.addTab("Search Employee", searchEmployeePanel);


        assistant_frame.add(tabbedPane);


        assistant_frame.setResizable(false);
        assistant_frame.setVisible(true);




    }

    private static JPanel createAssistantPanel(String tabName) {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel("This is the " + tabName + " Tab");
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.add(label, BorderLayout.NORTH);
        return panel;

    }

    private static Map<String, JTable> tables_assistant = new HashMap<>();

    private static JScrollPane createAssistantTable(String tableName, String[] columnNames) {

        DefaultTableModel model = new DefaultTableModel(null, columnNames);

        if(tableName.equals("Employee")){
            Employee employee = new Employee(null, null, null, null, null);
            employee.showEmployeeDetails(model);
        }

        JTable table = new JTable(model);
        tables_assistant.put(tableName, table);

        return new JScrollPane(table);
    }

    public static void Asssitant_Employee_Input_UI(String tableName){

        JFrame assistant_input_frame_1 = new JFrame("Create Employee");
        assistant_input_frame_1.setSize(400, 500);

        JLabel name_label = new JLabel("Name");
        name_label.setBounds(140, 30, 100, 40);

        JTextField name_Field = new JTextField(20);
        name_Field.setBounds(120, 60, 150, 20);

        JLabel id_label = new JLabel("ID");
        id_label.setBounds(140, 90, 100, 40);

        JTextField id_Field = new JTextField(20);
        id_Field.setBounds(120, 120, 150, 20);


        JLabel designation_label = new JLabel("Designation");
        designation_label.setBounds(140, 150, 100, 40);

        JTextField designation_Field = new JTextField(20);
        designation_Field.setBounds(120, 180, 150, 20);

        JLabel EPF_label = new JLabel("EPF");
        EPF_label.setBounds(140, 210, 100, 40);

        JTextField EPF_Field = new JTextField(20);
        EPF_Field.setBounds(120, 240, 150, 20);

        JLabel department_label = new JLabel("Department");
        department_label.setBounds(140, 270, 100, 40);

        JTextField department_Field = new JTextField(20);
        department_Field.setBounds(120, 300, 150, 20);


        JButton create_btn = new JButton("Create");
        create_btn.setBounds(140, 350, 100, 30);

        create_btn.addActionListener(e -> {
            DefaultTableModel model = (DefaultTableModel) tables_manager.get(tableName).getModel();
            model.addRow(new Object[]{name_Field.getText(), id_Field.getText(), EPF_Field.getText(), designation_Field.getText(), department_Field.getText()});

            HRAssistant hrAssistant = new HRAssistant();
            hrAssistant.addEmployees(name_Field.getText(), id_Field.getText(), EPF_Field.getText(), designation_Field.getText(), department_Field.getText());
            assistant_input_frame_1.dispose();
        });

        assistant_input_frame_1.add(name_label);
        assistant_input_frame_1.add(name_Field);

        assistant_input_frame_1.add(id_label);
        assistant_input_frame_1.add(id_Field);

        assistant_input_frame_1.add(designation_label);
        assistant_input_frame_1.add(designation_Field);

        assistant_input_frame_1.add(EPF_label);
        assistant_input_frame_1.add(EPF_Field);

        assistant_input_frame_1.add(department_label);
        assistant_input_frame_1.add(department_Field);

        assistant_input_frame_1.add(create_btn);


        assistant_input_frame_1.setLayout(null);
        assistant_input_frame_1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        assistant_input_frame_1.setVisible(true);
        assistant_input_frame_1.setResizable(false);

    }


    public static void Asssitant_Search_Input_UI(String tableName){

        JFrame assistant_input_frame_1 = new JFrame("Input Data");
        assistant_input_frame_1.setSize(400, 300);

        JLabel searchByLabel = new JLabel("Search By:");
        searchByLabel.setBounds(140, 30, 100, 40);

        String[] searchOptions = {"Name", "Employee ID", "EPF", "Department", "Designation"};
        JComboBox<String> searchComboBox = new JComboBox<>(searchOptions);
        searchComboBox.setBounds(120, 60, 150, 20);

        JTextField searchField = new JTextField(20);
        searchField.setBounds(120, 90, 150, 20);

        JButton searchButton = new JButton("Search");
        searchButton.setBounds(140, 130, 100, 30);

        searchButton.addActionListener(e -> {
            String selectedSearch = (String) searchComboBox.getSelectedItem();
            String searchText = searchField.getText();

            DefaultTableModel model = (DefaultTableModel) tables_assistant.get(tableName).getModel();
            HRAssistant hrAssistant = new HRAssistant();
            hrAssistant.searchEmployees(model, selectedSearch, searchText);
            assistant_input_frame_1.dispose();
        });

        assistant_input_frame_1.add(searchByLabel);
        assistant_input_frame_1.add(searchComboBox);
        assistant_input_frame_1.add(searchField);
        assistant_input_frame_1.add(searchButton);

        assistant_input_frame_1.setLayout(null);
        assistant_input_frame_1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        assistant_input_frame_1.setVisible(true);
        assistant_input_frame_1.setResizable(false);



    }






    public static void Admin_LoginUI(){

        System.out.println("Admin Login UI");


        JFrame admin_frame = new JFrame();

        admin_frame.setTitle("Admin Login");



        JLabel main_label = new JLabel("HR Admin Portal");

        main_label.setBounds(210, 80, 300, 40);
        main_label.setFont(new Font("Poppins", Font.BOLD, 18));


        JLabel username_label = new JLabel("Username");
        username_label.setBounds(195, 180, 300, 40);
        username_label.setFont(new Font("Poppins", Font.PLAIN, 12));

        JTextField text_input_1 = new JTextField();
        text_input_1.setBounds(195, 210, 200, 20);



        JLabel password_label = new JLabel("Password");
        password_label.setBounds(195, 250, 300, 40);
        password_label.setFont(new Font("Poppins", Font.PLAIN, 12));


        JTextField text_input_2 = new JTextField();
        text_input_2.setBounds(195, 280, 200, 20);





        JButton login_btn = new JButton("Login");

        login_btn.setBounds(215, 350, 150, 30);
        login_btn.setFont(new Font("Poppins", Font.PLAIN, 11));

        login_btn.addActionListener(e -> {
            //Admin_UI();

            Admin admin = new Admin();

            admin.admin_username = text_input_1.getText();
            admin.admin_password = text_input_2.getText();

            admin.Login();

            if(admin.Login()){
                System.out.println("Login Success");
                JOptionPane.showMessageDialog(null, "Login Success", "Success", JOptionPane.INFORMATION_MESSAGE);
                Admin_UI();

                admin_frame.setVisible(false);


            }else{
                System.out.println("Login Failed");
            }




           //admin_frame.setVisible(false);
        });





        admin_frame.add(main_label);
        admin_frame.add(username_label);
        admin_frame.add(text_input_1);

        admin_frame.add(password_label);
        admin_frame.add(text_input_2);


        admin_frame.add(login_btn);


        admin_frame.setSize(600, 600);
        admin_frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        admin_frame.setLayout(null);
        admin_frame.setResizable(false);
        admin_frame.setVisible(true);


    }


    public static void Admin_UI() {

        System.out.println("Admin UI");

        JFrame admin_main_frame = new JFrame();

        admin_main_frame.setTitle("Admin Portal");

        admin_main_frame.setSize(800, 700);

        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel managerAccountPanel = createAdminPanel("Managers");
        JPanel assistantAccountPanel = createAdminPanel("Assistants");


        JButton manager_account_create_btn = new JButton("Create Manager Account");
        manager_account_create_btn.addActionListener(e -> {
            System.out.println("Creating HR Manager Account...");

            //table reference
            Admin_Input_UI_1("Manager");


        });

        JButton assistant_account_create_btn = new JButton("Create Assistant Account");
        assistant_account_create_btn.addActionListener(e -> {
            System.out.println("Creating HR Assistant Account...");

            Admin_Input_UI_2("Assistant");
        });

        managerAccountPanel.add(createAdminTable("Manager", new String[]{"Manager Name",  "Manager Username", "Manager Password"}), BorderLayout.CENTER);
        managerAccountPanel.add(manager_account_create_btn, BorderLayout.SOUTH);

        assistantAccountPanel.add(createAdminTable("Assistant", new String[]{"Assistant Name", "Assistant Username", "Assistant Password"}), BorderLayout.CENTER);
        assistantAccountPanel.add(assistant_account_create_btn, BorderLayout.SOUTH);



        tabbedPane.addTab("Managers", managerAccountPanel);
        tabbedPane.addTab("Assistants", assistantAccountPanel);


        admin_main_frame.add(tabbedPane);

        admin_main_frame.setResizable(false);
        admin_main_frame.setVisible(true);
    }

    private static JPanel createAdminPanel(String tabName) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        JLabel label = new JLabel("This is the " + tabName + " Tab");
        panel.add(label, BorderLayout.NORTH);


        return panel;
    }

    private static Map<String, JTable> tables_admin = new HashMap<>();

    private static JScrollPane createAdminTable(String tableName, String[] columnNames) {

        DefaultTableModel model = new DefaultTableModel(null, columnNames);

        if(tableName.equals("Assistant")){
            Admin admin = new Admin();
            admin.showAssistantAccounts(model);
        }else if(tableName.equals("Manager")){
            Admin admin = new Admin();
            admin.showManagersAccounts(model);
        }


        JTable table = new JTable(model);


        tables_admin.put(tableName, table);
        return new JScrollPane(table);
    }






    public static void Admin_Input_UI_1(String tableName){

        System.out.println("Admin Employee Input Fields UI");


        JFrame input_Frame = new JFrame("Create Manager Account");
        input_Frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        input_Frame.setSize(400, 400);

        JLabel name_label = new JLabel("Name");
        name_label.setBounds(140, 30, 100, 40);

        JTextField name_Field = new JTextField(20);
        name_Field.setBounds(120, 60, 150, 20);

        JLabel id_label = new JLabel("ID");
        id_label.setBounds(140, 90, 100, 40);

        JTextField id_Field = new JTextField(20);
        id_Field.setBounds(120, 120, 150, 20);

        JLabel username_label = new JLabel("Username");
        username_label.setBounds(140, 150, 100, 40);

        JTextField username_field = new JTextField(20);
        username_field.setBounds(120, 180,150, 20);

        JLabel password_label = new JLabel("Password");
        password_label.setBounds(140, 210, 100, 40);

        JTextField password_field = new JTextField(20);
        password_field.setBounds(120, 240, 150, 20);




        JButton add_Button = new JButton("Create");
        add_Button.setBounds(140, 270, 100, 30);

        add_Button.addActionListener(e -> {
            DefaultTableModel model = (DefaultTableModel) tables_admin.get(tableName).getModel();
            model.addRow(new Object[]{name_Field.getText(), id_Field.getText(), username_field.getText(), password_field.getText()});
            Admin admin = new Admin();
            admin.createManagerAccount(name_Field.getText(), username_field.getText(), password_field.getText());
            input_Frame.dispose();


        });


        input_Frame.add(name_label);
        input_Frame.add(name_Field);

        input_Frame.add(id_label);
        input_Frame.add(id_Field);

        input_Frame.add(username_label);
        input_Frame.add(username_field);

        input_Frame.add(password_label);
        input_Frame.add(password_field);

        input_Frame.add(add_Button);




        input_Frame.setLayout(null);
        input_Frame.setVisible(true);


    }


    public static void Admin_Input_UI_2(String tableName){

        System.out.println("Admin Create Assistant Account");


        JFrame admin_input_frame_2 = new JFrame();


        admin_input_frame_2.setTitle("Create Assistant Account");






        JLabel name_label = new JLabel("Name");
        name_label.setBounds(140, 30, 100, 40);

        JTextField name_Field = new JTextField(20);
        name_Field.setBounds(120, 60, 150, 20);

        JLabel id_label = new JLabel("ID");
        id_label.setBounds(140, 90, 100, 40);

        JTextField id_Field = new JTextField(20);
        id_Field.setBounds(120, 120, 150, 20);

        JLabel username_label = new JLabel("Username");
        username_label.setBounds(140, 150, 100, 40);

        JTextField username_field = new JTextField(20);
        username_field.setBounds(120, 180,150, 20);

        JLabel password_label = new JLabel("Password");
        password_label.setBounds(140, 210, 100, 40);

        JTextField password_field = new JTextField(20);
        password_field.setBounds(120, 240, 150, 20);




        JButton add_Button = new JButton("Create");
        add_Button.setBounds(140, 270, 100, 30);

        add_Button.addActionListener(e -> {



            DefaultTableModel model = (DefaultTableModel) tables_admin.get(tableName).getModel();
            Admin admin = new Admin();
            admin.createAssistantAccount(name_Field.getText(), username_field.getText(), password_field.getText());
            model.addRow(new Object[]{name_Field.getText(), username_field.getText(), password_field.getText()});
            admin_input_frame_2.dispose();


        });


        admin_input_frame_2.add(name_label);
        admin_input_frame_2.add(name_Field);

        admin_input_frame_2.add(id_label);
        admin_input_frame_2.add(id_Field);

        admin_input_frame_2.add(username_label);
        admin_input_frame_2.add(username_field);

        admin_input_frame_2.add(password_label);
        admin_input_frame_2.add(password_field);

        admin_input_frame_2.add(add_Button);












        admin_input_frame_2.setSize(400, 400);
        admin_input_frame_2.setResizable(false);
        admin_input_frame_2.setLayout(null);
        admin_input_frame_2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        admin_input_frame_2.setVisible(true);



    }




}
