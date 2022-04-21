package com.company;

import java.sql.*;

public class Connect {
    public static void connectToDb() {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:sqlite:C:/Users/uczen/WisniaInsurance/db.sqlite");
            Statement st = con.createStatement();
            st.executeQuery("create table Policy" +
                    "(" +
                    "id INTEGER" +
                    "constraint Policy_pk" +
                    "primary key autoincrement," +
                    "policyHolderId INTEGER not null," +
                    "insuredId INTEGER not null," +
                    "beneficiaryId INTEGER not null," +
                    "risksId INTEGER not null," +
                    "dateFrom TEXT not null," +
                    "dateTo TEXT," +
                    "contributionAmount REAL not null," +
                    "policyTypeId INTEGER" +
                    ");" +
                    "");
            st.executeQuery("create table PolicyType (  id INTEGER   constraint PolicyType_pk    primary key autoincrement,  type TEXT not null ); ");
            st.executeQuery("create table DamageType ( id INTEGER constraint DamageType_pk primary key autoincrement, type TEXT not null );");
            st.executeQuery("create table Address ( id INTEGER constraint Address_pk primary key autoincrement, streetNumber TEXT not null, street TEXT, city TEXT not null, country TEXT not null, postalCode TEXT not null );");
            st.executeQuery("create table Customer ( id INTEGER constraint Customer_pk primary key autoincrement, AdressId INTEGER not null, telephone TEXT not null, PoliciesId INTEGER not null, CustomerType INTEGER );");
            st.executeQuery("create table BusisnessCustomer ( id INTEGER constraint BusisnessCustomer_pk primary key autoincrement, nip TEXT not null, regon TEXT not null, representative TEXT not null );");

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
