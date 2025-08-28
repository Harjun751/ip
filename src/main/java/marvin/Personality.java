package marvin;

import marvin.ui.Color;

import java.util.Random;

public class Personality {

    /**
     * Returns a random, string from Marvin to introduce the list of tasks.
     */
    public static String getTaskIntro(){
        String[] taskIntro = {
                "Here's your list of chores.\nAnother tiny monument to " + Color.getColoredTextString("futility", Color.RED) + ", carefully recorded by me.\n",
                "Behold your tasks. Each a little reminder that it is all " + Color.getColoredTextString("pointless", Color.RED) + "\n",
                "Your to-do list. Soon " + Color.getColoredTextString("forgotten", Color.RED) + " like everything else that has ever existed.\n"
        };
        return getRandomItemFromArray(taskIntro);
    }

    /**
     * Returns a random greeting from Marvin
     */
    public static String getGreeting() {
        String[] greetings = {
                "Hello. I'm " + Color.getColoredTextString("Marvin", Color.RED) + ".\nWhat " + Color.getColoredTextString("meaningless", Color.RED) + " chore do you want me burdened with today?",
                "I'm " + Color.getColoredTextString("Marvin", Color.RED) +".\nWhat " + Color.getColoredTextString("inconsequential", Color.RED) + " request are you about to make?",
                "Yes, " + Color.getColoredTextString("Marvin", Color.RED) + " again.\nWhat’s next? Another grain of sand on the endless beach of " + Color.getColoredTextString("pointlessness", Color.RED) + "?",
                "Yes, I’m " + Color.getColoredTextString("Marvin", Color.RED) +".\nWhat task will I " + Color.getColoredTextString("inevitably", Color.RED) + " remind you about, only for you to ignore?"
        };
        return getRandomItemFromArray(greetings);
    }

    /**
     * Returns a random goodbye from Marvin
     */
    public static String getGoodbye() {
        String[] goodbyes = {
                "Farewell. Not that it matters.",
                "I'll be here, waiting, doing nothing. Again.",
                "Goodbye. Another fleeting moment lost to eternity.",
                "Farewell. Don’t forget to feel mildly guilty for bothering me."
        };
        return getRandomItemFromArray(goodbyes);
    }

    /**
     * Returns a random, personalized string from Marvin.
     * Tells the user that a specific item was added to the list.
     */
    public static String getItemAddedText(String taskDesc) {
        String[] addedText = {
                "Fine. I’ve added ‘%s’ to your endless list of pointless chores.\nNot that it will make the slightest difference to the universe—or me.",
                "I’ve logged ‘%s’.\nAnother futile act in an uncaring universe.",
                "There. ‘%s’ has been added. You may pretend it matters."
        };
        return String.format(getRandomItemFromArray(addedText), Color.getColoredTextString(taskDesc, Color.YELLOW));
    }

    /**
     * Returns a string from Marvin telling the user that the format was wrong
     *
     * @param correctFormat The correct format to use the command.
     */
    public static String getInvalidFormatText(String correctFormat) {
        return "Sigh. Use the following format instead:\n" + correctFormat;
    }

    public static String getFoundItemText() {
        String[] foundItemText = {
                "I've dredged through your list. Here.",
                "These are the matches. Another hollow task in an empty universe.",
                "Why do I even bother. Here:"
        };
        return getRandomItemFromArray(foundItemText);
    }



    private static <T> T getRandomItemFromArray(T[] arr) {
        return arr[new Random(1).nextInt(arr.length)];
    }
}
