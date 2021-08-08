/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataProcessing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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
                    File myObj = new File(fileNames[i]);//[i]

                    if (myObj.createNewFile()) {
                        System.out.println("File created: " + myObj.getName());
                    }
                } catch (IOException ex2) {
                    System.out.println("input / output error");
                }
            }
        }
        return true;
    }

}
