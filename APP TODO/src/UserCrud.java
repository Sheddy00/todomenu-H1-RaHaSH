import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class UserCrud {

    public static void addTodo(Todo todo) {
        Connection connection = DBConnection.getConnection();
        try {
            String query = "INSERT INTO todo (title, description,deadline) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, todo.getTitle());
            statement.setString(2, todo.getDescription());
            statement.setInt(3, todo.getPriority());
            statement.setDate(3, (Date) todo.getDeadline());
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
                // Récupérer le Date de la colonne "deadline" dans la base de données
                Date deadline = resultSet.getDate("deadline");
                Todo todo = new Todo(title, description, priority, deadline);
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
                // Récupérer le Date de la colonne "deadline" dans la base de données
                Date deadline = resultSet.getDate("deadline");
                Todo todo = new Todo(title, description, priority, deadline);
                todos.add(todo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todos;
    }
    public static void updateTodoTitle(String title, String newTitle) {
        Connection connection = DBConnection.getConnection();
        try {
            String query = "UPDATE todo SET title = ? WHERE title = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, newTitle);
            statement.setString(2, title);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Todo title updated successfully!");
            } else {
                System.out.println("Todo not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateTodoDescription(String title, String newDescription) {
        Connection connection = DBConnection.getConnection();
        try {
            String query = "UPDATE todo SET description = ? WHERE title = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, newDescription);
            statement.setString(2, title);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Todo description updated successfully!");
            } else {
                System.out.println("Todo not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    public static void updateTodoDeadline(String title, Date newDeadline) {
        Connection connection = DBConnection.getConnection();
        try {
            String query = "UPDATE todo SET deadline = ? WHERE title = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setDate(1, newDeadline);
            statement.setString(2, title);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Todo deadline updated successfully!");
            } else {
                System.out.println("Todo not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

  /**
   * */  public static void updateTodoPriority(String title, int newPriority) {
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
