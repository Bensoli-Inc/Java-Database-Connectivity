package ForNameMethod;

import java.sql.DriverManager;
import java.sql.SQLException;

//class.forName >> method used to load the jdbc driver
public class Main
{
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
       // Pqr obj = new Pqr();
        Class.forName("ForNameMethod.Pqr"); //just loading the class >>executes only static block
        Class.forName("ForNameMethod.Pqr").newInstance(); //creating an object

        //WHILE WORKING WITH JDBC
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver()); //long unnecessary statement

        //INSTEAD DO;
        Class.forName("com.mysql.cj.jdbc.Driver");
    }
}

class Pqr
{
    static //static block
    {
        System.out.println("in static");
    }

    { //instance block
        System.out.println("in instance");
    }
}

