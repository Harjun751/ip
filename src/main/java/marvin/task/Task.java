package marvin.task;

import java.io.Serializable;

/**
 * An abstract task class that represents a task that Marvin can manage.
 */
public abstract class Task implements Serializable {
    private final String description;
    private boolean isDone;

    /**
     * Instantiates a task that is not done.
     *
     * @param description The task description.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Instantiates a task.
     *
     * @param description The task description.
     * @param isDone      The state of completeness of the task.
     */
    public Task(String description, boolean isDone) {
        this.description = description;
        this.isDone = isDone;
    }

    /**
     * Returns the description of the task.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Returns the isDone status of the task.
     */
    public boolean getIsDone() {
        return this.isDone;
    }

    /**
     * A setter for the done parameter.
     * Affects the string display of the item.
     *
     * @param isDone represents the new state of doneness of the task
     */
    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }

    @Override
    public abstract String toString();
}
