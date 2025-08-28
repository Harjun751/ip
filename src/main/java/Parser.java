import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private final static DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy HHmm");

    public static Deadline parseDeadline(String text) {
        Pattern ptrn = Pattern.compile(" (.*) /by (.*)");
        Matcher matcher = ptrn.matcher(text);
        if (matcher.find()) {
            String description = matcher.group(1);
            String due = matcher.group(2);
            LocalDate dueDate = LocalDate.parse(
                    due,
                    FORMAT
            );
            return new Deadline(description, dueDate);
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
