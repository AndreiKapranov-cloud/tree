import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class db {


    public static List<Entity.Child> getChildren() throws ClassNotFoundException, SQLException {

        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/";
        String db = "books?serverTimezone=Europe/Moscow";
        String driver = "com.mysql.cj.jdbc.Driver";
        String user = "root";
        String pass = "mysql";
        // STR declaration outside try catch blocs
        String[] str = new String[10 /*any value > 0 */];

        final String query = "SELECT  ch2.name as 'Child', ch1.name as 'Parent'\n" +
                "FROM task3 ch1\n" +
                "right JOIN task3 ch2\n" +
                "ON ch1.id = ch2.parent_id";
        Class.forName(driver);
        con = DriverManager.getConnection(url + db, user, pass);
        Statement stm;

        stm = con.createStatement();



        ResultSet rst;
        rst = stm.executeQuery(query);
        List<Entity.Child> childrenList = new ArrayList<>();
        while (rst.next()) {
            Entity.Child child = new Entity.Child(rst.getString("Child"), rst.getString("Parent"));
            childrenList.add(child);
        }


        return childrenList;
    }

}
