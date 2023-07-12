import java.util.List;
import java.util.Scanner;
public class Inteface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 6) {
            System.out.println("---- TODO Menu ----");
            System.out.println("1. Add a new TODO");
            System.out.println("2. Find a TODO");
            System.out.println("3. Show all todos");
            System.out.println("4. Update a TODO");
            System.out.println("5. Delete a TODO");
            System.out.println("6. Quit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Pour consommer la nouvelle ligne

            switch (choice) {
                case 1 -> {
                    System.out.println("Enter the title: ");
                    String title = scanner.nextLine();
                    System.out.println("Enter the description: ");
                    String description = scanner.nextLine();
                    System.out.println("Enter the priority (1-10): ");
                    int priority = scanner.nextInt();
                    scanner.nextLine();

                    // Pour consommer la nouvelle ligne
                    Todo newTodo = new Todo(title, description, priority);
                    UserCrud.addTodo(newTodo);
                }
                case 2 -> {
                    System.out.println("Enter the keyword to search: ");
                    String keyword = scanner.nextLine();
                    List<Todo> foundTodos = UserCrud.findTodoByKeyword(keyword);
                    if (foundTodos.isEmpty()) {
                        System.out.println("No todos found!");
                    } else {
                        for (Todo todo : foundTodos) {
                            System.out.println("Title: " + todo.getTitle());
                            System.out.println("Description: " + todo.getDescription());
                            System.out.println("Priority: " + todo.getPriority());
                            System.out.println();
                        }
                    }
                }

                case 3 -> {
                    List<Todo> allTodos = UserCrud.getAllTodos();
                    if (allTodos.isEmpty()) {
                        System.out.println("No todos found!");
                    } else {
                        for (Todo todo : allTodos) {
                            System.out.println("Title: " + todo.getTitle());
                            System.out.println("Description: " + todo.getDescription());
                            System.out.println("Priority: " + todo.getPriority());
                            System.out.println();
                        }
                    }
                }

                case 4 -> {
                    System.out.println("Enter the title of the todo to update: ");
                    String todoTitle = scanner.nextLine();
                    System.out.println("Enter the new priority (1-10): ");
                    int newPriority = scanner.nextInt();
                    scanner.nextLine(); // Pour consommer la nouvelle ligne

                    UserCrud.updateTodoPriority(todoTitle, newPriority);
                }


                case 5 -> {
                    System.out.println("Enter the title of the todo to delete: ");
                    String todoTitleToDelete = scanner.nextLine();

                    UserCrud.deleteTodoByTitle(todoTitleToDelete);
                }

                case 6 ->
                {
                    System.out.println("Thank you for your visit....Goodbye!");
                }


                default -> {
                    System.out.println("Invalid choice! Please try again.");
                }
            }
        }

        scanner.close();
    }

}
