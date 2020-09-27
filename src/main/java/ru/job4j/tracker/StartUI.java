import ru.job4j.tracker.Item;
import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item iTest = new Item();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        System.out.println(iTest.getTime().format(formatter));
    }
}

