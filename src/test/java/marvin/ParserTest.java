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
    public void parse_returnsMarkCommand_ifValidMarkInput() {
        Command c = parse("mark 1");
        assertEquals(MarkTaskCommand.class, c.getClass());
    }

    @Test
    public void parse_throwsException_ifIncompleteMarkInput() {
        try {
            Command c = parse("mark");
            fail();
        } catch (Exception e) {
            assertEquals(MarvinException.class, e.getClass());
        }
    }

    @Test
    public void parse_returnsAddTaskCommand_ifValidTodoInput() {
        Command c = parse("todo this");
        assertEquals(AddTaskCommand.class, c.getClass());
    }

    @Test
    public void parse_returnsAddTaskCommand_ifValidDeadlineInput() {
        Command c = parse("deadline test /by 28/08/2025 1800");
        assertEquals(AddTaskCommand.class, c.getClass());
    }

    @Test
    public void parse_throwsException_ifInvalidDeadlineInput() {
        try {
            parse("deadline test /by 28/8/2025 1800");
            fail();
        } catch (Exception e) {
            assertEquals(MarvinException.class, e.getClass());
        }
    }
}
