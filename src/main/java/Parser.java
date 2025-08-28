import java.time.LocalDate;
import java.time.LocalDateTime;
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
            LocalDateTime dueDate = LocalDateTime.parse(
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
            LocalDateTime fromDate = LocalDateTime.parse(
                    from,
                    FORMAT
            );
            String to = matcher.group(3);
            LocalDateTime toDate = LocalDateTime.parse(
                    to,
                    FORMAT
            );
            return new Event(description, fromDate, toDate);
        } else {
            throw new IllegalStateException();
        }
    }
}
