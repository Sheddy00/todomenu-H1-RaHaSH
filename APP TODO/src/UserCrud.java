import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class UserCrud {

    public static void addTodo(Todo todo) {
        Connection connection = DBConnection.getConnection();
        try {
            String query = "INSERT INTO todo (title, description, priority) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, todo.getTitle());
            statement.setString(2, todo.getDescription());
            statement.setInt(3, todo.getPriority());
            statement.executeUpdate();
            System.out.println("Todo added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Todo> findTodoByKeyword(String keyword) {
        List<Todo> todos = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        try {
            String query = "SELECT * FROM todo WHERE title LIKE ? OR description LIKE ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "%" + keyword + "%");
            statement.setString(2, "%" + keyword + "%");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                int priority = resultSet.getInt("priority");
                Todo todo = new Todo(title, description, priority);
                todos.add(todo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todos;
    }

    public static List<Todo> getAllTodos() {
        List<Todo> todos = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        try {
            String query = "SELECT * FROM todo";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                int priority = resultSet.getInt("priority");
                Todo todo = new Todo(title, description, priority);
                todos.add(todo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todos;
    }

    public static void updateTodoPriority(String title, int newPriority) {
        Connection connection = DBConnection.getConnection();
        try {
            String query = "UPDATE todo SET priority = ? WHERE title = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, newPriority);
            statement.setString(2, title);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Todo updated successfully!");
            } else {
                System.out.println("Todo not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteTodoByTitle(String title) {
        Connection connection = DBConnection.getConnection();
        try {
            String query = "DELETE FROM todo WHERE title = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, title);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Todo deleted successfully!");
            } else {
                System.out.println("Todo not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
