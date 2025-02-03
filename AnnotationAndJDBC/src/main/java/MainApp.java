import java.sql.*;

public class MainApp {

    public static void main(String[] args) throws Exception{
        try {
            DBconnection.connect();
            DBconnection.statement.execute("DROP TABLE gamers;");
            BuildTable.buildTable(Gamers.class);
            FillTable.getFieldsFromClass();
            FillTable.fillTableWithFields();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBconnection.disconnect();
        }
    }
}
