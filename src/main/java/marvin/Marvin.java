package marvin;

import java.util.Scanner;

import marvin.command.Command;
import marvin.task.TaskList;
import marvin.ui.Ui;

/**
 * Encapsulates the entrypoint to the Marvin application.
 */
public class Marvin {
    private final TaskList tasks;

    /**
     * Initiates Marvin, loading a task list from storage if applicable.
     */
    public Marvin() {
        this.tasks = StorageHandler.loadTaskList();
    }

    /**
     * Initiates and begins running Marvin.
     */
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

    /**
     * Generates a response for the user's chat message
     */
    public String getResponse(String input) {
        return "Marvin heard: " + input;
    }
}
