import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void addTask(ArrayList<String> task, ArrayList<String> incompleteTask) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("What task should be added:");
        String input = scanner.nextLine();
        task.add(input);
        incompleteTask.add("[incomplete]");
        System.out.println("Task added!");

    }

    public static void viewTask(ArrayList<String> task, ArrayList<String> incompleteTask) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("View all tasks");
        int taskNumber;
        for (int i = 0; i < task.size(); i++) {
            taskNumber = i + 1;
            System.out.println(taskNumber + ". " + task.get(i) + "   " + incompleteTask.get(i));
        }

    }

    public static void markCompleted(ArrayList<String> incompleteTask) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What task should be marked as completed:");
        int input = scanner.nextInt();
        incompleteTask.set((input-1), "[completed]");
        System.out.println("Task marked as completed");
    }

    public static void removeTask(ArrayList<String> task, ArrayList<String> incompleteTask) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What task should be removed:");
        int input = scanner.nextInt();
        task.remove(input-1);
        incompleteTask.remove(input-1);
        System.out.println("Task removed");
    }

    public static void printMenu() {
        System.out.println("To do list");
        System.out.println("1. Add a task");
        System.out.println("2. View all tasks");
        System.out.println("3. Mark a task as completed");
        System.out.println("4. Remove a task");
        System.out.println("5. Exit the application");
        System.out.print("Enter task number:");
    }



    public static void main(String[] args) {
        ArrayList<String> task = new ArrayList<String>();
        ArrayList<String> incompleteTask = new ArrayList<String>();

        boolean running = true;
        Scanner scanner = new Scanner(System.in);



        while (running) {

            try {
                printMenu();
                int taskNumber = scanner.nextInt();
                scanner.nextLine();
                switch (taskNumber) {
                    case 1:
                        addTask(task, incompleteTask);
                        break;
                    case 2:
                        viewTask(task, incompleteTask);
                        break;
                    case 3:
                        markCompleted(incompleteTask);
                        break;
                    case 4:
                        removeTask(task, incompleteTask);
                        break;
                    case 5:
                        running = false;
                        System.out.println("End of application");
                        break;
                    default:
                        System.out.println("Invalid task number. Please enter a task number between 1 to 5.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid user input. Please enter a value from 1 to 5.");
                scanner.nextLine();
            }
        }
    }
}