
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        getConnection();
        createTable();
    }
    public static void createTable(){
        try{
            Connection conn = getConnection();
            PreparedStatement create = conn.prepareStatement("CREATE TABLE `testjdbc`.`Faculty` (`Esib` INT(20) NOT NULL ) ENGINE = InnoDB;");
            create.executeUpdate();
        }
        catch (Exception e){
            System.out.println(e);
        }
        finally {
            System.out.println("Function Completed");
        }
    }
    public static Connection getConnection(){
        try{
            String driver="com.mysql.cj.jdbc.Driver";
            String databaseurl="jdbc:mysql://localhost:3306/testjdbc";
            String username="root";
            String password="";
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(databaseurl,username,password);
            System.out.println("Database Connected");
            return conn;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;

    }
}