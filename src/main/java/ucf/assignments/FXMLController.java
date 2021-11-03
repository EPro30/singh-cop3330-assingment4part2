/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Riya Singh
 */

package ucf.assignments;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

public class FXMLController implements Initializable, EventHandler<ActionEvent>
{

    @FXML
    private Label label;
    @FXML
    Button button1;
    @FXML
    TextField title;
    @FXML
    TextField description;
    @FXML
    DatePicker date;

    String fileName;

    //Create an ArrayList of items type to store the names of to-do lists
    //ArrayList<items> toDoLists = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        label.setText("To Do List");
        button1 = new Button();
        button1.setOnAction(this::handle);
    }

    @Override
    public void handle(ActionEvent event) //handle all the button clicks
    {
        /*
        -If user selects "new" from "File", call the method to create new file.
        -If user selects "save" from "File", call the method to save the file.
        -If user selects "open" from "File", call the method to open or load previous file(s).
        -If user selects "close" from "File", call the method to close the file.

        -If user selects "new" from "File", call the method to create new file.
        -If user selects "new" from "File", call the method to create new file.

        -If user selects "help", call the method to open a new scene or page that displays
        how to use the app.
        */
    }


    public void addToArrayList() //append ArrayList
    {
        /*
        -add new to-do Lists to the toDoLists arrayList
        -The names will be stored with .csv extension
         */
    }

    public void getToDoList() //return appended or updated arrayList
    {
        /*
        -Return update arrayList;
         */
    }

    public void removeToDoListName(String str) //remove a file name from the ArrayList
    {
        /*
        -Find the index of the file name
        -Call the remove function and pass in the index to delete the filename from the list
         */
    }

    public void editToDoListName(String oldStr, String newStr) //replace or change the file name from the ArrayList
    {
        /*
        -Find the index of the old file name
        -Call the replace function and pass in the index of the old string and new string to replace the file name
         */
    }

    public void saveFile() //save file to an external storage
    {
        /*
        -If it is a new file, store file name in a variable
        -This string variable will be used throughout the program to access and save items
        -Create a FileChooser object
        -Specify the external storage path
        -Use the stored file name to save the file
        -The extension of the file will be .csv
         */
    }

    public void newFile() //Open a new scene to add items to the to-do lists
    {
        /*
        -Display the List view, "add item", "Enter Decription", "add date", and check-box on the scene
        -Create an object of "items" type to call method associated to items class
         */
    }

    public void openFile() //Open the selected file
    {
        /*
        -Get the file name to open
        -Set the file path
        -Load the file, read it by calling the readCSV method from items class, and display it on the screen.
         */
    }

    public void close() //Close the file and exit
    {
        /*
        -Close the file and exit from the app
         */
    }

    public void renameFile() //Change the file name
    {
        /*
        -Store the new name of the file
        -Call the editToDoListNames method to change the name of the file in that list
        -Change the file name in the file path
         */
    }

    public void deleteFile() //Delete a file
    {
        /*
        -Store the name of the file to be deleted
        -Call the removeToDoListName and pass in the name of the file to remove it from the ArrayList
        -Remove the file from the external storage by creating a File object and then using delelete function
         */
    }

    public void help() //Display a help page
    {
        /*
        -Show a new scene or page that guides the user to use the app
        -Could be like FAQ page
         */

    }
}
