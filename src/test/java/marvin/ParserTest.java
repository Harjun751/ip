package marvin;

import static marvin.Parser.parse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import marvin.command.AddTaskCommand;
import marvin.command.Command;
import marvin.command.MarkTaskCommand;

public class ParserTest {
    @Test
    public void parse_validMarkInput_returnsMarkCommand() {
        Command c = parse("mark 1");
        assertEquals(MarkTaskCommand.class, c.getClass());
    }

    @Test
    public void parse_invalidMarkInput_throwsException() {
        try {
            Command c = parse("mark abc");
            fail();
        } catch (Exception e) {
            assertEquals(MarvinException.class, e.getClass());
        }
    }

    @Test
    public void parse_incompleteMarkInput_throwsException() {
        try {
            Command c = parse("mark");
            fail();
        } catch (Exception e) {
            assertEquals(MarvinException.class, e.getClass());
        }
    }

    @Test
    public void parse_validTodoInput_returnsAddTaskCommand() {
        Command c = parse("todo this");
        assertEquals(AddTaskCommand.class, c.getClass());
    }

    @Test
    public void parse_validDeadlineInput_returnsAddTaskCommand() {
        Command c = parse("deadline test /by 28/08/2025 1800");
        assertEquals(AddTaskCommand.class, c.getClass());
    }

    @Test
    public void parse_invalidDeadlineInput_throwsException() {
        try {
            parse("deadline test /by 28/8/2025 1800");
            fail();
        } catch (Exception e) {
            assertEquals(MarvinException.class, e.getClass());
        }
    }
}
