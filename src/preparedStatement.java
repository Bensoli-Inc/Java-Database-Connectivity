import java.sql.*;
import static java.sql.DriverManager.getConnection;
import io.github.cdimascio.dotenv.Dotenv;

public class preparedStatement
{
    public static void main(String[] args) throws Exception
    {
        Dotenv dotenv = Dotenv.load();

        String url = dotenv.get("DB_URL");
        String password = dotenv.get("DB_PASSWORD");
        String username = "root";

        String query = "INSERT INTO students values (?,?,?,?)";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, username, password);
        PreparedStatement st = con.prepareStatement(query);

        int admissionNo = 1006;
        String studentName = "Terry";
        String classStream = "1R";
        int marks = 424;

        st.setInt(1, admissionNo);
        st.setString(2, studentName);
        st.setString(3, classStream);
        st.setInt(4, marks);

        int count = st.executeUpdate();
        System.out.println(count + " rows affected.");

        st.close();
        con.close();
    }
}
