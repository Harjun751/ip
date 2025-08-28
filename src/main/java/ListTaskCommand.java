public class ListTaskCommand extends Command{
    @Override
    public void execute(TaskList taskList) {
        Ui.printTaskList(
                taskList,
                Personality.getTaskIntro()
        );
    }
}
