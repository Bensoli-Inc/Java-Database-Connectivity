
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

public class Main
{
    public static void main(String[] args) throws Exception
    {
        String url = "";
        String username = "";
        String password ="";

        Class.forName("com.mysql.jdbc.Driver");
        Connection con = getConnection(url, username, password);
        Statement str;
    }
}