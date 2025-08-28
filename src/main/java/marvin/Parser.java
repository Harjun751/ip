package marvin;

import marvin.command.*;
import marvin.task.Deadline;
import marvin.task.Event;
import marvin.task.Todo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private final static DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy HHmm");

    public static Command parse(String command){
        String initial = command.split(" ")[0];
        return switch (initial) {
            case "bye" -> new ExitCommand();
            case "list" -> new ListTaskCommand();
            case "deadline" -> new AddTaskCommand(
                    parseDeadline(command)
            );
            case "event" -> new AddTaskCommand(
                    parseEvent(command)
            );
            case "todo" -> new AddTaskCommand(
                    parseTodo(command)
            );
            case "mark", "unmark" -> parseMarkTask(command);
            case "delete" -> parseDeleteCommand(command);
            default -> new UnknownCommand();
        };
    }

    private static DeleteTaskCommand parseDeleteCommand(String command){
        String[] parts = command.split(" ");
        if (parts.length < 2) {
            throw new MarvinException(
                    Personality.getInvalidFormatText("delete [index]")
            );
        }
        int index;
        try{
            index = Integer.parseInt(parts[1]);
        } catch (NumberFormatException e){
            throw new MarvinException(
                    Personality.getInvalidFormatText("delete [index]")
            );
        }
        return new DeleteTaskCommand(index - 1);
    }

    private static MarkTaskCommand parseMarkTask(String command) {
        String[] parts = command.split(" ");
        if (parts.length < 2) {
            throw new MarvinException(
                Personality.getInvalidFormatText(
                        "mark/unmark [index]"
                )
            );
        }
        boolean isMark = parts[0].equalsIgnoreCase("mark");
        int index;
        try{
            index = Integer.parseInt(parts[1]);
        } catch (NumberFormatException e){
            throw new MarvinException(
                    Personality.getInvalidFormatText(
                            "mark/unmark [index]"
                    )
            );
        }
        return new MarkTaskCommand(index - 1, isMark);
    }

    private static Todo parseTodo(String text){
        String[] parts = text.split(" ");
        if (parts.length < 2) {
            throw new MarvinException(
                    Personality.getInvalidFormatText(
                            "todo [name]"
                    )
            );
        } else {
            String[] nameArr = Arrays.stream(parts, 1, parts.length)
                    .toArray(String[]::new);
            String name = String.join(" ", nameArr);
            return new Todo(name);
        }
    }

    private static Deadline parseDeadline(String text) {
        Pattern ptrn = Pattern.compile(" (.*) /by (.*)");
        Matcher matcher = ptrn.matcher(text);
        try {
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
        } catch (DateTimeParseException | IllegalStateException e) {
            throw new MarvinException(
                    Personality.getInvalidFormatText("deadline [name] /by dd/MM/yyyy hhmm")
            );
        }
    }

    private static Event parseEvent(String text) {
        Pattern ptrn = Pattern.compile(" (.*) /from (.*) /to (.*)");
        Matcher matcher = ptrn.matcher(text);
        try {
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
        } catch (DateTimeParseException | IllegalStateException e) {
        throw new MarvinException(
                Personality.getInvalidFormatText("event [name] /from dd/MM/yyyy hhmm /to dd/MM/yyyy hhmm")
        );
    }
    }
}
