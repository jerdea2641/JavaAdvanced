/*
Jeremy Dean
08.19.2026
Week 4 Pet Adoption System
Main application class
 */
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

public class App 
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println("    Week 4 Project: Pet Adoption System");
        System.out.println("    Jeremy Dean");
        System.out.println("========================================");

        System.out.println("\nWelcome to the Pet Adoption System!");
        System.out.println("Help find a loving home for our furry friends.");

        // Connect to the SQLite database.
        Connection conn = SQLiteDatabase.connect("PetAdoption.db");

        if (conn == null)
        {
            System.out.println("Unable to connect to the database.");
            input.close();
            return;
        }

        // Create the Dogs table if it does not already exist.
        if (!DogDb.createTable(conn))
        {
            System.out.println("Unable to create the Dogs table.");
            input.close();
            return;
        }

        boolean running = true;

        while (running)
        {
            System.out.println("\n========== MAIN MENU ==========");
            System.out.println("1. View Available Dogs");
            System.out.println("2. Add a Dog");
            System.out.println("3. Update a Dog");
            System.out.println("4. Delete a Dog");
            System.out.println("5. Exit");

            System.out.print("\nChoose an option: ");

            int choice = input.nextInt();
            input.nextLine();

            switch (choice)
            {
                case 1:
                    viewDogs(conn);
                    break;

                case 2:
                    addDog(conn, input);
                    break;

                case 3:
                    updateDog(conn, input);
                    break;

                case 4:
                    deleteDog(conn, input);
                    break;

                case 5:
                    running = false;
                    System.out.println(
                        "\nThank you for visiting the Pet Adoption System!"
                    );
                    break;

                default:
                    System.out.println("\nInvalid choice.");
            }
        }

        try
        {
            conn.close();
        }
        catch (Exception e)
        {
            System.out.println("Error closing database connection.");
        }

        input.close();
    }

    // READ: Displays all dogs stored in the database.
    private static void viewDogs(Connection conn)
    {
        System.out.println("\nAvailable Dogs:");

        ArrayList<Dog> dogs = DogDb.getAllDogs(conn);

        if (dogs.isEmpty())
        {
            System.out.println("There are currently no dogs available.");
            return;
        }

        int number = 1;

        for (Dog dog : dogs)
        {
            System.out.println("\nDog #" + number);
            dog.displayInfo();
            number++;
        }
    }

    // CREATE: Adds a new dog to the database.
    private static void addDog(Connection conn, Scanner input)
    {
        System.out.println("\n========== ADD A DOG ==========");

        System.out.print("Name: ");
        String name = input.nextLine();

        System.out.print("Age: ");
        int age = input.nextInt();
        input.nextLine();

        System.out.print("Breed: ");
        String breed = input.nextLine();

        System.out.print("Traits: ");
        String traits = input.nextLine();

        Dog dog = new Dog(name, age, breed, traits);

        DogDb.addDog(conn, dog);

        System.out.println("\n" + name + " was added successfully.");
    }

    // UPDATE: Changes an existing dog's information.
    private static void updateDog(Connection conn, Scanner input)
    {
        System.out.println("\n========== UPDATE A DOG ==========");

        viewDogs(conn);

        System.out.print("\nEnter the database ID of the dog to update: ");
        int id = input.nextInt();
        input.nextLine();
        
        if (!DogDb.dogExists(conn, id))
        {
            System.out.println("\nNo dog was found with ID " + id + ".");
            return;
        }

        System.out.print("New name: ");
        String name = input.nextLine();

        System.out.print("New age: ");
        int age = input.nextInt();
        input.nextLine();

        System.out.print("New breed: ");
        String breed = input.nextLine();

        System.out.print("New traits: ");
        String traits = input.nextLine();

        boolean updated = DogDb.updateDog(conn, id, name, age, breed, traits);

        if (updated)
        {
            System.out.println("\nDog information updated successfully.");
        }

        System.out.println("\nDog information updated successfully.");
     }

    // DELETE: Removes a dog from the database.
    private static void deleteDog(Connection conn, Scanner input)
    {
        System.out.println("\n========== DELETE A DOG ==========");

        viewDogs(conn);

        System.out.print("\nEnter the database ID of the dog to delete: ");
        int id = input.nextInt();
        input.nextLine();

        if (!DogDb.dogExists(conn, id))
        {
            System.out.println("\nNo dog was found with ID " + id + ".");
            return;
        }

        boolean deleted = DogDb.deleteDog(conn, id);

        if (deleted)
        {
            System.out.println("\nDog was deleted successfully.");
        }
    }
}
