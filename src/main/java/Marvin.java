import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Marvin {

    private static TaskList taskList = StorageHandler.loadTaskList();

    public static void main(String[] args) {
        Ui.printGreeting(Personality.getGreeting());
        Scanner scan = new Scanner(System.in);
        loop: while(scan.hasNext()) {
            String command = scan.next();
            switch (command) {
                case "bye":
                    break loop;
                case "list":
                    Ui.printTaskList(
                            taskList,
                            Personality.getTaskIntro()
                    );
                    break;
                case "deadline":
                    try {
                        // pass the rest of the line into the parser
                        Deadline d = Parser.parseDeadline(scan.nextLine());
                        addToListAndPrint(d);
                        StorageHandler.storeTaskList(Marvin.taskList);
                    } catch (Exception ignored) {
                        Ui.printGeneric("Sigh. Follow the format deadline [name] /by [time]\nNot like it matters, anyway.");
                    }
                    break;
                case "event":
                    try {
                        // pass the rest of the line into the parser
                        Event e = Parser.parseEvent(scan.nextLine());
                        addToListAndPrint(e);
                        StorageHandler.storeTaskList(Marvin.taskList);
                    } catch (Exception ignored) {
                        Ui.printGeneric("Sigh. Follow the format event [name] /from [time] /to [time]\n Or don't, whatever.");
                    }
                    break;
                case "todo":
                    String input = scan.nextLine().trim();
                    if (input.isEmpty()){
                        Ui.printGeneric("Sigh. Follow the format todo [name].");
                    } else {
                        Todo t = new Todo(input);
                        addToListAndPrint(t);
                        StorageHandler.storeTaskList(Marvin.taskList);
                    }
                    break;
                case "delete":
                    try {
                        int index = scan.nextInt();
                        // mark tasked based on command input
                        String old = taskList.removeTask(index - 1);
                        Ui.printGeneric("I've removed the task.\n" + old + "\nNow you have " + taskList.getCount() +
                                " tasks and absolutely nothing will change.");
                        StorageHandler.storeTaskList(Marvin.taskList);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        Ui.printGeneric("That task doesn't exist. Just like " + Color.getColoredTextString("hope", Color.RED) + ".");
                    } catch (InputMismatchException ignored) {
                        Ui.printGeneric("You need a number to delete. Sigh.");
                    }
                    break;
                case "mark":
                case "unmark":
                    try {
                        int index = scan.nextInt();
                        // mark tasked based on command input
                        String marked = taskList.markTask(index - 1, command.equals("mark"));
                        Ui.printGeneric("Fine, done.\n" + marked);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        Ui.printGeneric("That task doesn't exist. Just like " + Color.getColoredTextString("hope", Color.RED) + ".");
                    } catch (InputMismatchException ignored) {
                        // let case fall through to default
                        Ui.printGeneric("You need a number to mark/unmark. Sigh.");
                    }
                    StorageHandler.storeTaskList(Marvin.taskList);
                    break;
                default:
                    Ui.printGeneric("I don’t recognize that command. Not that it would have mattered if I did.");
            }
            Ui.printUserInput();
        };
        Ui.printGoodbye(Personality.getGoodbye());
    }

    private static void addToListAndPrint(Task task) {
        // Add task to the endless list of fun
        taskList.addToList(task);
        // Print out a witty reply
        String textWithTask = Personality.getItemAddedText();
        textWithTask = String.format(textWithTask, Color.getColoredTextString(task.getDescription(), Color.YELLOW));
        textWithTask += "\nYou have " + taskList.getCount() + " task(s) in the list.";
        Ui.printGeneric(textWithTask);
    }

}
