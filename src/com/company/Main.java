package com.company;
import java.sql.*;
public class Main {

    public static void main(String[] args) {
        Connection con=null;
        try{
            con=DriverManager.getConnection("jdbc:sqlite:C:/Users/uczen/WisniaInsurance/db.sqlite");
            Statement st = con.createStatement();

        }
        catch(Exception e){
            System.out.println(e);
        }
        finally{
            try{
                if(con!=null) con.close();
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }
}
