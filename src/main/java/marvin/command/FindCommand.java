package marvin.command;

import marvin.Personality;
import marvin.task.TaskList;
import marvin.ui.Ui;

public class FindCommand extends Command {
    private String query;

    public FindCommand(String query) {
        this.query = query;
    }
    @Override
    public void execute(TaskList taskList) {
            String found = taskList.searchTasks(this.query);
        Ui.printGeneric(
                Personality.getFoundItemText()
                        + "\n" + found
        );
    }
}
