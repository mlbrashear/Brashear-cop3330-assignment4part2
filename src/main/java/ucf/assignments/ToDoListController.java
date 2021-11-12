/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Mary Brashear
 */

package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class ToDoListController {

    @FXML
    Button addButton;

    @FXML
    Button deleteButton;

    @FXML
    Button editButton;

    @FXML
    Button showCompleteButton;

    @FXML
    Button showIncompleteButton;

    @FXML
    Button markCompleteButton;

    @FXML
    Button showExistingButton;

    @FXML
    Button saveButton;

    @FXML
    Button loadButton;

    @FXML
    Button helpButton;

    @FXML
    Button clearButton;

    @FXML
    TextField dateText;

    @FXML
    TextField descriptionText;

    @FXML
    TextField itemNumberText;

    @FXML
    ListView listHolder;

    ObservableList<String> list = FXCollections.observableArrayList();
    int count = 0;
    ToDoClass l = new ToDoClass();

    @FXML
    private void addItem() { //adding an item into the list
        int check = l.correctText(dateText.getText(), descriptionText.getText());
        if(check == 1) {
            count++;
            list.add(count + " " + dateText.getText() + " " + descriptionText.getText() + " I");
            listHolder.setItems(list);
            dateText.setText("");
            descriptionText.setText("");
        }
    }

    @FXML
    private void deleteItem() { //removing an item from the list
        int temp = Integer.parseInt(itemNumberText.getText()) - 1;
        for(int i = 0; i < list.size(); i++)
            //int t = Integer.parseInt(list.get(temp).substring(0));
        list.remove(temp);
        listHolder.setItems(list);
        count--;
        itemNumberText.setText("");
    }

    @FXML
    private void clearList() { //clearing the whole list
        list.clear();
        listHolder.setItems(list);
        count = 0;
    }

    @FXML
    private void editItem() { //edit an existing item
        int check = l.correctText(dateText.getText(), descriptionText.getText());
        if(check == 1) {
            int temp = Integer.parseInt(itemNumberText.getText()) - 1;
            list.set(temp, itemNumberText.getText() + " " + dateText.getText() + " " + descriptionText.getText() + " I");
            listHolder.setItems(list);
            itemNumberText.setText("");
            dateText.setText("");
            descriptionText.setText("");
        }
    }

    @FXML
    private void completeItem() { //mark item as completed or incompleted
        int temp = Integer.parseInt(itemNumberText.getText()) - 1;
        String item;
        if(list.get(temp).contains(" I"))
            item = list.get(temp).replace(" I", " C");
        else
            item = list.get(temp).replace(" C", " I");
        list.set(temp, item);
        itemNumberText.setText("");
    }

    @FXML
    private void helpWindow() { //show help popup
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Help.fxml"));
            Parent root1 = (Parent) loader.load();
            Stage stage = new Stage();
            stage.setTitle("Help Menu");
            stage.setScene(new Scene(root1));
            stage.show();
        }
        catch (Exception e) {
            System.out.println("Cannot load new window.");
        }
    }

    @FXML
    private void showComplete() { //Show completed items
        listHolder.setItems(l.completedList(list));
    }

    @FXML
    private void showIncomplete() { //Show incompleted items
        listHolder.setItems(l.incompletedList(list));
    }

    @FXML
    private void showExisting() { //Show all items
        listHolder.setItems(list);
    }

    @FXML
    private void saveListAsFile() throws Exception{ //Create a file and save current list
        try {
            FileWriter writer = new FileWriter("src/main/java/ucf/assignments/ToDoList.txt");
            for(int i = 0; i < list.size(); i++)
                writer.write(list.get(i) + "\n");
            writer.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void loadList() throws Exception{ //load any saved list
        try {
            File loadList = new File("src/main/java/ucf/assignments/ToDoList.txt");
            if(loadList.exists()) {
                list.clear();
                Scanner sc = new Scanner(loadList);
                while(sc.hasNextLine())
                    list.add(sc.nextLine());
            }
            count = list.size();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/*
Import all necessary classes

public class ToDoListController {
    Attach all the buttons, text fields, and list views

    create an observable list
    create count int and set to 0

    @FXML
    private void addItem () { // connected to add button
        make temp int equal to the returned value of check class
        if(temp is 1) {
            increase count
            put information into observable list
            add item in list view in correct format from observable list
            make the date and description text fields blank
        }
    }

    @FXML
    private void deleteItem() { //connected to delete button
        create temp int that's 1 less than whatever number they put in the item number box
        use the .remove at the temporary spot
        use setItems
        decrease count
        make the item number text field blank
    }

    @FXML
    private void clearList() { //connected to the clear button
        clear the list
        set the list view to the list
        set count to 0
    }

    @FXML
    private void editItem() { //connected to the edit button
        make temp int equal to the returned value of check class
        if(temp is 1) {
            create temp int thats 1 less than whatever number they put in the item number box
            put information into observable list
            add item in list view in correct format from observable list
            set the date, item number, and description text fields to blank
        }
    }

    @FXML
    private void completeItem() { //connected to the complete button
        create temp int that's 1 less than whatever number they put in the item number box
        create temp string
        if(the list contains " I")
            replace " I" to " C"
        else
            replace " C" to " I"
        set the list to the two temp
        set the item number text field to blank
       }

    @FXML
    private void helpWindow() { //connected to help button
        try {
            load the Help.FXML
            set the parent root
            set the stage
            title the popup
            set the stage to the root
            show the stage
        }
        catch (Exception e) {
            System.out.println("Cannot load new window.");
        }
    }

    @FXML
    private void showComplete() { //connected to the completed button
        call to completedList class and put it in list view
    }

    @FXML
    private void showIncomplete() { //connected to the incomplete button
        call to incompletedList class and put it in list view
    }

    @FXML
    private void showExisting() { //connected to the show existing button
        show the currently existing list
    }

    @FXML
    private void saveListAsFile() throws Exception{ //connected to the save button
        try {
            open new file writer
            for(loop for however big the list is)
                write in the list
            close writer
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void loadList() throws Exception{ //connected to load button
        try {
            make a file to load tha list
            if(the file exists) {
                clear current list
                create scanner
                while(another line exists)
                    add to the list view
            }
            make count = size of list
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

 */