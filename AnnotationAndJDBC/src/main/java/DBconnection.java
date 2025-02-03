import java.sql.*;

public class DBconnection {
    protected static Connection connection;
    protected static Statement statement;
    protected static PreparedStatement ps;

    public static void connect() throws SQLException{
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:AnnotationAndJDBC/main.db");
            statement = connection.createStatement();
            ps = connection.prepareStatement(
                    "INSERT INTO gamers (id, nickname, game) VALUES (?, ?, ?);"
            );
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
