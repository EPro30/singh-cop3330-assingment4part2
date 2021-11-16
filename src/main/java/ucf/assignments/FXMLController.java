/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Riya Singh
 */

package ucf.assignments;

import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FXMLController implements Initializable, EventHandler<ActionEvent>
{

    @FXML
    public Label label;
    @FXML
    public Button addItem;
    @FXML
    public Label title;
    @FXML
    public TextField addDescription = new TextField();
    @FXML
    public DatePicker addDate = new DatePicker();
    @FXML
    public CheckBox boolStatus = new CheckBox();
    @FXML
    public TableView<items> table = new TableView<>();
    @FXML
    public TableColumn<items, String> descriptionCol;
    @FXML
    public TableColumn<items, String> dateCol;
    @FXML
    public TableColumn<items, String> statusCol;
    @FXML
    public Button deleteAll;
    @FXML
    public Button deleteAnItem;
    @FXML
    public Button displayAll;
    @FXML
    public Button displayComplete;
    @FXML
    public Button displayIncomplete;
    @FXML
    public Button save;
    @FXML
    public Button open;
    @FXML
    public Button help;
    @FXML
    public Button exit;


    //Create an ObservableList of items type to store the information of individual tasks
    ObservableList<items> data = FXCollections.observableArrayList();
    FileChooser fileChooser = new FileChooser();

    //Initialize FXML Buttons, set cell Property for table column,
    //call handle methods for associated methods,
    //handle editable columns
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        label.setText("TO Do List");
        addItem = new Button();
        deleteAll = new Button();
        deleteAnItem = new Button();
        displayAll = new Button();
        displayComplete = new Button();
        displayIncomplete = new Button();
        save = new Button();
        open = new Button();
        help = new Button();
        exit = new Button();

        displayAll.setOnAction(this::handleDisplayAll);
        displayComplete.setOnAction(this::handleDisplayComplete);
        displayIncomplete.setOnAction(this::handleDisplayIncomplete);

        save.setOnAction(this::handleSave);
        open.setOnAction(this::handleOpen);
        help.setOnAction(this::handleHelp);
        exit.setOnAction(this::handleClose);

        table.setEditable(true);

        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        descriptionCol.setCellFactory(TextFieldTableCell.forTableColumn());
        descriptionCol.setOnEditCommit(new EventHandler<>() {
            @Override
            public void handle(TableColumn.CellEditEvent<items, String> event) {
                items item = event.getRowValue();
                String newDescription = event.getNewValue();
                data = editDescription(item, newDescription, data);
                table.refresh();
            }
        });

        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        dateCol.setCellFactory(TextFieldTableCell.forTableColumn());
        dateCol.setOnEditCommit(new EventHandler<>() {
            @Override
            public void handle(TableColumn.CellEditEvent<items, String> event) {
                items item = event.getRowValue();
                LocalDate newdt = LocalDate.parse(event.getNewValue());
                data = editDate(item, newdt, data);
                table.refresh();
            }
        });

        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        statusCol.setCellFactory(TextFieldTableCell.forTableColumn());
        statusCol.setOnEditCommit(new EventHandler<>() {
            @Override
           public void handle(TableColumn.CellEditEvent<items, String> event) {
               items item = event.getRowValue();
               String newStatus = event.getNewValue();
               data = editStatus(item, newStatus, data);
               table.refresh();
           }
        });

        table.setItems(data);
        table.getColumns().addAll(descriptionCol, dateCol, statusCol);

        addItem.setOnAction(this::handle);
        deleteAnItem.setOnAction(this::handleDeleteAnItem);
        deleteAll.setOnAction(this::handleDeleteAll);
        table.setItems(data);
        table.refresh();

    }

    //Handle Add Item button
    @FXML
    public void handle(ActionEvent event)
    {
        boolean isDescription = checkDescription(addDescription.getText());
        boolean isDate = checkDate(addDate.getValue());
        String msg;

        if(isDescription && isDate)
        {
            addData(addDescription.getText(), addDate.getValue(), boolStatus.isSelected());
            addDescription.clear();
            addDate.setValue(null);
            boolStatus.setSelected(false);
            table.setItems(data);
            table.refresh();
        }
        else if(!isDescription || !isDate)
        {

            if(!isDescription && !isDate)
            {
                msg = "Please describe the task in less than 256 characters \n Please PICK a VALID date from date picker.";
                msg += "\nPlease check your Day, Month, Year.";
                warning(msg);
            }
            else if(!isDescription)
            {
                msg = "Please describe the task in less than 256 characters";
                warning(msg);
            }
            else if(!isDate)
            {
                msg = "Please PICK a VALID date from date picker.";
                msg += "\nPlease check your Day, Month, Year.";
                warning(msg);
            }
        }
    }

    //Handle Save button
    @FXML
    public void handleSave(ActionEvent event)
    {
        File savesFile = getSaveFileName();
        FileWriter file;
        try {
            if(savesFile.getName().contains(".txt"))
            {
                file = new FileWriter(savesFile);
            }
            else {
                file = new FileWriter(savesFile + ".txt");
            }

            for (items item : data) {

                file.write(item.getDescription() + "," + item.getDate() + "," + item.getStatus() + "\n");
            }
            file.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Handle Open button
    @FXML
    public void handleOpen(ActionEvent event)
    {
     data = openFile();
     table.setItems(data);
     table.refresh();
    }

    //Handle Help button
    @FXML
    public void handleHelp(ActionEvent event)
    {
        helpWindow();
    }

    //Handle Close button
    @FXML
    public void handleClose(ActionEvent event)
    {
        Platform.exit();
    }

    //Handle Display Complete Items button
    @FXML
    public void handleDisplayComplete(ActionEvent event)
    {
        table.setItems(completeItem(data));
        table.refresh();
    }

    //Handle Display Incomplete Items button
    @FXML
    public void handleDisplayIncomplete(ActionEvent event)
    {
        table.setItems(incompleteItem(data));
        table.refresh();
    }

    //Handle Display All Items button
    @FXML
    public void handleDisplayAll(ActionEvent event)
    {
        table.setItems(data);
        table.refresh();
    }

    //Handle Delelete An Item button
    @FXML
    public void handleDeleteAnItem(ActionEvent event)
    {
        table.setItems(data);
        table.getItems().removeAll(table.getSelectionModel().getSelectedItem());
    }

    //Handle Delelete All Items button
    @FXML
    public void handleDeleteAll(ActionEvent event)
    {
        table.setItems(data);
        table.getItems().removeAll(data);
    }

    //Create new task data
    public void addData(String description, LocalDate dt, boolean status)
    {
        data.add(new items(description, dt, status));
    }

    //Validation check for task Description
    public boolean checkDescription(String str)
    {
        if(str.isEmpty())
            return false;
        else if(str.length() > 256)
            return false;
        else
            return true;
    }

    //Validation check for task due date
    public boolean checkDate(LocalDate dt)
    {
        if(dt == null)
            return false;
        else
        {
            if (dt.getYear() == LocalDate.now().getYear())
            {
                if (dt.getMonthValue() < 13 && dt.getMonthValue() > 0 && dt.getMonthValue() == LocalDate.now().getMonthValue())
                {
                    if (dt.getDayOfMonth() <= 31 && dt.getDayOfMonth() > 0 && dt.getDayOfMonth() >= LocalDate.now().getDayOfMonth())
                        return true;
                    else
                        return false;
                }
                else if(dt.getMonthValue() < 13 && dt.getMonthValue() > 0 && dt.getMonthValue() > LocalDate.now().getMonthValue())
                {
                    if (dt.getDayOfMonth() <= 31 && dt.getDayOfMonth() > 0)
                        return true;
                    else
                        return false;
                }
                else
                    return false;
            }
            else if (dt.getYear() > LocalDate.now().getYear())
            {
                if (dt.getMonthValue() < 13 && dt.getMonthValue() > 0)
                {
                    if (dt.getDayOfMonth() <= 31 && dt.getDayOfMonth() > 0)
                        return true;
                    else
                        return false;
                }
                else
                    return false;
            }
            else
            {
                return false;
            }
        }
    }

    //Validation check for task status
    public boolean checkStatus(String str)
    {
        if(str.compareTo("Complete") == 0 || str.compareTo("Incomplete") == 0)
            return true;
        else
            return false;
    }

    //Edit and set the new description
    public ObservableList<items> editDescription(items item, String newDescription, ObservableList<items> dataList)
    {
        if(checkDescription(newDescription))
            item.setDescription(newDescription);
        else
            warning("Please describe the task in less than 256 characters");
        return dataList;
    }

    //Edit and set the new due date
    public ObservableList<items> editDate(items item, LocalDate dt, ObservableList<items> dataList)
    {
        String msg = "Please PICK a VALID date from date picker.";
        msg += "\nPlease check your Day, Month, Year.";
        if (checkDate(dt))
            item.setDate(dt);
        else
            warning(msg);
        return dataList;
    }

    //Edit and set the new status
    public ObservableList<items> editStatus(items item, String newStatus, ObservableList<items> dataList)
    {
        if (checkStatus(newStatus))
            item.setStatus(newStatus);
        else
            warning("Please enter \"Complete\" or \"Incomplete\"");
        return dataList;
    }

    //Filter complete tasks
    public ObservableList<items> completeItem(ObservableList<items> dataList)
    {
        ObservableList<items> completeList = FXCollections.observableArrayList();
        for(items item: dataList)
        {
            if(item.getStatus().compareTo("Complete") == 0)
                completeList.add(item);
        }
        return completeList;
    }

    //Filter incomplete tasks
    public ObservableList<items> incompleteItem(ObservableList<items> dataList)
    {
        ObservableList<items> incompleteList = FXCollections.observableArrayList();
        for(items item: dataList)
        {
            if(item.getStatus().compareTo("Incomplete") == 0)
                incompleteList.add(item);
        }
        return incompleteList;
    }

    //Open a file
    public ObservableList openFile()
    {
        ObservableList<items> temp = FXCollections.observableArrayList();

        File opensFile = getFileName();
        FileReader file = null;
        try {
            file = new FileReader(opensFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(file);
        String str;
        try {
            str = bufferedReader.readLine();
            while(str != null)
            {
                String[] arr = str.split(",");
                String des = arr[0];
                String dt =  arr[1];
                String status = arr[2];
                temp.add(new items(des, dt, status));
                str = bufferedReader.readLine();
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return temp;
    }

    public File getFileName()
    {
        return fileChooser.showOpenDialog(new Stage());
    }

    public File getSaveFileName()
    {
        return fileChooser.showSaveDialog(new Stage());
    }

    //Set the content of the help window and show the window
    public void helpWindow()
    {
        File file = new File("src/main/java/ucf/assignments/AppInformation");
        FileReader fileReader;
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        StringBuilder msg = new StringBuilder();

        alert.setTitle("How to Use To-Do List App");
        alert.setHeaderText(null);

        try {
            fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String str = bufferedReader.readLine();
            while(str != null)
            {
                msg.append(str).append("\n");
                str = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        TextArea textArea = new TextArea(msg.toString());
        textArea.setWrapText(true);
        textArea.setEditable(false);

        alert.getDialogPane().setContent(textArea);
        alert.setResizable(true);
        alert.showAndWait();
    }

    //Show a warning for invalid input
    public void warning(String msg)
    {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Invalid Input");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

}
