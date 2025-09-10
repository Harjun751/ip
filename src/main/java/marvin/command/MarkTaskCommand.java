package marvin.command;

import marvin.MarvinException;
import marvin.task.TaskList;
import marvin.ui.Color;
import marvin.ui.Ui;

/**
 * Contains logic for the mark task command in Marvin.
 */
public class MarkTaskCommand extends Command {
    private final boolean isDone;
    private final String locator;

    /**
     * Instantiate a mark task command.
     *
     * @param locator The string representation of where the task is.
     * @param isDone A boolean representing the state to mark the task as.
     */
    public MarkTaskCommand(String locator, boolean isDone) {
        this.isDone = isDone;
        this.locator = locator;
    }


    @Override
    public CommandResult execute(TaskList taskList) {
        String marked;
        // attempt to mark task
        try {
            marked = taskList.markTask(this.locator, this.isDone);
        } catch (ArrayIndexOutOfBoundsException e) {
            // Return error text result
            return new CommandResult(() -> Ui.printGeneric("That task doesn't exist. Just like "
                    + Color.getColoredTextString("hope", Color.RED) + "."),
            "That task doesn't exist. Just like hope."
            );
        } catch (MarvinException e) {
            // Return error text result
            return new CommandResult(() -> Ui.printGeneric(e.getMessage()),
                    e.getMessage()
            );
        }

        // Return success text
        String reply = "Fine, done.\n" + marked;
        return new CommandResult(() -> Ui.printGeneric(reply), reply);
    }
}
