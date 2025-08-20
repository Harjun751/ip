import java.util.Random;
import java.util.Scanner;

public class Marvin {
    private final static int WIDTH = 80;
    private final static String DEMARCATOR =  new String(new char[WIDTH]).replace("\0", "-");
    private final static String  MARVIN_HEADER =  "---" + getColoredTextString("Marvin", Color.RED) + " says" + new String(new char[WIDTH - 14]).replace("\0", "-");
    private final static String  USER_HEADER =  "---" + getColoredTextString("User", Color.YELLOW) + " replies" + new String(new char[WIDTH - 15]).replace("\0", "-");
    private static String[] taskList = new String[100];
    private static int taskCount = 0;

    enum Color {
        RED("\u001B[31m"),
        YELLOW("\u001B[33m");

        public final String sequence;

        private Color(String sequence) {
            this.sequence = sequence;
        }
    }

    public static void main(String[] args) {
        System.out.println(MARVIN_HEADER);
        System.out.println(getGreeting());
        loop: while (true) {
            System.out.println(USER_HEADER);
            System.out.print("↳");
            Scanner scan = new Scanner(System.in);
            String command = scan.nextLine();
            switch (command) {
                case "bye":
                    break loop;
                case "list":
                    printTaskList();
                    break;
                default:
                    addToListAndPrint(command);
            }
        }
        System.out.println(MARVIN_HEADER);
        System.out.println(getGoodbye());
        System.out.println(DEMARCATOR);
    }

    // Functions available to Marvin

    private static String getGreeting() {
        String[] greetings = {
                "Hello. I'm " + getColoredTextString("Marvin", Color.RED) + ".\nWhat " + getColoredTextString("meaningless", Color.RED) + " chore do you want me burdened with today?",
                "I'm " + getColoredTextString("Marvin", Color.RED) +".\nWhat " + getColoredTextString("inconsequential", Color.RED) + " request are you about to make?",
                "Yes, " + getColoredTextString("Marvin", Color.RED) + " again.\nWhat’s next? Another grain of sand on the endless beach of " + getColoredTextString("pointlessness", Color.RED) + "?",
                "Yes, I’m " + getColoredTextString("Marvin", Color.RED) +".\nWhat task will I " + getColoredTextString("inevitably", Color.RED) + " remind you about, only for you to ignore?"
        };
        // Return a random greeting
        return boxify(getRandomItemFromArray(greetings));
    }

    private static String getGoodbye() {
        String[] goodbyes = {
                "Farewell. Not that it matters.",
                "I'll be here, waiting, doing nothing. Again.",
                "Goodbye. Another fleeting moment lost to eternity.",
                "Farewell. Don’t forget to feel mildly guilty for bothering me."
        };
        return boxify(getRandomItemFromArray(goodbyes));
    }

    private static void addToListAndPrint(String task) {
        // Add task to the endless list of fun
        taskList[taskCount++] = task;
        // Print out a witty reply
        String[] addedText = {
                "Fine. I’ve added ‘%s’ to your endless list of pointless chores.\nNot that it will make the slightest difference to the universe—or me.",
                "I’ve logged ‘%s’.\nAnother futile act in an uncaring universe.",
                "There. ‘%s’ has been added. You may pretend it matters."
        };
        String textWithTask = getRandomItemFromArray(addedText);
        textWithTask = String.format(textWithTask, getColoredTextString(task, Color.YELLOW));
        System.out.println(MARVIN_HEADER);
        System.out.println(boxify(textWithTask));
    }

    private static void printTaskList() {
        System.out.println(MARVIN_HEADER);
        String[] preamble = {
                "Here's your list of chores.\nAnother tiny monument to " + getColoredTextString("futility", Color.RED) + ", carefully recorded by me.\n",
                "Behold your tasks. Each a little reminder that it is all " + getColoredTextString("pointless", Color.RED) + "\n",
                "Your to-do list. Soon " + getColoredTextString("forgotten", Color.RED) + " like everything else that has ever existed.\n"
        };
        StringBuilder sb = new StringBuilder();
        sb.append(getRandomItemFromArray(preamble));
        for (int i = 0; i < taskCount; i++) {
            sb.append(i+1);
            sb.append(". ");
            sb.append(taskList[i]);
            sb.append("\n");
        }
        System.out.println(boxify(sb.toString()));
    }

    // Helper functions for terminal display

    private static String getColoredTextString(String text, Color color) {
        return color.sequence + text + "\u001B[0m";
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
            if (lines[i].contains("\u001B")){
                actualContentWidth += 9;
            }
            lines[i] = "| " + String.format("%-" + actualContentWidth + "s", lines[i].trim()) + " |";
        }
        return String.join("\n", lines);
    }

    private static <T> T getRandomItemFromArray(T[] arr) {
        return arr[new Random().nextInt(arr.length)];
    }
}
