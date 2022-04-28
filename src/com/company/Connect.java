package com.company;

import com.company.elo320.Koks_Kozak;

import java.sql.*;

public class Connect {
    public static void connectToDb() {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:sqlite:C:/Users/uczen/WisniaInsurance/db.sqlite");
            Koks_Kozak.createPolicy(con);
            Koks_Kozak.createPolicyType(con);
            Koks_Kozak.createDamageType(con);
            Koks_Kozak.createAddress(con);
            Koks_Kozak.createIndividualCustomer(con);
            Koks_Kozak.createBusisnessCustomer(con);
            Koks_Kozak.createDamage(con);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
