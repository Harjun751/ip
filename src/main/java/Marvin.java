import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Marvin {
    private TaskList tasks;

    public static void main(String[] args) {
        new Marvin().run();
    }

    public Marvin() {
        this.tasks = StorageHandler.loadTaskList();
    }

    public void run() {
        Ui.printGreeting(Personality.getGreeting());
        boolean isExit = false;
        while (true){
            try{
                String fullCommand = Ui.readCommand();
                Command c = Parser.parse(fullCommand);
                c.execute(this.tasks);
                StorageHandler.storeTaskList(this.tasks); // save state
                isExit = c.isExit();
                if (isExit) {
                    return;
                }
            } catch (MarvinException e){
                Ui.printGeneric(e.getMessage());
            } finally {
                if (!isExit){
                    Ui.printUserInput();
                }
            }
        }
    }
}
