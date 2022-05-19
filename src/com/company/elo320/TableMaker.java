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
        if(!tableExists(con, "Policy")) st.execute("create table Policy(id INTEGER constraint Policy_pk primary key autoincrement, policyHolderId Integer not null constraint Policy_Customer_id_fk references Customer (id), InsuredId INTEGER not null constraint Policy_Customer_id_fk references Customer (id), beneficiaryId INTEGER not null constraint Policy_Customer_id_fk references Customer (id), risksId INTEGER not null, dateFrom TEXT not null, dateTo TEXT not null, contributionAmount REAL not null, policyTypeId INTEGER not null constraint Policy_PolicyType_id_fk references PolicyType (id))");
    }
    public void createDamageType() throws SQLException{
        if(!tableExists(con,"DamageType")) st.execute("create table DamageType ( id INTEGER constraint DamageType_pk primary key autoincrement, type TEXT not null );");
    }
    public void createAddress() throws SQLException{
        if(!tableExists(con, "Address")) st.execute("create table Address ( id INTEGER constraint Address_pk primary key autoincrement, streetNumber TEXT not null, street TEXT, city TEXT not null, country TEXT not null, postalCode TEXT not null );");
    }
    public void createIndividualCustomer() throws SQLException{
        if(!tableExists(con,"IndividualCustomer"))       st.execute("create table IndividualCustomer (customerId INTEGER not null constraint IndividualCustomer_Customer_id_fk references Customer(id), pesel TEXT not null );");

    }
    public void createBusisnessCustomer() throws SQLException{
        if(!tableExists(con, "BusinessCustomer"))             st.execute("create table BusinessCustomer (customerId INTEGER not null constraint BusinessCustomer_Customer_id_fk references Customer (id), nip TEXT not null, regon TEXT, representative TEXT not null );");
    }
    public void createCustomer() throws SQLException{
        if(!tableExists(con,"Customer")) st.execute("create table Customer ( id INTEGER not null constraint Customer_pk primary key autoincrement, addressId INTEGER not null constraint Customer_Address_id_fk references Address (id), telephone TEXT not null, policiesId int not null );");
    }
    public void createDamage() throws SQLException{
        if(!tableExists(con,"Damage")) st.execute("create table Damage(id INTEGER constraint Damage_pk primary key autoincrement, PolicyId INTEGER not null constraint Damage_Policy_id_fk references Policy (id), documentsPath TEXT not null, DamageTypeId INTEGER not null constraint Damage_DamageType_id_fk references DamageType (id), VictimId INTEGER not null constraint Damage_Customer_id_fk references Customer (id));");
    }
    public void createRisk() throws SQLException{
        if(!tableExists(con,"Risk")) st.execute("create table Risk(id INTEGER not null constraint Risk_pk primary key autoincrement, price REAL not null, protectionFrom TEXT not null, protectionTo TEXT not null, description TEXT not null, policyTypeId INTEGER constraint Risk_PolicyType_id_fk references PolicyType (id));");
    }
    public void createRisks() throws SQLException{
        if(!tableExists(con, "Risks")) st.execute("create table Risks(CustomerId INTEGER not null constraint Risks_Customer_id_fk references Customer(id), RiskId INTEGER not null constraint Risks_Risk_id_fk references Risk(Id));");
    }
    public void createEvent() throws SQLException{
        if(!tableExists(con,"Event")) st.execute("create table Event(id INTEGER not null constraint Event_pk primary key autoincrement, eventDate TEXT not null, damagesId INTEGER not null, eventPlace TEXT not null, courseOfEvents TEXT not null)");
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
