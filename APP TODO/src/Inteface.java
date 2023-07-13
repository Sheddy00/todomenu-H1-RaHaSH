import java.sql.Date;
import java.util.List;
import java.util.Scanner;
public class Inteface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 6) {
            System.out.println("====== TODO Menu ======");
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
                    System.out.print("Enter the deadline (date): ");
                    String deadlineString = scanner.next();
                    Date deadline;
                    try {
                        deadline = Date.valueOf(deadlineString);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid Date format. Please enter the date in the format yyyy-mm-dd ");
                        return; // Sortir de la méthode pour éviter d'ajouter un todo invalide
                    }


                    // Pour consommer la nouvelle ligne
                    Todo newTodo = new Todo(title, description, priority,deadline);
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
                            System.out.println("Deadline: " +todo.getDeadline() );
                            System.out.println("--------------------");
                        }
                    }
                }

                case 4 -> {
                    System.out.print("Enter the title of the todo to update: ");
                    String title = scanner.nextLine();

                    System.out.println("Select the field to update:");
                    System.out.println("1. Title");
                    System.out.println("2. Description");
                    System.out.println("3. Priority");
                    System.out.println("4. Deadline");
                    System.out.println("5. Cancel");
                    System.out.print("Enter your choice: ");
                    int choix = scanner.nextInt();
                    scanner.nextLine(); // Consommer le caractère de nouvelle ligne après nextInt()

                    // Vérifier le choix de l'utilisateur
                    switch (choix) {
                        case 1 ->{
                            System.out.print("Enter the new title: ");
                            String newTitle = scanner.nextLine();
                            UserCrud.updateTodoTitle(title, newTitle);

                        }

                        case 2 ->{
                            System.out.print("Enter the new description: ");
                            String newDescription = scanner.nextLine();
                            UserCrud.updateTodoDescription(title, newDescription);
                        }

                        case 3 -> {
                            System.out.print("Enter the new priority: ");
                            int newPriority;
                            try {
                                newPriority = Integer.parseInt(scanner.nextLine());
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid priority format. Please enter a valid integer.");
                                return;
                            }
                            UserCrud.updateTodoPriority(title, newPriority);
                        }

                        case 4 -> {
                            System.out.print("Enter the new deadline (Date - yyyy-mm-dd ): ");
                            String newDeadlineString = scanner.nextLine();
                            Date newDeadline;
                            try {
                                newDeadline = Date.valueOf(newDeadlineString);
                            } catch (IllegalArgumentException e) {
                                System.out.println("Invalid date format. Please enter the date in the format yyyy-mm-dd hh:mm:ss");
                                return;
                            }
                            UserCrud.updateTodoDeadline(title, newDeadline);
                        }

                        case 5 ->{

                            System.out.println("Update cancelled.");
                        }
                        default ->{
                            System.out.println("Invalid choice. Please try again.");
                        }

                    }

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
