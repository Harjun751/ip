package marvin.command;

import marvin.task.TaskList;

/**
 * An abstract class representing a command that Marvin can execute.
 */
public abstract class Command {
    /**
     * Performs a given action based on the concrete class.
     *
     * @param taskList The task list in which the changes should be reflected in.
     */
    public abstract void execute(TaskList taskList);

    /**
     * Returns whether the program should exit after the command is executed.
     */
    public boolean isExit() {
        return false;
    }
}
