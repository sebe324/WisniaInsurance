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
            Statement st = con.createStatement();
            st.execute("DROP TABLE IF EXISTS Policy");
            st.execute("DROP TABLE IF EXISTS PolicyType");
            st.execute("DROP TABLE IF EXISTS DamageType");
            st.execute("DROP TABLE IF EXISTS Address");
            st.execute("DROP TABLE IF EXISTS Customer");
            st.execute("DROP TABLE IF EXISTS IndividualCustomer");
            st.execute("DROP TABLE IF EXISTS BusinessCustomer");
            st.execute("DROP TABLE IF EXISTS Damage");
            st.execute("DROP TABLE IF EXISTS Risk");
            st.execute("DROP TABLE IF EXISTS Risks");
            st.execute("DROP TABLE IF EXISTS Event");
            st.execute("DROP TABLE IF EXISTS Temp");

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
            tm.insertToPolicyType("HEALTH");
            tm.insertToPolicyType("CAR");
            tm.insertToPolicyType("LIFE");
            tm.insertToPolicyType("ESTATE");
            tm.insertToPolicyType("TRAVEL");
            tm.insertToPolicyType("PET");
            tm.insertToDamageType("ESTATE");
            tm.insertToPolicyType("PERSONAL");
            tm.insertToCustomer(1,"123456789",null);
            tm.insertToRisk(10,"2020-01-01","2021-01-01","pogczamp",1);
            tm.insertToRisks(1,1);
            tm.insertToPolicy(1,1,1,1,"2020-01-01", "2021-01-01",123,1);
            tm.insertToAddress("1a","wallStreet","newYork","USA","10001");
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
