 /*
 ****************************************************** PART TWO ***********************************************************************************************
=====================================Student Information=================================================
Student Number:     st10251759
Student Name:       Cameron Chetty
Course:             BCAD PROG5112
Group:              1
==========================================================================================================
*/

 /*   =============Code Attribution====================

    Author: Zahra Bulbulia
    Website: https://github.com/zb662000/prog1stuff/blob/main/MovieQ/src/movieq/MovieQ.java
    Date of Access: 28 May 2023        
            
    =============Code Attribution====================    */
package com.mycompany.st10251759_poe_p2_test;
//import the joptionpane to project => used for user input and output messages
import javax.swing.JOptionPane;  

public class ST10251759_POE_P2_Test {//begin public class

    public static void main(String[] args) {//begin main class
       showWelcomeScreen();
       showFeatures();
    }//end main class
    
    
//method to diaplay welcome message if user successfully loggied in
  public static void showWelcomeScreen() {//begin showWelcomeScreen
        //if (login.loginUser()){} - not sure to add this or not
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban!");
    }//end showWelcomeScreen
    
//method to alllow the user to chosea feature from the numeric menu
public static void showFeatures(){//begin showFeatures
    //run while loop to ensure the options are continuely displaying unless the user types 3 to QUIT
    while (true) {//begin while loop => while it is true
            String option = JOptionPane.showInputDialog(null, "Please choose an option:\n" +
                    "1. Add tasks\n" +
                    "2. Show report\n" +
                    "3. Quit");

            switch (option) {
                case "1":
                    //call method to Add new tasks 
                    addNewTasks();
                    break;
                case "2":
                    //call method to show report - currently not availble so messeasge will be displayed
                    JOptionPane.showMessageDialog(null, "Coming Soon!");
                    break;
                case "3":
                    //allow user to quit and end program
                    JOptionPane.showMessageDialog(null, "Exiting EasyKanban. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    //validation if user enters any other option not within the range 1 to 3
                    JOptionPane.showMessageDialog(null, "Invalid option. Please choose a valid option.");
            }
        }//end while loop
    
}//end showFeatures

//method to add new tasks by getting the number of tasks the user should add
public static void addNewTasks() {//begin addNewTasks
        //propmt user to enter the num of task they want to enter
        int numberOfTasks = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the number of task you wish to add"));
        int taskNum = 0; //acts as a counter
        int totalDuration = 0; //initalise total to 0
    //run a for loop to add each task that user wants using numberOfTask 
    
 for (int i=0; i < numberOfTasks; i++)
 {//begin for
     //increase taskNum by 1 everytime a task is added
     //prompt user for task name
     taskNum++;
 String taskName = JOptionPane.showInputDialog(null, "Please enter the name of the task to be added");
 
      //prompt user for task Description 
 String taskDescription = JOptionPane.showInputDialog(null, "Please enter the description of the task to be added");
 

      //prompt user for ull name of developer
String devDetails = JOptionPane.showInputDialog(null, "Please enter the first and last name/s of the Developer working on the task");
 
      //prompt user for task name
int taskDuration = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the duration allocated to completing the task in the estimated hours"));

      //prompt user for task name
  // String taskStatus = "";   //create variable to store the option 
   //get the input form the user using a selection
//String taskStatus = JOptionPane.showInputDialog(null, "Please enter the number for status of task, Chose from: \n1. To do\n2. Doing\n3. Done");
String[] choices = { "To Do", "Doing", "Done"};

    String taskStatus = (String) JOptionPane.showInputDialog(null, "Choose now...",
        "Select Task Status", JOptionPane.QUESTION_MESSAGE, null, // Use
                                                                        // default
                                                                        // icon
        choices, // Array of choices
        choices[1]); // Initial choice

//get the total for the duration in for loop
//totalDuration = totalDuration + taskDuration;


 //create object and pass the data as parameters to the Tasks class
 Tasks tasks = new Tasks(taskName, taskDescription, devDetails, taskDuration, taskStatus, taskNum);
 

 
 //Call method to check if task description is incorrect
 while(!tasks.checkTaskDescription())
 {//begin while checkTaskDescription is false
     taskDescription = JOptionPane.showInputDialog(null, "Please enter a task description of less than 50 characters");
     //call set method to get pass the new taskDescription to the task class as a parameter
     tasks.setTaskDescription(taskDescription);
     
 }//end while
  //if method to validate is task description is successfully captured >>validation if checkTaskDescription is true
  if (tasks.checkTaskDescription())
  {//begin if
      JOptionPane.showMessageDialog(null, "Task successfully captured");
  }//end if
  
  //display the task in report formaat by calling printTaskDetails method 
JOptionPane.showMessageDialog(null, tasks.printTaskDetails());

//call set method to add the hours to the totalDuration taking in the parameter of totalDuration and taskDuration, as loop runs the taskDuration for each task is added to the totalDuration
tasks.setTotalDuration(taskDuration, totalDuration);
totalDuration = tasks.returnTotalHours(); //method to return the totalDuration / totalHours
 }//end for


 //Display total number of tasks and totalDuration to complete the Tasks
 JOptionPane.showMessageDialog(null,"The total hours spent for "+numberOfTasks + " tasks is "+ totalDuration + " hour/s");
    }//end addNewTasks
    
}//end public class
