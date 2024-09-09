package benfxjdbc;
import java.sql.*;
import static java.sql.DriverManager.getConnection;
import io.github.cdimascio.dotenv.Dotenv;

public class Main
{
    public static  void main(String[] args) throws ClassNotFoundException, SQLException {
        StudentDAO dao = new StudentDAO();
        Student s1 = dao.getStudent(11); //getting student from db with rollno 12
        System.out.println(s1.sname);
    }
}

class StudentDAO // >>Data Access Object;
{
    Dotenv dotenv = Dotenv.load();

    String url = dotenv.get("DB_URL");
    String username = "root";
    String password =dotenv.get("DB_PASSWORD");
    public Student getStudent( int rollno) throws ClassNotFoundException, SQLException {
        Student s =new Student();
        s.rollno = rollno;
        String query = "SELECT sname FROM student WHERE rollno ="+rollno;
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, username, password);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        rs.next();

        String name = rs.getString(1);
        s.sname = name;
        st.close();
        con.close();

        return s;
    }
}

class Student
{
    int rollno;
    String sname;
}
