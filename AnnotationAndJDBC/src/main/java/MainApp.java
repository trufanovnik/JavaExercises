import java.lang.reflect.Field;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class MainApp {
    private static Connection connection;
    private static Statement statement;

    public static void main(String[] args) throws Exception{
        try {
            connect();
            buildTable(Gamers.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            disconnect();
        }
    }

    private static void buildTable(Class cl){
        if (!cl.isAnnotationPresent(Table.class))
            throw new RuntimeException("Аннотация Table отсутствует у данного класса");
        Map<Class, String> map = new HashMap<>();
        map.put(int.class, "INTEGER");
        map.put(String.class, "TEXT");
        // строим sql запрос на создание таблицы gamers
        // CREATE TABLE gamers (id INTEGER, nickname TEXT, game TEXT);
        StringBuilder stringBuilder = new StringBuilder("CREATE TABLE ");
        stringBuilder.append(((Table)cl.getAnnotation(Table.class)).title());
        // "CREATE TABLE gamers"
        stringBuilder.append(" (");
        // "CREATE TABLE gamers ("
        Field[] fields = cl.getDeclaredFields();
        for (Field o : fields){
            o.setAccessible(true);
            if (o.isAnnotationPresent(Column.class)){
                stringBuilder.append(o.getName())
                        .append(" ")
                        .append(map.get(o.getType()))
                        .append(", ");
            }
        }
        // "CREATE TABLE gamers (id INTEGER, nickname TEXT, game TEXT, "
        stringBuilder.setLength(stringBuilder.length() - 2);
        // "CREATE TABLE gamers (id INTEGER, nickname TEXT, game TEXT"
        stringBuilder.append(");");
        try {
            statement.execute(stringBuilder.toString());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void connect() throws SQLException{
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:AnnotationAndJDBC/main.db");
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
