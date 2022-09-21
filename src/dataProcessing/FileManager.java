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
import static java.lang.module.ModuleDescriptor.read;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author glassiron
 */
public class FileManager {
//Made all files cause they wernt existing (played god)
// still have to do delete

    public static boolean existingFileCheck() {
        String[] fileNames = {"userData.txt", "TasksData.txt", "AssignmentsData.txt", "SubjectsData.txt"};

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
// what was this meant to do?
        int taskID = 0;
        String assignmentID = " ";
        String subjectID = " ";

        String[] fileNames = {"userData.txt", "TodosData.txt", "AssignmentsData.txt", "SubjectsData.txt"};

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

        //need to add the code for physically adding the task to the gui
        //get taskID from userData.txt .no changing it to its own file which will be then written to array when "App" is opened
        try {

            FileWriter taskAddToFile = new FileWriter("TasksData.txt", true);
            PrintWriter file = new PrintWriter(taskAddToFile);

            String fileLine = newTaskName + "#" + newTaskDescription + "#" + newTaskImportance + "#" + newTaskUrgency + "#" + newTaskDueDate;
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

//save task to file
//save taskID to user data for future recolection and being able to find files 
    /**
     * IDCounter stuff
     *
     * Method to get IDNum(getter) -Passing in file Name as parameter and
     * returns the ID for file
     *
     *
     * method to set IDNum / add to it (setter) -Passing in file Name as
     * parameter and returns the ID for file
     *
     */
// save coumt to files at userData.txt
//another method to read task from file (give task ID then display (to prebuild UI?))

    /*
This is for subject Data now no longer task data

what needs to be done 
-Subject creation method
-Subject addign method so its in the spinner on the gui
- do i need to add a linking system between assignments and there subjects?
     */
    public static void subjectFileAdd(String subjectName, int importance, int urgancy) {
//Writing to file to save added subject
        try {
            FileWriter subjectAddToFile = new FileWriter("SubjectsData.txt", true);
            PrintWriter file = new PrintWriter(subjectAddToFile);

            String fileLine = subjectName + "#" + importance + "#" + urgancy;
            file.println(fileLine);
            file.close();
        } catch (IOexception ex) {
        }
    }

    public static void subjectGUIAdd() {
        // this will be called when add button is clicked 
        //data valdation to check not adding the same subject?

        try {
            File read = new File("SubjectsData.txt");
            Scanner file = new Scanner(read);

            while (file.hasNext()) {
                String line = file.nextLine();
                String[] details = line.split("#");

                String subjectAddtoGUI = details[0];
            }
        } catch (FileNotFoundException ex) {

        }
        SubjectFrntScrn.spnSubjectList.println(subjectAddtoGUI);

    }

}
