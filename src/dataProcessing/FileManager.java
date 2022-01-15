/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataProcessing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author glassiron
 */
public class FileManager {
//Made all files cause they wernt existing (played god)

    public static boolean existingFileCheck() {
        String[] fileNames = {"userData.txt", "TasksData.txt", "TodosData.txt", "AssignmentsData.txt", "SubjectsData.txt"};

        try {
            File read = new File(fileNames[0]);
            Scanner myReader = new Scanner(read);

            return true;

        } catch (FileNotFoundException ex) {

            for (int i = 0; i < fileNames.length; i++) {
                try {
                    File create = new File(fileNames[i]);//[i]

                    if (create.createNewFile()) {
                        System.out.println("File created: " + create.getName());
                    }
                } catch (IOException ex2) {
                    System.out.println("input / output error");
                }
                try {
                    FileWriter taskAddToFile = new FileWriter(fileNames[i], false);
                    PrintWriter file = new PrintWriter(taskAddToFile);

                    int IDNum = 1;
                    String IDCounter = fileNames[i] + "IDCounter" + "#" + IDNum;
                    file.println(IDCounter);

                    file.close();

                } catch (IOException ex2) {

                }

            }
        }
        return true;
    }

    public static void userDataCheckID() {

        String taskID = " ";
        String todoID = " ";
        String assignmentID = " ";
        String subjectID = " ";
        
        String[] fileNames = {"userData.txt", "TasksData.txt", "TodosData.txt", "AssignmentsData.txt", "SubjectsData.txt"};
        
        for (int i = 1; i < 5; i++) {
            
            try {
                File read = new File(fileNames[i]);
                Scanner myReader = new Scanner(read);
                
                 while (myReader.hasNext()) {

                String line = myReader.nextLine();
                String[] details = line.split("#");
                
                myReader.close();
                
                 }
                
            } catch (FileNotFoundException ex) {
            }
            
        }

    }

    public static void finishedFileTaskAdd(String newTaskName, String newTaskDescription, int newTaskImportance, int newTaskUrgency, Date newTaskDueDate) {

        //
        //get taskID from userData.txt
        try {

            FileWriter taskAddToFile = new FileWriter("TasksData.txt", true);
            PrintWriter file = new PrintWriter(taskAddToFile);

            String fileLine = newTaskName + "#" + newTaskDescription + "#" + newTaskImportance + "#" + newTaskUrgency + "#" + newTaskDueDate + "#" + taskID;
            file.println(fileLine);
            file.close();

        } catch (IOException ex) {

        }
        //return 
        /**
         *
         * uniqueID (finishedFileTaskAdd should return with the ID)
         *
         */
    }
}

//save task to file
//save taskID to user data for future recolection and being able to find files 
/**
 * IDCounter shit
 *
 * Method to get IDNum(getter) -Passing in file Name as parameter and returns
 * the ID for file
 *
 *
 * method to set IDNum / add to it (setter) -Passing in file Name as parameter
 * and returns the ID for file
 *
 */
// save coumt to files at userData.txt
//another method to read task from file (give task ID then display (to prebuild UI?))
