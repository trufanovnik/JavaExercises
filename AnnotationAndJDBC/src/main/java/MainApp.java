import java.lang.reflect.Field;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class MainApp {

    public static void main(String[] args) throws Exception{
        try {
            DBconnection.connect();
//            DBconnection.statement.execute("DROP TABLE gamers;");
            BuildTable.buildTable(Gamers.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBconnection.disconnect();
        }
    }
}
