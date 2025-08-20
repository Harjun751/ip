import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    public static Deadline parseDeadline(String text) {
        Pattern ptrn = Pattern.compile(" (.*) /by (.*)");
        Matcher matcher = ptrn.matcher(text);
        if (matcher.find()) {
            String description = matcher.group(1);
            String due = matcher.group(2);

            return new Deadline(description, due);
        } else {
            throw new IllegalStateException();
        }
    }

    public static Event parseEvent(String text) {
        Pattern ptrn = Pattern.compile(" (.*) /from (.*) /to (.*)");
        Matcher matcher = ptrn.matcher(text);
        if (matcher.find()) {
            String description = matcher.group(1);
            String from = matcher.group(2);
            String to = matcher.group(3);
            return new Event(description, from, to);
        } else {
            throw new IllegalStateException();
        }
    }
}
