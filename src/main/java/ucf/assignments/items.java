/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Riya Singh
 */
package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
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
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

//NOTE: Pseudocode is included within each method
//I am commenting the basic code + pseudocode to successfully execute and run the GUI Mock up


/*
public class items implements Initializable, EventHandler<ActionEvent>
{

    private String date; //store the date
    private String description; //store the description
    private int status; //store  0 for incomplete task, 1 for completed task
    private File file; //store the name of the .csv file
    //Create an observable list of string type to store description, date, and status
    //Create an observable list of string type to store description and date of complete tasks
    //Create an observable list of string type to store description and date of incomplete tasks

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        /*
        -Create new scene object
        -Initialize or define all the buttons that will be used in this new scene
        -Call handle method when required (for different methods)
         */
/*
    }

    @Override
    public static handle()
    {
        /*
        -If the user selects "add item", call the addEvent method
        -If the user check the check-box for complete items call the completeItems method
        -If the user selects "Remove item", call the removeEvent method
        -If the user double-clicks an item description, call  the editDescription
        -If the user double-clicks an item date, use the object to editDate
         */
/*
    }

    public void setDate() //set date
    {
        /*
        -Store in the input for date
        -The input will be in string format
         */
/*
    }

    public String getDate() //get date
    {
        /*
        -Return date;
         */
/*
    }

    public void setDescription(String description) //set the description
    {
        /*
        -Store in the input for date
        -The input will be in string format
         */
/*
    }

    public String getDescription() //get description
    {
        /*
        -Return description;
         */
/*
    }

    public void check() //set the status of a task
    {
        /*
        -If the check-box is unchecked for the current item
        --set the status as 0 and call the createIncompleteItemsList method, pass in the current item to the function
        -Else, set the status as 1 and call the createCompleteItemsList method, pass in the current item to the function
         */
/*
    }


    public void addToList() //append items in the observable list
    {
        /*
        -Add the events to the observable list
        -Call the writeToCSV method to write all the data on the text file
         */
/*
    }

    public void writeToCSV() //Write to .csv file
    {
        /*
        -Write to .CSV file by creating string separated by commas.
         */
/*
    }

    public void createCompleteItemsList(String str) //add completed tasks to complete list
    {
        /*
        -Add items to the complete list variable
         */
/*
    }

    public void createIncompleteItemsList(String str) //add incomplete tasks to incomplete list
    {
        /*
        -Add items to the incomplete list variable
         */
/*
    }

    public void editDescription() //edit description
    {
        /*
        -Store the new item description from the text field
        -change the name (by finding the index) in all the lists
         */
/*
    }

    public void editDate() //edit date
    {
        /*
        -Store the new date from the date picker
        -change the date (by finding the index) in all the lists
         */
/*
    }

    public void deleteFromList(String str) //remove an item from the list
    {
        /*
        -Find the index name and date of the associated item
        -Remove the string at that index
         */
/*
    }

    public void display(ActionEvent event) //Display/print specific items
    {
        /*
        -If the user selects "Display All", then display/print all the items
        -If the user selects "Display Complete tasks", then display/print only the completed items
        -If the user selects "Display Incomplete tasks", then display/print only the incomplete items
         */
/*
    }

    public void readCSV(String str) //read .csv file
    {
        /*
        -Run a while loop to read .csv file by using the comma splitter
        -Print the list in list view
        -May need to parse
         */
/*
    }

}
 */

