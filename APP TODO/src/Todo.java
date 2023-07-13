import java.sql.Timestamp;
import java.util.Date;

public class Todo {
    private String title;
    private String description;
    private int priority;
    private Date deadline;


    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    // Constructeur
    public Todo(String title, String description, int priority,Date  deadline) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.deadline= deadline;


    }



    // Getters et Setters
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
}
