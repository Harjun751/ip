package duke.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    private LocalDateTime from;
    private LocalDateTime to;

    public Event(String description, LocalDateTime from, LocalDateTime to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        // Construct string based on description and status
        String mark;
        if (this.getDone())
            mark = "X";
        else
            mark = " ";
        return String.format("[E][%s] %s (from: %s to: %s)", mark, this.getDescription(),
                this.from.format(DateTimeFormatter.ofPattern(
                        "dd-MM-yyyy, ha"
                )),
                this.to.format(DateTimeFormatter.ofPattern(
                        "dd-MM-yyyy, ha"
                ))
        );
    }
}
