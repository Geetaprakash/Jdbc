package com.company;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
public class Main {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement ps = null;
                 String qry = "INSERT INTO baddressbook.addressb(`PinCode`, `Fname`, `Lname`, `Address`, `City`, `PHNum`, `Email`) VALUES ('9879', 'Gee', 'bs', 'Ypr', 'Banglore', '9878967796', 'abchgg@gmail')";
                // placeHolder
                // String qry = "insert into baddressbook.addressb values (?,?,?,?,?,?)";
                 try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user= root & password = ~Geeta@988095");
            ps = con.prepareStatement(qry);
            ps.setInt(1,14);
            ps.setString(2,"abc");
            ps.setString(3,"gg");
            ps.setString(4,"gfghb");
            ps.setString(5,"kolkata");
            ps.setString(6,"bc@gmail.com");
            ps.setInt(7,70987798);
            ps.executeUpdate();
            ps.executeUpdate(qry);
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
                        System.out.println("statement get closed");
                    }
                }
            }
        }

