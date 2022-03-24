package com.company.classes;

import java.util.List;
import java.util.Arrays;
public class Customer {
    private int id;
    private Address address;
    private String telephone;
    private List<Policy> policies;

    public Customer(int id, Address address, String telephone, List<Policy> policies, int bank) {
        this.id = id;
        this.address = address;
        this.telephone = telephone;
        this.policies = policies;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<Policy> getPolicies() {
        return policies;
    }

    public void setPolicies(List<Policy> policies) {
        this.policies = policies;
    }

    public void addPolicy(Policy policy){
       this.policies.add(policy);
    }
    public void removePolicy(int policyId){
        for(int i=0; i<policies.size(); i++){
            if(policies.get(i).getId()==policyId){
                policies.remove(i);
            }
        }
    }
    public void changePolicy(int index, Policy policy){
        try{
            this.policies.set(index, policy);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("The index you have entered is invalid");
            System.out.println("Please enter an index number between 0 and " + this.policies.size());
        }
    }
}
