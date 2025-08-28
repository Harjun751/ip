package marvin;

import java.util.Scanner;

import marvin.command.Command;
import marvin.task.TaskList;
import marvin.ui.Ui;

public class Marvin {
    private final TaskList tasks;

    public Marvin() {
        this.tasks = StorageHandler.loadTaskList();
    }

    public static void main(String[] args) {
        new Marvin().run();
    }

    /**
     * The core loop and entrypoint for the Marvin chatbot.
     */
    public void run() {
        Ui.printGreeting(Personality.getGreeting());
        boolean isExit = false;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            try {
                String fullCommand = Ui.readCommand(sc);
                Command c = Parser.parse(fullCommand);
                c.execute(this.tasks);
                StorageHandler.storeTaskList(this.tasks); // save state
                isExit = c.isExit();
                if (isExit) {
                    return;
                }
            } catch (MarvinException e) {
                Ui.printGeneric(e.getMessage());
            } finally {
                if (!isExit) {
                    Ui.printUserInput();
                }
            }
        }
    }
}
