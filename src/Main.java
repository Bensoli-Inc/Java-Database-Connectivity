
// steps to follow:
// 1.import the package >>> java.sql
// 2. load and register driver >>> mysql driver>> com.mysql.jdbc.Driver
// 3. create a connection >>object of connection interface
// 4. create a statement >>object of statement interface
// 5. execute the query
// 6. process the results
// 7. close

import java.sql.*;

import static java.sql.DriverManager.getConnection;
import io.github.cdimascio.dotenv.Dotenv;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        Dotenv dotenv = Dotenv.load();

        String url = dotenv.get("DB_URL");
        String username = "root";
        String password =dotenv.get("DB_PASSWORD");
        String query = "SELECT studentName FROM students WHERE admissionNo = 1002";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = getConnection(url, username, password);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        rs.next();
        String name = rs.getString("studentName");

        System.out.println(name);

        //closing
        st.close();
        con.close();
    }
}