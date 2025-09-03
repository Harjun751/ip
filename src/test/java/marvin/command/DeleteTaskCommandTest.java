package marvin.command;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import marvin.task.TaskList;
import marvin.task.Todo;

public class DeleteTaskCommandTest {
    @Test
    public void deleteTaskCommand_validCommand_deletesTask() {
        // Arrange
        DeleteTaskCommand dtc = new DeleteTaskCommand(0);
        TaskList tl = new TaskList();
        tl.addToList(new Todo("Test Todo"));

        // Act
        dtc.execute(tl);

        // Assert
        assertEquals("", tl.toString());
        assertEquals(0, tl.getCount());
    }

    @Test
    public void deleteTaskCommand_invalidCommand_doesNotDeleteTask() {
        // Arrange
        DeleteTaskCommand dtc = new DeleteTaskCommand(1);
        TaskList tl = new TaskList();
        tl.addToList(new Todo("Test Todo"));

        // Act
        dtc.execute(tl);

        // Assert
        assertEquals(1, tl.getCount());
        assertEquals("1. [T][ ] Test Todo\n", tl.toString());
    }
}
