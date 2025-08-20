import java.util.Random;

public class Marvin {
    private final static String demarcator =  "-----------------";

    public static void main(String[] args) {
        System.out.println(demarcator);
        System.out.println(getGreeting());
        System.out.println(demarcator);
        System.out.println(getGoodbye());
        System.out.println(demarcator);
    }

    private static String getGreeting() {
        String[] greetings = {
                "Hello. I'm " + getColoredTextString("Marvin") + ".\nWhat " + getColoredTextString("meaningless") + " chore do you want me burdened with today?",
                "I'm " + getColoredTextString("Marvin") +".\nWhat " + getColoredTextString("inconsequential") + " request are you about to make?",
                "Yes, " + getColoredTextString("Marvin") + " again.\nWhat’s next? Another grain of sand on the endless beach of " + getColoredTextString("pointlessness") + "?",
                "Yes, I’m " + getColoredTextString("Marvin") +".\nWhat task will I " + getColoredTextString("inevitably") + " remind you about, only for you to ignore?"
        };
        // Return a random greeting
        return greetings[new Random().nextInt(greetings.length)];
    }

    private static String getGoodbye() {
        String[] goodbyes = {
                "Farewell. Not that it matters.",
                "I'll be here, waiting, doing nothing. Again.",
                "Goodbye. Another fleeting moment lost to eternity.",
                "Farewell. Don’t forget to feel mildly guilty for bothering me."
        };
        return goodbyes[new Random().nextInt(goodbyes.length)];
    }

    private static String getColoredTextString(String text) {
        return "\u001B[31m" + text + "\u001B[0m";
    }
}
