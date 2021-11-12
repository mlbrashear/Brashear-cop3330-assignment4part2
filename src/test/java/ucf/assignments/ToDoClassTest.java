package ucf.assignments;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToDoClassTest {

    @Test
    void correctText() {
        assertEquals(1, ToDoClass.correctText("2021-25-12", "Christmas Day"));
        assertEquals(0, ToDoClass.correctText("12/25/2021", "Christmas Day"));
        assertEquals(0, ToDoClass.correctText("2021-25-12", ""));
        assertEquals(0, ToDoClass.correctText("12/25/2021", ""));
    }

    @Test
    void completedList() {
        ObservableList<String> one = FXCollections.observableArrayList();
        ObservableList<String> two = FXCollections.observableArrayList();
        one.add("1 2021-25-12 Christmas Day C");
        one.add("2 2022-01-01 New Years Day I");
        two.add("1 2021-25-12 Christmas Day C");
        assertEquals(two, ToDoClass.completedList(one));
    }

    @Test
    void incompletedList() {
        ObservableList<String> one = FXCollections.observableArrayList();
        ObservableList<String> two = FXCollections.observableArrayList();
        one.add("1 2021-25-12 Christmas Day I");
        one.add("2 2022-01-01 New Years Day C");
        two.add("1 2021-25-12 Christmas Day I");
        assertEquals(two, ToDoClass.incompletedList(one));
    }
}