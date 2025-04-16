
//5 steps in jdbc connectivity--
//register the driver
//create connection
//create statement
//execute query
//close connection
package atm_simulator_system;
import java.sql.*;


public class Conn {
    
    Connection c;
    Statement s;
    public Conn(){
        try{
          
            c = DriverManager.getConnection("jdbc:mysql:///atmsimsys","root","namanaman");
            s= c.createStatement();
            
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    
}
