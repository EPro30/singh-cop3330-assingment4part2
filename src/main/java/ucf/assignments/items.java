/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Riya Singh
 */
package ucf.assignments;

import javafx.beans.property.SimpleStringProperty;
import java.time.LocalDate;

public class items {

    public final SimpleStringProperty description; //store the task description
    public final SimpleStringProperty status; //store the task status
    public final SimpleStringProperty date; //store the task due date

    //items contructors with parameters used to initialize the data for a new task
    items(String description, LocalDate date, boolean boolStatus) {
        this.description = new SimpleStringProperty(description);
        this.date = new SimpleStringProperty(date.toString());
        if(boolStatus)
            status = new SimpleStringProperty("Complete");
        else
            status = new SimpleStringProperty("Incomplete");
    }

    //items constructor with parameters used to load data from a file
    items(String strDescription, String strDate, String strStatus) {
        this.description = new SimpleStringProperty(strDescription);
        this.date = new SimpleStringProperty(strDate);
        this.status = new SimpleStringProperty(strStatus);
    }

    //set the due date of a task
    public void setDate(LocalDate dt) //set date
    {
        //this.dt.set(dt.toString());
        date.set(dt.toString());
    }

    //get the due date of a task
    public String getDate()
    {
        return date.get();
    }

    //set the description of a task
    public void setDescription(String strDescription) //set the description
    {
        description.set(strDescription);
    }

    //get description
    public String getDescription()
    {
        return description.get();
    }

    //set the status of a task
    public void setStatus(String newStatus)
    {
        status.set(newStatus);
    }

    //Get the status of a task
    public String getStatus()
    {
        return status.get();
    }
}

