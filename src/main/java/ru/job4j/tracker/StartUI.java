package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.parseInt(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
                /*            } else if (...) { */
                /*             Добавить остальные действия системы по меню. */
            } else if (select == 1) {
                Item[] items = tracker.findAll();
                for (Item item : items) {
                    System.out.println(item);
                }
            } else if (select == 2) {
                System.out.print("Enter id: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                if (tracker.replace(id, item)) {
                    System.out.println("Замена произведена успешно.");
                } else {
                    System.out.println("Ошибка.");
                }
            } else if (select == 3) {
                System.out.print("Enter id: ");
                int id = Integer.parseInt(scanner.nextLine());
                if (tracker.delete(id)) {
                    System.out.println("Удаление произведено успешно.");
                } else {
                    System.out.println("Ошибка.");
                }
            } else if (select == 4) {
                System.out.print("Enter id: ");
                int id = Integer.parseInt(scanner.nextLine());
                Item found = tracker.findById(id);
                if (found != null) {
                    System.out.println("Заявка найдена.");
                    System.out.println(found);
                } else {
                    System.out.println("Заявка с таким id не найдена.");
                }
            } else if (select == 5) {
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item[] found = tracker.findByName(name);
                if (found.length > 0) {
                    for (Item item : found) {
                        System.out.println(item);
                    }
                } else { System.out.println("Заявки с таким именем не найдены."); }
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        /* добавить остальные пункты меню. */
        System.out.println(
                "0. Add new Item\n" +
                "1. Show all items\n" +
                "2. Edit item\n" +
                "3. Delete item\n" +
                "4. Find item by Id\n" +
                "5. Find items by name\n" +
                "6. Exit Program");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}


