public class Event extends Task {
    private String from;
    private String to;

    public Event(String description, String from, String to) {
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
        return String.format("[E][%s] %s (from: %s to: %s)", mark, this.getDescription(), this.from, this.to);
    }
}
