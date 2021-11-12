/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Mary Brashear
 */

package ucf.assignments;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ToDoClass {
    public static int correctText (String date, String desc) { //check if the entered data is in correct format
        if(date.matches("\\d{4}-\\d{2}-\\d{2}") && !desc.equals(""))
            return 1;
        else
            return 0;
    }

    public static ObservableList<String> completedList(ObservableList<String> list) { //only show completed items
        ObservableList<String> temp = FXCollections.observableArrayList();
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).contains(" C"))
                temp.add(list.get(i));
        }
        return temp;
    }

    public static ObservableList<String> incompletedList(ObservableList<String> list) { //only show incompleted items
        ObservableList<String> temp = FXCollections.observableArrayList();
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).contains(" I"))
                temp.add(list.get(i));
        }
        return temp;
    }
}

/*
import all necessary classes

public class ToDoClass {
    public static int correctText (String date, String description) {
        if(date is in correct format and the description isnt empty)
            return 1
        else
            return 0
    }

    public static ObservableList<String> completedList(ObservableList<String> list) {
        create temporary observable list
        for(loop for list size) {
            if(list contains " C")
                add spot into list
        }
        return temp;
    }

    public static ObservableList<String> incompletedList(ObservableList<String> list) {
        create temporary observable list
        for(loop for list size) {
            if(list contains " I")
                add spot into list
        }
        return temp;
    }

}
 */
