package marvin.command;

import marvin.Personality;
import marvin.task.TaskList;
import marvin.ui.Ui;

public class ExitCommand extends Command {
    @Override
    public void execute(TaskList taskList) {
        Ui.printGoodbye(Personality.getGoodbye());
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
