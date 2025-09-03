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
     * @param index The index of the task to be marked.
     * @param isDone A boolean representing the state to mark the task as.
     */
    public MarkTaskCommand(int index, boolean isDone) {
        this.isDone = isDone;
        this.index = index;
    }


    @Override
    public void execute(TaskList taskList) {
        try {
            String marked = taskList.markTask(this.index, this.isDone);
            Ui.printGeneric("Fine, done.\n" + marked);
        } catch (ArrayIndexOutOfBoundsException e) {
            Ui.printGeneric("That task doesn't exist. Just like "
                    + Color.getColoredTextString("hope", Color.RED) + ".");
        }
    }
}
