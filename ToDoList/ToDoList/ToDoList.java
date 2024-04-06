package M6.ToDoList;

import java.util.Scanner;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ToDoList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Object[][] toDo = new Object[10][3];
        while (true) {
            System.out.println("Please enter a command:");
            System.out.println("Type 'help' to read documentation....");

            String command = sc.nextLine(); // Reads the next line of text from the keyboard and returns it as a string.

            if (command.equals("create")) {
                System.out.println("in the create branch...");

                System.err.println("Enter the item description:");
                String description = sc.nextLine();

                System.out.println("Enter a due date:");
                System.out.println("Year:");
                int year = sc.nextInt();
                System.out.println("Month:");
                int month = sc.nextInt();
                System.out.println("Date:");
                int date = sc.nextInt();

                Calendar dueDate = new GregorianCalendar(year, month, date);

                System.out.println("Enter the id number:");
                int id = sc.nextInt();

                Object[] object = { description, dueDate, "pending" };

                toDo[id] = object;

                System.out.println("The item has been entered!");
            }

            // list
            if (command.equals("list")) {
                System.out.println("in the list branch...");
                for (int i = 0; i < toDo.length; i++) {
                    if (toDo[i][0] != null) {
                        System.out.println("description: " + toDo[i][0]);
                        System.out.println("status: " + toDo[i][2]);
                        Calendar calendar = (Calendar) toDo[i][1];
                        System.out.println(calendar.get(Calendar.DATE) + "/" + calendar.get(Calendar.MONTH) + "/"
                                + calendar.get(Calendar.YEAR));
                    }
                }
            }

            // read
            if (command.equals("read")) {
                System.out.println("in the read branch...");

                System.out.println("Enter the item number you want to see: ");
                int id = sc.nextInt();

                System.out.println("description: " + toDo[id][0]);
                System.out.println("status: " + toDo[id][2]);
                Calendar calendar = (Calendar) toDo[id][1];
                System.out.println(calendar.get(Calendar.DATE) + "/" + calendar.get(Calendar.MONTH) + "/"
                        + calendar.get(Calendar.YEAR));

            }

            // update
            if (command.equals("update")) {
                System.out.println("in the update branch...");

                System.out.println("Enter the item number you want to see: ");
                int id = Integer.parseInt(sc.nextLine());

                System.out.println("description: " + toDo[id][0]);
                System.out.println("status: " + toDo[id][2]);
                Calendar calendar = (Calendar) toDo[id][1];
                System.out.println(calendar.get(Calendar.DATE) + "/" + calendar.get(Calendar.MONTH) + "/"
                        + calendar.get(Calendar.YEAR));

                System.out.println("Enter an item description: ");
                String description = sc.nextLine();

                System.out.println("Enter a status (completed/not completed): ");
                String status = sc.nextLine();

                System.out.println("Enter a due date:");
                System.out.println("Year:");
                int year = sc.nextInt();
                System.out.println("Month:");
                int month = sc.nextInt();
                System.out.println("Date:");
                int date = sc.nextInt();

                Calendar dueDate = new GregorianCalendar(year, month, date);
                Object[] object = { description, dueDate, status };
                toDo[id] = object;
                System.out.println("Item has been updated.");
            }

            // delete
            if (command.equals("delete")) {
                System.out.println("in the delete branch...");

                System.out.println("Enter the item number you want to see: ");
                int id = Integer.parseInt(sc.nextLine());

                System.out.println("description: " + toDo[id][0]);
                System.out.println("status: " + toDo[id][2]);
                Calendar calendar = (Calendar) toDo[id][1];
                System.out.println(calendar.get(Calendar.DATE) + "/" + calendar.get(Calendar.MONTH) + "/"
                        + calendar.get(Calendar.YEAR));

                System.out.println("delete it? yes or no: ");
                String delete = sc.nextLine();

                if (delete.equals("yes")) {
                    toDo[id][0] = null;
                    toDo[id][1] = null;
                    toDo[id][2] = null;
                    System.out.println("The itm has been deleted!");
                } else {
                    System.out.println("The item was not deleted!");
                }
            }

            // size
            if (command.equals("size")) {
                System.out.println("in the size branch...");
                System.out.println("Number of items in your list is: " + toDo.length);

                System.out.println("WARNING : Data will be lost!");
                System.out.println("Still want to resize? Continue? y/n: ");
                String delete = sc.nextLine();
                if(delete.equals("y")){
                    System.out.println("What is new size of the list? : ");
                    int size=Integer.parseInt(sc.nextLine());
                    toDo = new Object[size][3];
                    System.out.println("The list has been resized!");
                    System.out.println("Number of items in your list is: " + toDo.length);

                }else{
                    System.out.println( "Resize aborted!" );
                }
            
            }

            // restart
            if (command.equals("restart")) {
                System.out.println("in the restart branch...");
                System.out.println("WARNING : Data will be lost!");
                System.out.println("Still want to Restart? Continue? y/n: ");
                String delete = sc.nextLine();
                if(delete.equals("y")){
                    toDo = new Object[10][3];
                    System.out.println("The app has been restarted!");
                }else{
                    System.out.println( "Restart aborted!" );
                }
            }

            // exit
            if (command.equals("exit")) {
                System.out.println("the app has exited...");
                break;
            }

            // help
            if (command.equals("help")) {
                System.out.println("in the help branch...");

                System.out.println("Below is a description of the possible  commands: ");
                System.out.println("create - create a new to do list");
                System.out.println("read - read a to do list item by item number");
                System.out.println("list - list  all items in your to do list");
                System.out.println("update -  update an existing item with a new value by item number");
                System.out.println("delete - remove an item from your to do list by item number");
                System.out.println("size - resize the to do list");
                System.out.println("restart - close the application and start again");
                System.out.println("exit - end the application");
                System.err.println("help - get helpful infrmation about the commands");
            }
        }

    }
}
