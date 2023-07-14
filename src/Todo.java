public class Todo {
    private int id;
    private String title;
    private String description;
    private int priority;
    private boolean done;

    // Constructeur
    public Todo(int id, String title, String description, int priority, boolean done) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.done = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
