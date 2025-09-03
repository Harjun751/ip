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
    public CommandResult execute(TaskList taskList) {
        taskList.addToList(this.task);
        String postamble = "\nYou have " + taskList.getCount() + " task(s) in the list.";
        return new CommandResult(() -> Ui.printGeneric(Personality.getItemAddedText(task.getDescription())
                + postamble),
                // use the colorless version for GUI
                Personality.getItemAddedTextColorless(task.getDescription()) + postamble
        );
    }
}
