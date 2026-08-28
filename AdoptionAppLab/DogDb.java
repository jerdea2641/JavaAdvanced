/*
Jeremy Dean
08.27.2026
Pet Adoption System
provide create, read, update, and delete operations for the dog database
*/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DogDb 
{
   //Creates dogs table if it doesnt exist
   public static boolean createTable(Connection conn)
   {
        String sql =
            "CREATE TABLE IF NOT EXISTS Dogs (" +
            "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "Name TEXT NOT NULL," +
            "Age INTEGER, " +
            "Breed TEXT, " +
            "Traits TEXT, " +
            "Adopted INTEGER) ";

        try
        {
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            return true;
        }
        catch (SQLException e)
        {
            System.out.println("Error creating table: " + e.getMessage());
            return false;

        }
   } 

   //CREATE - Adds a dog to the database
   public static void addDog(Connection conn, Dog dog)
   {
        String sql = "INSERT INTO Dogs (Name, Age, Breed, Traits, Adopted) VALUES (?, ?, ?, ?, ?)";

        try
        {
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, dog.getName());
            pst.setInt(2, dog.getAge());
            pst.setString(3, dog.getBreed());
            pst.setString(4, dog.getTraits());
            pst.setBoolean(5, dog.isAdopted());

            pst.executeUpdate();
        }
        catch (SQLException e)
        {
            System.out.println("Error adding dog: " + e.getMessage());
        }
   }

   //READ = Gets all dogs from database
   public static ArrayList<Dog> getAllDogs(Connection conn)
   {
        ArrayList<Dog> dogs = new ArrayList<>();

        String sql = "SELECT * FROM Dogs";

        try
        {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next())
            {
                int id = rs.getInt("ID");

                String name = rs.getString("Name");
                int age = rs.getInt("Age");
                String breed = rs.getString("Breed");
                String traits = rs.getString("Traits");
                boolean adopted = rs.getBoolean("Adopted");

                Dog dog = new Dog(name, age, breed, traits);
                dog.setAdopted(adopted);

                System.out.println("Database ID: " + id);

                dogs.add(dog);
            }
        }
        catch (SQLException e)
        {
            System.out.println("Error reading dogs: " + e.getMessage());
        }

        return dogs;
   }

   public static boolean dogExists(Connection conn, int id)
    {
        String sql = "SELECT ID FROM Dogs WHERE ID=?";

        try
        {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();

        return rs.next();
        }
        catch (SQLException e)
        {
            System.out.println("Error checking dog: " + e.getMessage());
            return false;
        }
    }

   //UPDATE - Update dogs info using its database ID.
   public static boolean updateDog(Connection conn, int id, String name, int age, String breed, String traits)
    {
        String sql =
            "UPDATE Dogs " +
            "SET Name=?, Age=?, Breed=?, Traits=? " +
            "WHERE ID=?";

        try
        {
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, name);
            pst.setInt(2, age);
            pst.setString(3, breed);
            pst.setString(4, traits);
            pst.setInt(5, id);

            int rowsUpdated = pst.executeUpdate();

            if (rowsUpdated == 0)
            {
                System.out.println("No dog was found with ID " + id + ".");
                return false;
            }
            return true;
        }
        catch (SQLException e)
        {
            System.out.println("Error updating dog: " + e.getMessage());
            return false;
        }
    }

    //DELETE - Remove a dog from the database
    public static boolean deleteDog(Connection conn, int id)
    {
        String sql = "DELETE FROM Dogs WHERE ID=?";

        try
        {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            int rowsDeleted = pst.executeUpdate();

            if (rowsDeleted == 0)
            {
                System.out.println("No dog was found with ID " + id + ".");
                return false;
            }
            return true;
        }
        catch (SQLException e)
        {
            System.out.println("Error deleting dog: " + e.getMessage());
            return false;
        }
    }

}