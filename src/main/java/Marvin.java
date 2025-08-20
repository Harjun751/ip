import java.util.Random;
import java.util.Scanner;

public class Marvin {
    private final static int WIDTH = 80;
    private final static String DEMARCATOR =  new String(new char[WIDTH]).replace("\0", "-");
    private final static String  MARVIN_HEADER =  "---" + getColoredTextString("Marvin", Color.RED) + " says" + new String(new char[WIDTH - 14]).replace("\0", "-");
    private final static String  USER_HEADER =  "---" + getColoredTextString("User", Color.YELLOW) + " replies" + new String(new char[WIDTH - 15]).replace("\0", "-");

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
            String command = scan.next();
            switch (command) {
                case "bye":
                    break loop;
                default:
                    System.out.println(MARVIN_HEADER);
                    System.out.println(boxify(command));
            }
        }
        System.out.println(MARVIN_HEADER);
        System.out.println(getGoodbye());
        System.out.println(DEMARCATOR);
    }

    private static String getGreeting() {
        String[] greetings = {
                "Hello. I'm " + getColoredTextString("Marvin", Color.RED) + ".\nWhat " + getColoredTextString("meaningless", Color.RED) + " chore do you want me burdened with today?",
                "I'm " + getColoredTextString("Marvin", Color.RED) +".\nWhat " + getColoredTextString("inconsequential", Color.RED) + " request are you about to make?",
                "Yes, " + getColoredTextString("Marvin", Color.RED) + " again.\nWhat’s next? Another grain of sand on the endless beach of " + getColoredTextString("pointlessness", Color.RED) + "?",
                "Yes, I’m " + getColoredTextString("Marvin", Color.RED) +".\nWhat task will I " + getColoredTextString("inevitably", Color.RED) + " remind you about, only for you to ignore?"
        };
        // Return a random greeting
        return boxify(greetings[new Random().nextInt(greetings.length)]);
    }

    private static String getGoodbye() {
        String[] goodbyes = {
                "Farewell. Not that it matters.",
                "I'll be here, waiting, doing nothing. Again.",
                "Goodbye. Another fleeting moment lost to eternity.",
                "Farewell. Don’t forget to feel mildly guilty for bothering me."
        };
        return boxify(goodbyes[new Random().nextInt(goodbyes.length)]);
    }

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
}
