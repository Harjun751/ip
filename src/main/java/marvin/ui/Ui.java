package marvin.ui;

import java.util.Scanner;

import marvin.task.TaskList;

public class Ui {
    private final static int WIDTH = 80;
    private final static String DEMARCATOR = new String(new char[WIDTH]).replace("\0", "-");
    private final static String MARVIN_HEADER =
            String.format("---%s says %s", Color.getColoredTextString("Marvin", Color.RED),
                    new String(new char[WIDTH - 14]).replace("\0", "-"));
    private final static String USER_HEADER =
            String.format("---%s replies %s", Color.getColoredTextString("User", Color.YELLOW),
                    new String(new char[WIDTH - 15]).replace("\0", "-"));

    public static String readCommand(Scanner sc) {
        return sc.nextLine();
    }

    public static void printGreeting(String greeting) {
        System.out.println(MARVIN_HEADER);
        System.out.println(boxify(greeting));
        System.out.println(USER_HEADER);
        System.out.print("↳");
    }


    public static void printTaskList(TaskList taskList, String preamble) {
        System.out.println(MARVIN_HEADER);
        System.out.println(Ui.boxify(preamble + taskList));
    }

    public static void printGoodbye(String goodbye) {
        System.out.println(MARVIN_HEADER);
        System.out.println(boxify(goodbye));
        System.out.println(DEMARCATOR);
    }

    public static void printGeneric(String text) {
        System.out.println(MARVIN_HEADER);
        System.out.println(boxify(text));
    }

    public static void printUserInput() {
        System.out.println(USER_HEADER);
        System.out.print("↳");
    }


    private static String boxify(String input) {
        // split string by \ns
        String[] lines = input.split("\n");
        int contentWidth = WIDTH - 4;
        for (int i = 0; i < lines.length; i++) {
            int actualContentWidth = contentWidth;
            // Java doesn't count non-visible characters in the string format
            // Therefore we manually add content width to account for non-visible characters
            // This will work as long as each line strictly has max 1 color sequence.
            if (lines[i].contains("\u001B")) {
                actualContentWidth += 9;
            }
            lines[i] = "| " + String.format("%-" + actualContentWidth + "s", lines[i].trim()) + " |";
        }
        return String.join("\n", lines);
    }
}
