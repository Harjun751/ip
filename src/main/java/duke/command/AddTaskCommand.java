package duke.command;

import duke.Personality;
import duke.task.Task;
import duke.task.TaskList;
import duke.ui.Ui;

public class AddTaskCommand extends Command {
    private final Task task;

    public AddTaskCommand(Task task) {
        this.task = task;
    }
    @Override
    public void execute(TaskList taskList) {
        taskList.addToList(this.task);

        Ui.printGeneric(
                Personality.getItemAddedText(task.getDescription()) +
                        "\nYou have " + taskList.getCount() + " task(s) in the list."
        );
    }
}
