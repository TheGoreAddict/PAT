/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataProcessing;

import java.util.Date;


/**
 *
 * @author glassiron
 */
public class TaskCRUD {
    
    
    public static boolean addTask(String newTaskName, String newTaskDescription, int newTaskImportance, int newTaskUrgency, Date newTaskDueDate){
        System.out.println(newTaskName + newTaskImportance + newTaskDueDate);
        
        FileManager.existingFileCheck();
        FileManager.userDataCheckID();
        
        FileManager.finishedFileTaskAdd(newTaskName, newTaskDescription, newTaskImportance, newTaskUrgency, newTaskDueDate);
        return true;
    }
}
