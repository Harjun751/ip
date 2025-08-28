package marvin.command;

import marvin.task.TaskList;
import marvin.ui.Color;
import marvin.ui.Ui;

public class MarkTaskCommand extends Command {
    public boolean toMark;
    public int index;

    public MarkTaskCommand(int index, boolean toMark){
        this.toMark = toMark;
        this.index = index;
    }


    @Override
    public void execute(TaskList taskList) {
        try{
            String marked = taskList.markTask(this.index, this.toMark);
            Ui.printGeneric("Fine, done.\n" + marked);
        } catch (ArrayIndexOutOfBoundsException e){
            Ui.printGeneric("That task doesn't exist. Just like " + Color.getColoredTextString("hope", Color.RED) + ".");
        }
    }
}
