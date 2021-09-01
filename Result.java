
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
public class Result {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement ps = null;
        String qry = "select * from baddressbook";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bridgelab?user= root & password = ~Geeta@988095");
            ps = con.prepareStatement(qry);
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                int ids = resultSet.getInt("id");
                String uName = resultSet.getString("userName");
                String mobile = resultSet.getString("mobile");
                String email = resultSet.getString("emailId");
                String age = resultSet.getString("age");
                Double sal = resultSet.getDouble("salary");
                System.out.println("id = "+ ids + " name = "+ uName + " mobile = "+ mobile+ " email = "+ email+ " age = "+ age+ " sal = "+ sal );
            }
            System.out.println("data inserted in db");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally {
            if(con != null){
                try{
                    con.close();
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
                System.out.println("connection get closed");
            }
            if( ps != null){
                try{
                    ps.close();
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
                System.out.println("Preparedstatement get closed");
            }
        }
    }
}

