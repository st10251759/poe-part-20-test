/*
=====================================Student Information=================================================
Student Number:     st10251759
Student Name:       Cameron Chetty
Course:             BCAD PROG5112
Group:              1
==========================================================================================================
*/
package com.mycompany.st10251759_poe_p2_test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

    /*
    =============Code Attribution====================
    Author: VCSOIT - Sarina
    Website: https://www.youtube.com/watch?v=1Pa15vDWG-8&list=PL480DYS-b_kfHSYf2yzLgto_mwDr_U-Q6&index=4
    Date of Access: 29 April 2023
    =============Code Attribution====================
    */
public class TasksTest {
    
    public TasksTest() {
    }
    //Variable Actual => the boolean value when the method runs 
    //Variable Expected => the boolean value of a patricular result from a method
    
    //instaniate constuctor 
     Tasks tasks = new Tasks("Test", "Test", "Test", 1, "Test", 0);
     
     /**
     * Test of checkTaskDescription() method is Correct, of class Tasks.
     */
     
         @Test
    public void testCheckTaskDescriptionSuccess() {
        //call set method to change the string value of taskDexcription to test Data
        tasks.setTaskDescription("Create Login to authenticate users");
        
        //actual return when calling the method checkTaskDescription
        boolean Actual = tasks.checkTaskDescription();
        
        //The expected outcome
        boolean Expected = true;
        
        //compare expected and actual values to see if they much
        assertEquals(Expected, Actual);
    }
    
     /**
     * Test of CreateTaskID method is correct, of class Tasks.
     */
    @Test
    public void testCreateTaskIDSuccess() {
        //call set method to add the test data
        tasks.setTaskName("Login Feature"); 
        tasks.increaseTaskNum();
        
        tasks.setDevDetails("Robyn Harrison" );
        
        //call method createTaskID and store in actual variable
        String Actual = tasks.createTaskID();
        //assign the expected out come
        String Expected = "LO:1:SON";
        
        //compare actual and expected to see if they match
        assertEquals(Expected, Actual);
    }

     /**
     * Test of returnTotalHours method is correct, of class Tasks.
     */
    @Test
    public void testTotalHoursSuccess(){
    
       //get the total after task 1 
       tasks.setTotalDuration(8, 0);
       int returnTask1 = tasks.returnTotalHours();
       
       //get the total after task 2
       tasks.setTotalDuration(10, returnTask1);
      int Actual = tasks.returnTotalHours();
      
      //creae variable that this the expected outcome of calling the methods
      int Expected = 18;
      
      //Compare the expected and actual variables
      assertEquals(Expected, Actual);
    }
    
    /**
     * Test of returnTotalHours method is correct using additional data, of class Tasks.
     */
    @Test
    public void testAdditionalHoursSuccess(){
    
        //declare the array to hold test data
        int [] testData = {10, 12, 55, 11, 1};
        //variable to hold the result of calling the methods of Task class
        int Expected = 0;
        
        
        
        //run for loop to add the hours from the array
        for (int i =0; i < 5;i++ )
        {//begin
            //call set method to add the values of the array
          tasks.setTotalDuration(testData[i], Expected);
          
           //call the return method 
          Expected = tasks.returnTotalHours();
           
        }//end
        
        int Actual = 89;
      
      //Compare the expected and actual variables
      assertEquals(Expected, Actual);
    }
     /**
     * Test if the expected outcome is true for method checkDescription, of class Tasks.
     */
    @Test
    public void testCheckDescriptionIsTrue(){
    
        //call set method to assign the testdata to the task description
        tasks.setTaskDescription("Create Login to authenticate users");
        boolean Actual = tasks.checkTaskDescription(); //call method to validate the task description
        //call the method which test for the outcome being true
        assertTrue(Actual);
      
    }
    
     /**
     * Test if the expected outcome is false for method checkDescription, of class Tasks.
     */
    @Test
    public void testCheckDescriptionIsFalse(){
    
        //call set method to assign the testdata to the task description
        tasks.setTaskDescription("Create Login to authenticate users to autherticate the username and password for login");
        boolean Actual = tasks.checkTaskDescription(); //call method to validate the task description
        //call the method which test for the outcome being false
        assertFalse(Actual);
      
    }
    
      
}
