package com.company.classes;

import java.util.List;

public class BusinessCustomer extends Customer {
   private String nip;
   private String regon;
   private String representative;

   public BusinessCustomer(int id, Address address, String telephone, List<Policy> policies, int bank, String nip, String regon, String representative) {
      super(id, address, telephone, policies, bank);
      this.nip = nip;
      this.regon = regon;
      this.representative = representative;
   }

   public String getNip() {
      return nip;
   }

   public void setNip(String nip) {
      this.nip = nip;
   }

   public String getRegon() {
      return regon;
   }

   public void setRegon(String regon) {
      this.regon = regon;
   }

   public String getRepresentative() {
      return representative;
   }

   public void setRepresentative(String representative) {
      this.representative = representative;
   }

}
