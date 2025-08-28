public abstract class Command {
    public abstract void execute(TaskList taskList);
    public boolean isExit() { return false; }
}