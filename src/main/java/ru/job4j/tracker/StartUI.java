package ru.job4j.tracker;
import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item iTest = new Item();
        Tracker tracker = new Tracker();
        tracker.add(iTest);
        System.out.println(tracker.findById(iTest.getId()));
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        //System.out.println(iTest.getTime().format(formatter));
        //System.out.println(iTest);
    }
}

