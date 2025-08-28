public class UnknownCommand extends Command{
    @Override
    public void execute(TaskList taskList) {
        Ui.printGeneric("I don’t recognize that command. Not that it would have mattered if I did.");
    }
}
