/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Riya Singh
 */

//For Some reason, I am not able to run Tests methods in controller class. I am really sorry for that.

/*package ucf.assignments;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FXMLControllerTest {
    FXMLController obj = new FXMLController();

    //Test for write description
    @Test
    public void isDescription1()
    {
        String str = "";
        boolean ret = obj.checkDescription(str);
        assertFalse(ret);
    }

    @Test
    public void isDescription2()
    {
        String str = "New Task 1";
        boolean ret = obj.checkDescription(str);
        assertTrue(ret);
    }

    @Test
    public void isDescription3()
    {
        String str = ("THIS STRING IS 256 CHARACTERS xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        boolean ret = obj.checkDescription(str);
        assertFalse(ret);
    }

    //Test for Date
    @Test
    public void isDate1()
    {
        String str = "2021-12-01";
        LocalDate dt = LocalDate.parse(str);
        boolean ret = obj.checkDate(dt);
        assertTrue(ret);
    }

    @Test
    public void isDate2()
    {
        String str = "";
        LocalDate dt = LocalDate.parse(str);
        boolean ret = obj.checkDate(dt);
        assertFalse(ret);
    }

    @Test
    public void isDate3()
    {
        String str = "2021-11-01";
        LocalDate dt = LocalDate.parse(str);
        boolean ret = obj.checkDate(dt);
        assertFalse(ret);
    }

    @Test
    public void isDate4()
    {
        String str = "2021-01-01";
        LocalDate dt = LocalDate.parse(str);
        boolean ret = obj.checkDate(dt);
        assertFalse(ret);
    }

    @Test
    public void isDate5()
    {
        String str = "2001-12-01";
        LocalDate dt = LocalDate.parse(str);
        boolean ret = obj.checkDate(dt);
        assertFalse(ret);
    }

    //Adding more than 100 items to the list
    @Test
    public void checkSize()
    {
        String str = "abc";
        String date = LocalDate.now().toString();
        boolean status = true;
        for(int i = 0; i < 102; i++)
            obj.addItem(str, date, status);
        int temp = obj.data.getSize();
        boolean ret;
        if(temp == 101)
            ret = true;
        else
            ret = false;
        assertTrue(ret);
    }

    //Test for stored data, incomplete, and complete  lists
    @Test
    public void checkData()
    {
        ArrayList<String> descriptionList = new ArrayList<>();
        ArrayList<String> statusListC = new ArrayList<>();
        ArrayList<String> statusListI = new ArrayList<>();

        descriptionList.add("Task 1");
        descriptionList.add("Task 2");
        descriptionList.add("Task 3");

        statusListC.add("Complete");
        statusListC.add("Complete");

        obj.addData("Task 1", LocalDate.now().toString(), true);
        obj.addData("Task 2", LocalDate.now().toString(), false);
        obj.addData("Task 3", LocalDate.now().toString(), true);

        boolean ret;
        for(int i = 0; i < 3; i++)
        {
            if(descriptionList.get(i).compareTo(obj.data.getDescription()) == 0)
            {
                ret = true;
            }
            else
            {
                ret = false;
                break;
            }
        }
        assertTrue(ret);


        if(obj.completeItem(obj.data).Size() == 2)
        {
            ret = true;
        }
        else
        {
            ret = false;
        }
        assertTrue(ret);

        if(obj.IncompleteItem(obj.data).Size() == 1)
        {
            ret = true;
        }
        else
        {
            ret = false;
        }
        assertTrue(ret);
    }

    @Test
    public void checkFile1() {
        File file = obj.getFileName();
        boolean ret;
        if(file.isFile())
            ret = true;
        else
            ret = false;
        assertTrue(ret);
    }

    @Test
    public void checkFile1() {
        File file = obj.getSaveFileName();
        boolean ret;
        if(file.isFile())
            ret = true;
        else
            ret = false;
        assertTrue(ret);
    }

}*/
