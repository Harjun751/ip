package marvin.command;

import marvin.task.TaskList;
import marvin.ui.Color;
import marvin.ui.Ui;

/**
 * Contains logic for the delete command in Marvin.
 */
public class DeleteTaskCommand extends Command {
    private final String locator;

    /**
     * Instantiate a delete task command.
     *
     * @param locator The string representation of where the task to be deleted is.
     */
    public DeleteTaskCommand(String locator) {
        this.locator = locator;
    }

    @Override
    public CommandResult execute(TaskList taskList) {
        // Remove the old task from the list
        String oldTask;
        try {
            oldTask = taskList.removeTask(locator);
        } catch (ArrayIndexOutOfBoundsException e) {
            // Return invalid text if out of bounds
            return new CommandResult(() -> Ui.printGeneric("That task doesn't exist. Just like "
                            + Color.getColoredTextString("hope", Color.RED) + "."),
                    "That task doesn't exist. Just like hope."
            );
        }

        // Return the removed text
        String reply = "I've removed the task.\n" + oldTask + "\nNow you have " + taskList.getCount()
                + " tasks and absolutely nothing will change.";
        return new CommandResult(() -> Ui.printGeneric(reply), reply);
    }
}
