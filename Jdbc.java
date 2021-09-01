package com.company;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class Jdbc {
        public static void main(String[] args) {
            Connection con = null;
            Statement s = null;

            String qry = "INSERT INTO baddressbook.addressb(`PinCode`, `Fname`, `Lname`, `Address`, `City`, `PHNum`, `Email`) VALUES ('9879', 'Gee', 'bs', 'Ypr', 'Banglore', '9878967796', 'abchgg@gmail')";
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user= root & password = ~Geeta@988095");
                s = con.createStatement();
                s.executeUpdate(qry);
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
                if( s != null){
                    try{
                        s.close();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    System.out.println("statement get closed");
                }
            }
        }
    }

