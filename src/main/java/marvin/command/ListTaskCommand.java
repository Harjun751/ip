package marvin.command;

import marvin.Personality;
import marvin.task.TaskList;
import marvin.ui.Ui;

public class ListTaskCommand extends Command {
    @Override
    public void execute(TaskList taskList) {
        Ui.printTaskList(
                taskList,
                Personality.getTaskIntro()
        );
    }
}
