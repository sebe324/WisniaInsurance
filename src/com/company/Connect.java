package com.company;

import com.company.elo320.TableMaker;

import javax.swing.plaf.nimbus.State;
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
            tm.createBusinessCustomer();
            tm.createDamage();
            tm.createRisk();
            tm.createRisks();
            tm.createEvent();
            tm.createTemp();
            //tm.insertToAddress("1a","wallStreet","newYork","USA","10001");
            //tm.insertToPolicy(1,1,1,1,"2020","2021",100,1);
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
