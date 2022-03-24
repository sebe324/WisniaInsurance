package com.company.classes;

import java.util.List;

public class IndividualCustomer extends Customer {
    private String pesel;

    public IndividualCustomer(int id, Address address, String telephone, List<Policy> policies, int bank, String pesel) {
        super(id, address, telephone, policies, bank);
        this.pesel = pesel;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }
}
