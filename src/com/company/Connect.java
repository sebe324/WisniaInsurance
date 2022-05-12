package com.company;

import com.company.elo320.TableMaker;

import java.sql.*;

public class Connect {
    public static void connectToDb() {
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:db.sqlite");
            TableMaker tm = new TableMaker(con);
            tm.createPolicy();
            tm.createPolicyType();
            tm.createDamageType();
            tm.createAddress();
            tm.createCustomer();
            tm.createIndividualCustomer();
            tm.createBusisnessCustomer();
            tm.createDamage();
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
