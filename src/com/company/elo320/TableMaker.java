package com.company.elo320;

import java.sql.*;

public class TableMaker {
    private Connection con;
    private Statement st;

    public TableMaker(Connection con) {
        this.con = con;
        try {
            this.st = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createPolicyType() throws SQLException {
     if(!tableExists(con, "PolicyType")) st.execute("create table PolicyType (  id INTEGER   constraint PolicyType_pk    primary key autoincrement,  type TEXT not null ); ");
    }
    public void createPolicy() throws SQLException{
        if(!tableExists(con, "Policy")) st.execute("create table Policy(id INTEGER constraint Policy_pk primary key autoincrement, policyHolderId Integer not null, InsuredId INTEGER not null, beneficiaryId INTEGER not null, risksId INTEGER not null, dateFrom TEXT not null, dateTo TEXT not null, contributionAmount REAL not null, policyTypeId INTEGER not null)");
    }
    public void createDamageType() throws SQLException{
        if(!tableExists(con,"Policy")) st.execute("create table DamageType ( id INTEGER constraint DamageType_pk primary key autoincrement, type TEXT not null );");
    }
    public void createAddress() throws SQLException{
        if(!tableExists(con, "Address")) st.execute("create table Address ( id INTEGER constraint Address_pk primary key autoincrement, streetNumber TEXT not null, street TEXT, city TEXT not null, country TEXT not null, postalCode TEXT not null );");
    }
    public void createIndividualCustomer() throws SQLException{
        if(!tableExists(con,"IndividualCustomer"))       st.execute("create table IndividualCustomer ( id INTEGER constraint IndividualCustomer_pk primary key autoincrement, AddressId INTEGER not null, telephone TEXT not null, PoliciesId INTEGER not null, INTEGER Pesel not null);");

    }
    public void createBusisnessCustomer() throws SQLException{
        if(!tableExists(con, "BusisnessCustomer"))             st.execute("create table BusinessCustomer ( id INTEGER not null constraint BusinessCustomer_pk primary key autoincrement, customerId INTEGER not null constraint BusinessCustomer_Customer_id_fk references Customer (id), nip TEXT not null, regon TEXT, representative TEXT not null );");
    }
    public void createCustomer() throws SQLException{
        if(!tableExists(con,"Customer")) st.execute("create table Customer ( id INTEGER not null constraint Customer_pk primary key autoincrement, addressId TEXT not null, telephone TEXT not null, policiesId int not null );");
    }
    public void createDamage() throws SQLException{
        if(!tableExists(con,"Damage")) st.execute("create table Damage(id INTEGER constraint Damage_pk primary key autoincrement, PolicyId INTEGER not null, documentsPath TEXT not null, DamageTypeId INTEGER not null, VictimId INTEGER not null)");
    }

 private boolean tableExists(Connection connection, String tableName) throws SQLException {
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
