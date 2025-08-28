package duke.ui;

public enum Color {
    RED("\u001B[31m"),
    YELLOW("\u001B[33m");

    public final String sequence;

    Color(String sequence) {
        this.sequence = sequence;
    }

    public static String getColoredTextString(String text, Color color) {
        return color.sequence + text + "\u001B[0m";
    }
}
