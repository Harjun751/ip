package duke.command;

import duke.Personality;
import duke.task.TaskList;
import duke.ui.Ui;

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
