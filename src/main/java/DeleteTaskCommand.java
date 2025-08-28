public class DeleteTaskCommand extends Command {
    private int index;

    public DeleteTaskCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList taskList) {
        try {
            String old = taskList.removeTask(index);
            Ui.printGeneric("I've removed the task.\n" + old + "\nNow you have " + taskList.getCount() +
                    " tasks and absolutely nothing will change.");
            StorageHandler.storeTaskList(taskList);
        } catch (ArrayIndexOutOfBoundsException e) {
            Ui.printGeneric("That task doesn't exist. Just like " + Color.getColoredTextString("hope", Color.RED) + ".");
        }
    }
}
