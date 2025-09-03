package marvin.command;

import java.util.function.Consumer;

import marvin.ui.Ui;

public class CommandResult {
    private final Runnable printCommand;
    private final String message;

    public CommandResult(Runnable printCommand, String message) {
        this.printCommand = printCommand;
        this.message = message;
    }

    public void printResponse() {
        this.printCommand.run();
    }

    public String getMessage() {
        return this.message;
    }
}
