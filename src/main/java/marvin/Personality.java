package marvin;

import java.util.Random;

import marvin.ui.Color;

public class Personality {

    public static String getTaskIntro() {
        String[] taskIntro = {
                "Here's your list of chores.\nAnother tiny monument to "
                        + Color.getColoredTextString("futility",Color.RED)
                        + ", carefully recorded by me.\n",
                "Behold your tasks. Each a little reminder that it is all "
                        + Color.getColoredTextString("pointless", Color.RED) + "\n",
                "Your to-do list. Soon " + Color.getColoredTextString("forgotten", Color.RED)
                        + " like everything else that has ever existed.\n"
        };
        return getRandomItemFromArray(taskIntro);
    }

    public static String getGreeting() {
        String[] greetings = {
                "Hello. I'm " + Color.getColoredTextString("Marvin", Color.RED) + ".\nWhat "
                        + Color.getColoredTextString("meaningless", Color.RED)
                        + " chore do you want me burdened with today?",
                "I'm " + Color.getColoredTextString("Marvin", Color.RED) + ".\nWhat "
                        + Color.getColoredTextString("inconsequential", Color.RED)
                        + " request are you about to make?",
                "Yes, " + Color.getColoredTextString("Marvin", Color.RED)
                        + " again.\nWhat’s next? Another grain of sand on the endless beach of "
                        + Color.getColoredTextString("pointlessness", Color.RED) + "?",
                "Yes, I’m " + Color.getColoredTextString("Marvin", Color.RED) + ".\nWhat task will I "
                        + Color.getColoredTextString("inevitably", Color.RED)
                        + " remind you about, only for you to ignore?"
        };
        return getRandomItemFromArray(greetings);
    }

    public static String getGoodbye() {
        String[] goodbyes = {
                "Farewell. Not that it matters.",
                "I'll be here, waiting, doing nothing. Again.",
                "Goodbye. Another fleeting moment lost to eternity.",
                "Farewell. Don’t forget to feel mildly guilty for bothering me."
        };
        return getRandomItemFromArray(goodbyes);
    }

    public static String getItemAddedText(String taskDesc) {
        String[] addedText = {
                "Fine. I’ve added ‘%s’ to your endless list of pointless chores.\nNot that it will make the slightest"
                        + " difference to the universe—or me.",
                "I’ve logged ‘%s’.\nAnother futile act in an uncaring universe.",
                "There. ‘%s’ has been added. You may pretend it matters."
        };
        return String.format(getRandomItemFromArray(addedText), Color.getColoredTextString(taskDesc, Color.YELLOW));
    }

    public static String getInvalidFormatText(String correctFormat) {
        return "Sigh. Use the following format instead:\n" + correctFormat;
    }


    private static <T> T getRandomItemFromArray(T[] arr) {
        return arr[new Random(1).nextInt(arr.length)];
    }
}
