import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MainApp {
    private static Connection connection;
    private static Statement statement;

    public static void main(String[] args) throws Exception{
        try {
            connect();
            insertEx();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            disconnect();
        }
    }

    private static void insertEx() throws SQLException {
        statement.executeUpdate("INSERT INTO students (name, score) VALUES ('Bob3', 100);");
    }

    public static void connect() throws SQLException{
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:/D:/dev/Java/Ex/JavaExercises/AnnotationAndJDBC/main.db");
            statement = connection.createStatement();
        } catch (SQLException | ClassNotFoundException e) {
            throw new SQLException("Unable to connect");
        }
    }

    public static void disconnect(){
        try {
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
