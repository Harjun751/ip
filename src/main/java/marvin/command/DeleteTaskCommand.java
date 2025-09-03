package marvin.command;

import marvin.task.TaskList;
import marvin.ui.Color;
import marvin.ui.Ui;

/**
 * Contains logic for the delete command in Marvin.
 */
public class DeleteTaskCommand extends Command {
    private final int index;

    /**
     * Instantiate a delete task command.
     *
     * @param index The index of the task to be deleted.
     */
    public DeleteTaskCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList taskList) {
        try {
            String oldTask = taskList.removeTask(index);
            Ui.printGeneric("I've removed the task.\n" + oldTask + "\nNow you have " + taskList.getCount()
                    + " tasks and absolutely nothing will change.");
        } catch (ArrayIndexOutOfBoundsException e) {
            Ui.printGeneric("That task doesn't exist. Just like "
                    + Color.getColoredTextString("hope", Color.RED) + ".");
        }
    }
}
