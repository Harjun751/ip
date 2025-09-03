package marvin.command;

import marvin.Personality;
import marvin.task.Task;
import marvin.task.TaskList;
import marvin.ui.Ui;

/**
 * Contains logic for the Add Task command in Marvin.
 */
public class AddTaskCommand extends Command {
    private final Task task;

    /**
     * Instantiate the AddTaskCommand with the task to be added to the list.
     */
    public AddTaskCommand(Task task) {
        this.task = task;
    }

    @Override
    public void execute(TaskList taskList) {
        taskList.addToList(this.task);

        Ui.printGeneric(Personality.getItemAddedText(task.getDescription()) + "\nYou have " + taskList.getCount()
                + " task(s) in the list.");
    }
}
