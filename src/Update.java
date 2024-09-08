import java.sql.*;

import static java.sql.DriverManager.getConnection;
import io.github.cdimascio.dotenv.Dotenv;

public class Update
{
    public static void main(String[] args) throws Exception
    {
        Dotenv dotenv = Dotenv.load();

        String url = dotenv.get("DB_URL");
        String username = "root";
        String password =dotenv.get("DB_PASSWORD");
        String query = "INSERT INTO students values (1003, 'Ben', '2R', 376)";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = getConnection(url, username, password);
        Statement st = con.createStatement();
        int count = st.executeUpdate(query);

        System.out.println(count + " rows affected.");


        //
        st.close();
        con.close();
    }
}