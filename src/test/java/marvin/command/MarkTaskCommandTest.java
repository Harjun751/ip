package marvin.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import marvin.task.TaskList;
import marvin.task.Todo;

public class MarkTaskCommandTest {
    @Test
    public void markTaskCommand_validCommand_marksTask() {
        // Arrange
        MarkTaskCommand mtc = new MarkTaskCommand("1", true);
        TaskList tl = new TaskList();
        Todo todo = new Todo("Test Todo");
        tl.addToList(todo);

        // Act
        mtc.execute(tl);

        // Assert
        assertTrue(todo.getIsDone());
    }

    @Test
    public void markTaskCommand_validCommand_unmarksTask() {
        // Arrange
        MarkTaskCommand mtc = new MarkTaskCommand("1", false);
        TaskList tl = new TaskList();
        Todo todo = new Todo("Test Todo", true);
        tl.addToList(todo);

        // Act
        mtc.execute(tl);

        // Assert
        assertFalse(todo.getIsDone());
    }

    @Test
    public void markTaskCommand_validSubTaskCommand_marksTask() {
        // Arrange
        MarkTaskCommand mtc = new MarkTaskCommand("1.1", true);
        TaskList tl = new TaskList();
        Todo todo = new Todo("Test Todo", true);
        Todo subtask = new Todo("dependent", false);
        todo.getDependentTasks().add(subtask);
        tl.addToList(todo);

        // Act
        mtc.execute(tl);

        // Assert
        assertTrue(subtask.getIsDone());
    }

    @Test
    public void markTaskCommand_validSubTaskCommand_unmarksTask() {
        // Arrange
        MarkTaskCommand mtc = new MarkTaskCommand("1.1", false);
        TaskList tl = new TaskList();
        Todo todo = new Todo("Test Todo", true);
        Todo subtask = new Todo("dependent", true);
        todo.getDependentTasks().add(subtask);
        tl.addToList(todo);

        // Act
        mtc.execute(tl);

        // Assert
        assertFalse(subtask.getIsDone());
    }

    @Test
    public void markTaskCommand_parentNotDone_doesNothing() {
        // Arrange
        MarkTaskCommand mtc = new MarkTaskCommand("1.1", true);
        TaskList tl = new TaskList();
        Todo todo = new Todo("Test Todo", false);
        Todo subtask = new Todo("dependent", false);
        tl.addToList(todo);
        tl.addToList(subtask);
        tl.setTaskToDoAfter("1", "2");

        // Act
        mtc.execute(tl);

        // Assert
        assertFalse(subtask.getIsDone());
    }

    @Test
    public void markTaskCommand_invalidCommand_doesNothing() {
        // Arrange
        MarkTaskCommand mtc = new MarkTaskCommand("1.1", false);
        TaskList tl = new TaskList();
        Todo todo = new Todo("Test Todo", true);
        tl.addToList(todo);

        // Act
        mtc.execute(tl);

        // Assert
        assertEquals(1, tl.getCount());
        assertTrue(todo.getIsDone());
    }


}
