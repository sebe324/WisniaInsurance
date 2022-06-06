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
    public void insertToPolicyType(String type) throws SQLException{
        if(tableExists(con,"PolicyType")) st.execute("insert into PolicyType (type) VALUES ('"+type+"');");
    }
    public void createPolicy() throws SQLException{
        if(!tableExists(con, "Policy")) st.execute("create table Policy(id INTEGER constraint Policy_pk primary key autoincrement, policyHolderId Integer not null constraint Policy_Customer_id_fk references Customer (id), InsuredId INTEGER not null constraint Policy_Customer_id_fk references Customer (id), beneficiaryId INTEGER not null constraint Policy_Customer_id_fk references Customer (id), risksId INTEGER not null, dateFrom TEXT not null, dateTo TEXT not null, contributionAmount REAL not null, policyTypeId INTEGER not null constraint Policy_PolicyType_id_fk references PolicyType (id))");
    }
    public void insertToPolicy(int policyHolderId, int insuredId, int beneficiaryId, int risksId, String dateFrom, String dateTo, float contributionAmount, int policyTypeId) throws SQLException{
        if(tableExists(con,"Policy")) st.execute("insert into Policy(policyHolderId, insuredId, beneficiaryId, risksId, dateFrom, dateTo, contributionAmount,policyTypeId) values ('"+policyHolderId+"','"+insuredId+"','"+beneficiaryId+"','"+risksId+"','"+dateFrom+"','"+dateTo+"','"+contributionAmount+"','"+policyTypeId+"'");
    }
    public void createDamageType() throws SQLException{
        if(!tableExists(con,"DamageType")) st.execute("create table DamageType ( id INTEGER constraint DamageType_pk primary key autoincrement, type TEXT not null );");
    }
    public void insertToDamageType(String type) throws SQLException{
        if(tableExists(con,"DamageType")) st.execute("insert into DamageType (type) VALUES ('"+type+"');");
    }
    public void createAddress() throws SQLException{
        if(!tableExists(con, "Address")) st.execute("create table Address ( id INTEGER constraint Address_pk primary key autoincrement, streetNumber TEXT not null, street TEXT, city TEXT not null, country TEXT not null, postalCode TEXT not null );");
    }
    public void insertToAddress(String streetNumber, String street, String city, String country, String postalCode) throws SQLException{
        if(tableExists(con,"Address")) st.execute("insert into Address(streetNumber,street,city,country,postalCode) values ('"+streetNumber+"','"+street+"','"+city+"','"+country+"','"+postalCode+"')");
    }
    public void createIndividualCustomer() throws SQLException{
        if(!tableExists(con,"IndividualCustomer"))       st.execute("create table IndividualCustomer (customerId INTEGER not null constraint IndividualCustomer_Customer_id_fk references Customer(id), pesel TEXT not null );");

    }
    public void insertToIndividualCustomer(String pesel) throws SQLException{
        if(tableExists(con, "IndividualCustomer")) st.execute("insert into IndividualCustomer ('"+pesel+"')");
    }
    public void createBusinessCustomer() throws SQLException{
        if(!tableExists(con, "BusinessCustomer"))             st.execute("create table BusinessCustomer (customerId INTEGER not null constraint BusinessCustomer_Customer_id_fk references Customer (id), nip TEXT not null, regon TEXT, representative TEXT not null );");
    }
    public void insertToBusinessCustomer(String nip, String regon, String representative) throws SQLException{
        if(tableExists(con,"BusinessCustomer")) st.execute("insert into BusinessCustomer(nip,regon,representative) values ('"+nip+"','"+regon+"','"+representative+"')");
    }
    public void createCustomer() throws SQLException{
        if(!tableExists(con,"Customer")) st.execute("create table Customer ( id INTEGER not null constraint Customer_pk primary key autoincrement, addressId INTEGER not null constraint Customer_Address_id_fk references Address (id), telephone TEXT not null, policiesId int not null constraint Customer_Temp_id_fk references Temp(id));");
    }
    public void insertToCustomer(int addressId, String telephone, int policiesId) throws SQLException{
        if(tableExists(con, "Customer")) st.execute("insert into Customer(addressId, telephone, policiesId) values ('"+addressId+"','"+telephone+"','"+policiesId+"')");
    }
    public void createDamage() throws SQLException{
        if(!tableExists(con,"Damage")) st.execute("create table Damage(id INTEGER constraint Damage_pk primary key autoincrement, policyId INTEGER not null constraint Damage_Policy_id_fk references Policy (id), documentsPath TEXT not null, damageTypeId INTEGER not null constraint Damage_DamageType_id_fk references DamageType (id), victimId INTEGER not null constraint Damage_Customer_id_fk references Customer (id));");
    }
    public void insertToDamage(int policyId, String documentsPath, int damageTypeId, int victimId) throws SQLException{
        if(tableExists(con, "Damage")) st.execute("insert into Damage(policyId, documentsPath, damageTypeId, victimId) values ('"+policyId+"','"+documentsPath+"','"+damageTypeId+"','"+victimId+"')");
    }
    public void createRisk() throws SQLException{
        if(!tableExists(con,"Risk")) st.execute("create table Risk(id INTEGER not null constraint Risk_pk primary key autoincrement, price REAL not null, protectionFrom TEXT not null, protectionTo TEXT not null, description TEXT not null, policyTypeId INTEGER constraint Risk_PolicyType_id_fk references PolicyType (id));");
    }
    public void insertToRisk(float price, String protectionFrom, String protectionTo, String description, int policyTypeId) throws SQLException{
        if(tableExists(con,"Risk")) st.execute("insert into Risk(price,protectionFrom,protectionTo,description,policyTypeId) values ('"+price+"','"+protectionFrom+"','"+protectionTo+"','"+description+"','"+policyTypeId+"')");
    }
    public void createRisks() throws SQLException{
        if(!tableExists(con, "Risks")) st.execute("create table Risks(CustomerId INTEGER not null constraint Risks_Customer_id_fk references Customer(id), RiskId INTEGER not null constraint Risks_Risk_id_fk references Risk(Id));");
    }
    public void createEvent() throws SQLException{
        if(!tableExists(con,"Event")) st.execute("create table Event(id INTEGER not null constraint Event_pk primary key autoincrement, eventDate TEXT not null, damagesId INTEGER not null, eventPlace TEXT not null, courseOfEvents TEXT not null);");
    }
    public void insertToEvent(String eventDate, int damagesId,String eventPlace, String courseOfEvents) throws SQLException{
        if(tableExists(con,"Event")) st.execute("insert into Event(eventDate, damagesId, eventPlace, courseOfEvents) values ('"+eventDate+"','"+damagesId+"','"+eventPlace+"','"+courseOfEvents+"')");
    }
    public void createTemp() throws SQLException{
        if(!tableExists(con, "Temp")) st.execute("create table Temp(id INTEGER not null , policyId INTEGER not null constraint Temp_Policy_id_fk references Policy(id));");
    }
    public void insertToTemp(int id, int policyId) throws SQLException{
        if(tableExists(con,"Temp")) st.execute("insert into Temp(id,policyId) values ('"+id+"','"+policyId+"')");
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
