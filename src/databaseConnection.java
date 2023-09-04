
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class databaseConnection {
    String url = "jdbc:postgresql://localhost:5432/pn";
    String user = "postgres";
    String password = "geometar";
    Connection conn = null;
    
    public Connection databaseConn()
    {
        try 
        {
            Class.forName("org.postgresql.Driver");
        } 
        catch (ClassNotFoundException ex) 
        {
            Logger.getLogger(databaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        try 
        {
            conn = DriverManager.getConnection(url, user, password);
            //JOptionPane.showMessageDialog(null, "       Конектован!");
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(databaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    
    public static void main(String[] args)
    {
        databaseConnection connDatabase = new databaseConnection();
        connDatabase.databaseConn();
    }
}
