package AddingStudent_to_DB;
import java.sql.*;
import static java.sql.DriverManager.getConnection;
import io.github.cdimascio.dotenv.Dotenv;

public class Main
{
    public static  void main(String[] args) throws ClassNotFoundException, SQLException {
        StudentDAO dao = new StudentDAO();

        Student s1 = new Student();
        s1.rollno = 14;
        s1.sname = "Navin";
        dao.addStudent(s1);
    }
}

class StudentDAO // >>Data Access Object;
{
    public void addStudent( Student s) throws SQLException, ClassNotFoundException
    {
        Dotenv dotenv = Dotenv.load();

        String url = dotenv.get("DB_URL");
        String username = "root";
        String password =dotenv.get("DB_PASSWORD");

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, username, password);

        String query = "INSERT INTO student values (?,?)";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setInt(1, s.rollno);
        pst.setString(2, s.sname);
        pst.executeUpdate();

    }
}

class Student
{
    int rollno;
    String sname;
}
