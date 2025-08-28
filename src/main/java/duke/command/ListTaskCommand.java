package duke.command;

import duke.Personality;
import duke.task.TaskList;
import duke.ui.Ui;

public class ListTaskCommand extends Command {
    @Override
    public void execute(TaskList taskList) {
        Ui.printTaskList(
                taskList,
                Personality.getTaskIntro()
        );
    }
}
