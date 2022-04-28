package com.company.elo320;

import java.sql.*;

public class Koks_Kozak {
    public static void createPolicyType(Connection con) throws SQLException {
        Statement st = con.createStatement();
     if(!tableExists(con, "PolicyType")) st.execute("create table PolicyType (  id INTEGER   constraint PolicyType_pk    primary key autoincrement,  type TEXT not null ); ");
    }
    public static void createPolicy(Connection con) throws SQLException{
        Statement st = con.createStatement();
        if(!tableExists(con, "Policy")) st.execute("create table Policy(id INTEGER constraint Policy_pk primary key autoincrement, policyHolderId Integer not null, InsuredId INTEGER not null, beneficiaryId INTEGER not null, risksId INTEGER not null, dateFrom TEXT not null, dateTo TEXT not null, contributionAmount REAL not null, policyTypeId INTEGER not null)");
    }
    public static void createDamageType(Connection con) throws SQLException{
        Statement st = con.createStatement();
        if(!tableExists(con,"Policy")) st.execute("create table DamageType ( id INTEGER constraint DamageType_pk primary key autoincrement, type TEXT not null );");
    }
    public static void createAddress(Connection con) throws SQLException{
        Statement st = con.createStatement();
        if(!tableExists(con, "Address")) st.execute("create table Address ( id INTEGER constraint Address_pk primary key autoincrement, streetNumber TEXT not null, street TEXT, city TEXT not null, country TEXT not null, postalCode TEXT not null );");
    }
    public static void createIndividualCustomer(Connection con) throws SQLException{
        Statement st = con.createStatement();
        if(!tableExists(con,"IndividualCustomer"))       st.execute("create table IndividualCustomer ( id INTEGER constraint IndividualCustomer_pk primary key autoincrement, AdressId INTEGER not null, telephone TEXT not null, PoliciesId INTEGER not null, INTEGER Pesel not null);");

    }
    public static void createBusisnessCustomer(Connection con) throws SQLException{
        Statement st = con.createStatement();
        if(!tableExists(con, "BusisnessCustomer"))             st.execute("create table BusisnessCustomer ( id INTEGER constraint BusisnessCustomer_pk primary key autoincrement, AdressId INTEGER not null, telephone TEXT not null, PoliciesId INT not null, nip TEXT not null, regon TEXT not null, representative TEXT not null );");
    }
    public static void createDamage(Connection con) throws SQLException{
        Statement st=con.createStatement();
        if(!tableExists(con,"Damage")) st.execute("create table Damage(id INTEGER constraint Damage_pk primary key autoincrement, PolicyId INTEGER not null, documentsPath TEXT not null, DamageTypeId INTEGER not null, VictimId INTEGER not null)");
    }
 static boolean tableExists(Connection connection, String tableName) throws SQLException {
  PreparedStatement preparedStatement = connection.prepareStatement("SELECT count(*) "
          + "FROM sqlite_schema "
          + "WHERE type='table' AND name = ?"
          + "LIMIT 1;");
  preparedStatement.setString(1, tableName);

  ResultSet resultSet = preparedStatement.executeQuery();
  resultSet.next();
  return resultSet.getInt(1) != 0;
 }
}
