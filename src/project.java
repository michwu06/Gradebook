/* Michelle Wu
 * Semester Project
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
 
public class project extends JFrame implements ActionListener {
	//setting up texts, buttons, etc. for layout
   static JTextField text1, text2, text3, text4, text5, text6, text7, text9, text10, text11;
   static CardLayout contentPaneLayout;
   static JButton createClass, loadStu, addStu, enterScore, sortStu, viewDelete, backup, exit;
   static JButton create, cancel, load, cancel2, saveAdd, topMenu, topMenu2, sort, topMenu3, delete, topMenu4;
   static Container contentPane; static String className; static int size = 0; static Student [] array = new Student[100];
   static JComboBox GList, AList; static JScrollPane scrollPane; JTable table; static int getName = 0;
   static JRadioButton first, second;
   
   public static void main (String [] args) {
	   //creating layouts
	   
	   //main menu
      ActionListener AL = new project();
      JFrame frame = new JFrame("CSC Gradebook"); //header
      contentPane = frame.getContentPane();
	  //main menu layout
      contentPane.setLayout(contentPaneLayout = new CardLayout());
      JPanel menu1 = new JPanel(new BorderLayout());
	  //title of main menu
      menu1.add(new JLabel("<html><font size=5><b>Use The Buttons below To Manage Students</b></html>", JLabel.CENTER), BorderLayout.NORTH);
      
	  // creating style of mid section
      JPanel panel2 = new JPanel(new FlowLayout());
	  //text box label
      panel2.add(new JLabel("Class Name:"));
	  //create text box and size
      text1 = new JTextField("", 15);
	  //add it to section
      panel2.add(text1);
      panel2.add(new JLabel("Number of students:"));
      text2 = new JTextField("0", 15);
      panel2.add(text2);
	  
	  //create new section and style
      JPanel panel = new JPanel();
      panel.setLayout(new GridLayout(2, 4, 2, 2));
	  //buttons and link
      panel.add(createClass = new JButton("0. Create a New Class")); createClass.addActionListener(AL);
      panel.add(loadStu = new JButton("1. Load Students From a File")); loadStu.addActionListener(AL);
      panel.add(addStu = new JButton("2. Add New Students")); addStu.addActionListener(AL);
      panel.add(enterScore = new JButton("3. Enter Lab Scores")); enterScore.addActionListener(AL);
      panel.add(sortStu = new JButton("4. Sort Students")); sortStu.addActionListener(AL);// optional
      panel.add(viewDelete = new JButton("5. View/Delete Students")); viewDelete.addActionListener(AL);
      panel.add(backup = new JButton("6. BackupStudents To a File")); backup.addActionListener(AL);
      panel.add(exit = new JButton("7. Exit")); exit.addActionListener(AL);
      
	  //customizing format for main menu
      menu1.add(panel2, BorderLayout.CENTER);
      menu1.add(panel, BorderLayout.SOUTH);
      contentPane.add("Menu 1", menu1);
      
	  // create New class menu 
      JPanel menu2 = new JPanel(new GridLayout(0, 1, 2, 2));
	  //title of new class menu and style of page
      menu2.add(new JLabel("<html><font size=5><b>Create a New Class</b></html>", JLabel.CENTER), BorderLayout.NORTH);
      // mid section style
	  JPanel panel3 = new JPanel(new FlowLayout());
	  //text box label
      panel3.add(new JLabel("Class Name:"));
	  //create text box and size
      text3 = new JTextField("", 20);
	  //add it to mid section
      panel3.add(text3);
	  //connect section
      menu2.add(panel3);
      
	  //buttons for new class menu or bottom section
      JPanel panel4 = new JPanel(new FlowLayout());
      panel4.add(create = new JButton("Create")); create.addActionListener(AL);
      panel4.add(cancel = new JButton("Cancel")); cancel.addActionListener(AL);
      //connect section
	  menu2.add(panel4);
      contentPane.add("Menu 2", menu2);
      
	  //load file menu
	  //format menu style
      JPanel menu3 = new JPanel(new GridLayout(0, 1, 2, 2));
	  //title of menu
      menu3.add(new JLabel("<html><font size=5><b>Load Students From a File</b></html>", JLabel.CENTER), BorderLayout.NORTH);
      //mid section style of load file menu
	  JPanel panel5 = new JPanel(new FlowLayout());
      panel5.add(new JLabel("Class Name:"));
      text4 = new JTextField("", 20);
      panel5.add(text4);
	  //connect sections
      menu3.add(panel5);
      
	  //bottom section of load file menu
      JPanel panel6 = new JPanel(new FlowLayout());
	  //create buttons and link actions
      panel6.add(load = new JButton("Load")); load.addActionListener(AL);
      panel6.add(cancel2 = new JButton("Cancel")); cancel2.addActionListener(AL);
      //connect sections
	  menu3.add(panel6);
	  //put together as whole
      contentPane.add("Menu 3", menu3);
      
	  // create new menu: student info
      JPanel menu4 = new JPanel(new BorderLayout());
      menu4.add(new JLabel("<html><font size=5><b>Enter Student Information</b></html>", JLabel.CENTER), BorderLayout.NORTH);
      //text box layout or mid section
	  JPanel panel7 = new JPanel(new GridLayout(5, 2, 2, 2)); 
      panel7.add(new JLabel("SSN:", JLabel.RIGHT));
      text5 = new JTextField("", 20);
      panel7.add(text5);
      panel7.add(new JLabel("Name:", JLabel.RIGHT));
      text6 = new JTextField("", 20);
      panel7.add(text6);
      panel7.add(new JLabel("Gender:", JLabel.RIGHT));
      // create list box
	  String genders[] = {"Male", "Female"};
      GList = new JComboBox(genders);
	  //add it to section
      panel7.add(GList);
      panel7.add(new JLabel("Age:", JLabel.RIGHT));
      text7 = new JTextField("", 20);
      panel7.add(text7);
      panel7.add(new JLabel("Academic Level:", JLabel.RIGHT));
      String level[] = {"Freshman", "Sophomore", "Junior", "Senior", "Graduate"};
      AList = new JComboBox(level);
      panel7.add(AList);
      menu4.add(panel7, BorderLayout.CENTER);
      
	  //bottom section of student info
      JPanel panel8 = new JPanel(new FlowLayout());
      panel8.add(saveAdd = new JButton("Save & Add Student")); saveAdd.addActionListener(AL);
      panel8.add(topMenu = new JButton("Back to Top Menu")); topMenu.addActionListener(AL);
      menu4.add(panel8, BorderLayout.SOUTH); 
      contentPane.add("Menu 4", menu4);
      
	  //create score menu
      JPanel menu5 = new JPanel(new GridLayout(0,1));
      menu5.add(new JLabel("<html><font size=5><b>Enter Lab Scores</b></html>", JLabel.CENTER));
	  // style each part separately
      JPanel panel9 = new JPanel(new FlowLayout()); // lab #
      JPanel panel15 = new JPanel(new FlowLayout()); //student name
      JPanel panel16 = new JPanel(new FlowLayout()); //score
      panel9.add(new JLabel("Lab Number : ", JLabel.RIGHT));
      text9 = new JTextField("", 3); //lab # text
      panel9.add(text9);
      menu5.add(panel9);
      panel16.add(new JLabel("Student Name: ", JLabel.RIGHT));
      text11 = new JTextField("", 10); text11.addActionListener(AL); //student name text
      panel16.add(text11);
      menu5.add(panel16);
      panel15.add(new JLabel("Score for : ", JLabel.RIGHT));
      text10 = new JTextField("", 5); text10.addActionListener(AL); //score text
      panel15.add(text10);
      menu5.add(panel15);
      
	  //return button of score menu
      JPanel panel10 = new JPanel(new FlowLayout());
      panel10.add(topMenu2 = new JButton("Back to Top Menu")); topMenu2.addActionListener(AL);
      menu5.add(panel10);
      contentPane.add("Menu 5", menu5);
      
	  //sort menu
      JPanel menu6 = new JPanel(new BorderLayout());
      menu6.add(new JLabel("<html><font size=5><b>Sort Students</b></html>", JLabel.CENTER), BorderLayout.NORTH);
      JPanel panel11 = new JPanel(new FlowLayout());
	  // create bubble buttons
      first = new JRadioButton("By ID");
      second = new JRadioButton("By Name");
	  // create and add into button group
      ButtonGroup group = new ButtonGroup();
      group.add(first); group.add(second);
	  //add button group to section
      panel11.add(first); panel11.add(second);
	  //add to menu frame
      menu6.add(panel11);
      
	  //bottom section of sort menu is buttons
      JPanel panel12 = new JPanel(new FlowLayout());
      panel12.add(sort = new JButton("Sort")); sort.addActionListener(AL);
      panel12.add(topMenu3 = new JButton("Top Menu")); topMenu3.addActionListener(AL);
      menu6.add(panel12, BorderLayout.SOUTH);
      contentPane.add("Menu 6", menu6);
      
	  // view student list menu
      JPanel menu7 = new JPanel(new BorderLayout());
      menu7.add(new JLabel("<html><font size=5><b>Student List</b></html>", JLabel.CENTER), BorderLayout.NORTH);
      JPanel panel13 = new JPanel(new FlowLayout());
	  // add scroll
      scrollPane = new JScrollPane();
      panel13.add(scrollPane, BorderLayout.CENTER);
      menu7.add(panel13);
      
	  //delete button and return button
      JPanel panel14 = new JPanel(new FlowLayout());
      panel14.add(delete = new JButton("Delete Selected")); delete.addActionListener(AL);
      panel14.add(topMenu4 = new JButton("Top Menu")); topMenu4.addActionListener(AL);
      menu7.add(panel14, BorderLayout.SOUTH);
      contentPane.add("Menu 7", menu7);
      
	  //set up frame and size
      contentPaneLayout.show(contentPane, "Menu 1");
      frame.pack();
      frame.setSize(955, 300);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
      frame.setResizable(false);
   }
   
   //specific actions for buttons
   public void actionPerformed(ActionEvent e) {
	   // go to main menu buttons
      if (e.getSource() == topMenu || e.getSource() == topMenu2 || e.getSource() == topMenu3 || e.getSource() == topMenu4) {
         contentPaneLayout.show(contentPane, "Menu 1");
      }
      if (e.getSource() == cancel || e.getSource() == cancel2) {
         contentPaneLayout.show(contentPane, "Menu 1");
      }
	  // go to create class menu
      if (e.getSource() == createClass) {
         contentPaneLayout.show(contentPane, "Menu 2");
      }
	  // go to load file menu
      if (e.getSource() == loadStu) {
         contentPaneLayout.show(contentPane, "Menu 3");
      }
	  //go to student info menu
      if (e.getSource() == addStu) {
         contentPaneLayout.show(contentPane, "Menu 4");
      }
	  //go to score menu
      if (e.getSource() == enterScore) {
         contentPaneLayout.show(contentPane, "Menu 5");
      }
	  //go to sort menu
      if (e.getSource() == sortStu) {
         contentPaneLayout.show(contentPane, "Menu 6");
      }
	  // go to view menu
      if (e.getSource() == viewDelete) {
         String [][] data = new String [size][15];
         for (int i = 0; i < size; i++) {
			 //load in rows for student info
            data[i][0] = "" + array[i].ID;
            data[i][1] = "" + array[i].Name;
            data[i][2] = "" + array[i].classLevel;
            data[i][3] = "" + array[i].Gender;
            data[i][4] = "" + array[i].Age;
			//load in columns for scores
            for (int n = 0; n < 10; n++) {
               data[i][5+n] = "" + array[i].labs[n];
               
            }
         }
		 // format view menu columns
         String [] columnName = {"ID", "Name", "Level", "Gender", "Age", "Lab 1", "Lab 2", "Lab 3", "Lab 4", "Lab 5", "Lab 6", "Lab 7", "Lab 8", "Lab 9", "Lab 10",};
         //put in table
		 table = new JTable(data, columnName);
		 //style size
         table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
         table.setPreferredScrollableViewportSize(new Dimension (944, 168));
         //put everything in view menu
		 JScrollPane tmp = new JScrollPane(table);
         scrollPane.setViewport(tmp.getViewport());
         contentPaneLayout.show(contentPane, "Menu 7");
      }
	  
	  // creates backup
      if (e.getSource() == backup){ 
         try {	FileOutputStream fos = new FileOutputStream (className, false);//check errors
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (int i = 0; i < size; i++) {
               oos.writeObject(array[i]);
            }
            oos.close();
         } 
         catch(FileNotFoundException ee){ System.out.println(ee.toString());
         } 
         catch(IOException ee){ ee.printStackTrace();}
      }
		
		//input saved file from backup
      if (e.getSource() == load){ 
         className = text4.getText();
         size = 0;
         try {
            FileInputStream fis = new FileInputStream (className);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (true) {
               Student St = (Student) ois.readObject();
               array[size] = St;
               size++;
            }
         } 
         catch(EOFException ee){
            text1.setText(className);
            text2.setText("" + size);
            contentPaneLayout.show(contentPane, "Menu 1");
         } 
         catch(Exception ee){ ee.printStackTrace();
         } 
      
      }
	  // delete and re-shift data
      if (e.getSource() == delete) {
         int row = table.getSelectedRow();
         for (int i = row; i < size -1; i++) {
            array[row] = array[row +i];
         }
         size--;
         String [][] data = new String [size][15];
         for (int i = 0; i < size; i++) {
            data[i][0] = "" + array[i].ID;
            data[i][1] = "" + array[i].Name;
            data[i][2] = "" + array[i].classLevel;
            data[i][3] = "" + array[i].Gender;
            data[i][4] = "" + array[i].Age;
            for (int n = 0; n < 10; n++) {
               data[i][5+n] = "" + array[i].labs[n];
               
            }
         }
         String [] columnName = {"ID", "Name", "Level", "Gender", "Age", "Lab 1", "Lab 2", "Lab 3", "Lab 4", "Lab 5", "Lab 6", "Lab 7", "Lab 8", "Lab 9", "Lab 10",};
         table = new JTable(data, columnName);
         table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
         table.setPreferredScrollableViewportSize(new Dimension (944, 168));
         JScrollPane tmp = new JScrollPane(table);
         scrollPane.setViewport(tmp.getViewport());
         contentPaneLayout.show(contentPane, "Menu 7");
         text2.setText("" + size);
      }
	  
	  //sort by name or ID
      if (e.getSource() == sort) {
         Student temp = null;
         if (first.isSelected()) { //by ID
            for (int i = 0; i < size; i++) {
               for (int j = i + 1; j < size; j++) {
                  if (array[i].ID > array[j].ID) {
                     temp = array[i];
                     array[i] = array[j];
                     array[j] = temp;
                  }
               }
            }
            contentPaneLayout.show(contentPane, "Menu 1"); // back to main menu
         }
         if (second.isSelected()) { // by name
            Student tmp = null;
            for (int i = 0; i < size; i++) {
               for (int j = i + 1; j < size; j++) {
                  int num = array[i].Name.compareTo(array[j].Name);
                  if (num > 0) {
                     tmp = array[i];
                     array[i] = array[j];
                     array[j] = tmp;
                  }
               }
            }
            contentPaneLayout.show(contentPane, "Menu 1"); //back to main menu
         }
      }
      if (e.getSource() == exit) { //exit program
         System.exit(0);
      }
      if (e.getSource() == create) { // set class name on main menu and go back to main menu
         className = text3.getText();
         text1.setText(className);
         contentPaneLayout.show(contentPane, "Menu 1");
      }
      if (e.getSource() == saveAdd) { // add student info into array
         array[size] = new Student();
         String myString = Integer.toString(size);
         text2.setText(myString);
         array[size].ID = Integer.parseInt(text5.getText());
         array[size].Name = text6.getText();
         array[size].Gender = ((String)GList.getSelectedItem()).charAt(0);
         array[size].Age = Integer.parseInt(text7.getText());
         array[size].classLevel = (String)AList.getSelectedItem();
         size++; //for every save click
		 //reset
         text2.setText("" + size);
         text5.setText("");
         text6.setText("");
         text7.setText("");
         GList.setSelectedIndex(0);
         AList.setSelectedIndex(0);
      }
      if (e.getSource() == text10) { // score
         String text = text11.getText();// student name
         for (int i = 0; i < size; i++) {
            if ((array[i].Name).equals(text)) { //match student name
               if (text9.getText().equals( "1")) { //lab # matching
                  array[i].labs[0] = text10.getText(); //save score
               }
               if (text9.getText().equals("2")) {
                  array[i].labs[1] = text10.getText();
               }
               if (text9.getText().equals("3")) {
                  array[i].labs[2] = text10.getText();
               }
               if (text9.getText().equals("4")) {
                  array[i].labs[3] = text10.getText();
               }
               if (text9.getText().equals("5")) {
                  array[i].labs[4] = text10.getText();
               }
               if (text9.getText().equals("6")) {
                  array[i].labs[5] = text10.getText();
               }
               if (text9.getText().equals("7")) {
                  array[i].labs[6] = text10.getText();
               }
               if (text9.getText().equals("8")) {
                  array[i].labs[7] = text10.getText();
               }
               if (text9.getText().equals("9")) {
                  array[i].labs[8] = text10.getText();
               }
               if (text9.getText().equals("10")) {
                  array[i].labs[9] = text10.getText();
               }
            }
         }
		 //reset
         text9.setText("");
         text11.setText("");
         text10.setText("");
         contentPaneLayout.show(contentPane, "Menu 1"); // back to main menu
      }
   }
}

class Student implements Serializable { int ID; String Name; char Gender; int Age; String classLevel; String [] labs = {"0","0","0","0","0","0","0","0","0","0"};}