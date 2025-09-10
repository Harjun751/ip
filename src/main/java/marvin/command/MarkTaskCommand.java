package marvin.command;

import marvin.task.TaskList;
import marvin.ui.Color;
import marvin.ui.Ui;

/**
 * Contains logic for the mark task command in Marvin.
 */
public class MarkTaskCommand extends Command {
    private final boolean isDone;
    private final int index;

    /**
     * Instantiate a mark task command.
     *
     * @param index  The index of the task to be marked.
     * @param isDone A boolean representing the state to mark the task as.
     */
    public MarkTaskCommand(int index, boolean isDone) {
        this.isDone = isDone;
        this.index = index;
    }


    @Override
    public CommandResult execute(TaskList taskList) {
        String marked;
        // attempt to mark task
        try {
            marked = taskList.markTask(this.index, this.isDone);
        } catch (ArrayIndexOutOfBoundsException e) {
            // Return error text result
            return new CommandResult(() -> Ui.printGeneric("That task doesn't exist. Just like "
                    + Color.getColoredTextString("hope", Color.RED) + "."),
            "That task doesn't exist. Just like hope."
            );
        }

        // Return success text
        String reply = "Fine, done.\n" + marked;
        return new CommandResult(() -> Ui.printGeneric(reply), reply);
    }
}
