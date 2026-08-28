
/*
Jeremy Dean
08.19.2026
Pet Adoption System
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteDatabase 
{
    public static Connection connect(String database) 
    {
        String url = "jdbc:sqlite:" + database;
        
        try 
        {
            return DriverManager.getConnection(url);
        } 
        catch (SQLException e)
        {
            System.out.println("Database connection error: " + e.getMessage());
            return null;
        }
        
    }

}
    

