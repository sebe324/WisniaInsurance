package com.company.classes;

import com.company.enums.DamageType;

import java.util.List;

public class Damage {
private int id;
private Policy policy;
private List<String> documents; //sciezki do grafiki dokumentów
private DamageType damageType;
private Customer victim;

    public Damage(int id, Policy policy, List<String> documents, DamageType damageType, Customer victim) {
        this.id = id;
        this.policy = policy;
        this.documents = documents;
        this.damageType = damageType;
        this.victim = victim;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPolicy(Policy policy) {
        this.policy = policy;
    }

    public DamageType getDamageType() {
        return damageType;
    }

    public void setDamageType(DamageType damageType) {
        this.damageType = damageType;
    }

    public Customer getVictim() {
        return victim;
    }

    public void setVictim(Customer victim) {
        this.victim = victim;
    }

    public List<String> getDocuments() {
        return documents;
    }

    public void setDocuments(List<String> documents) {
        this.documents = documents;
    }

    public Policy getPolicy() {
        return policy;
    }

    public float damagePayment() {
        float amount=0;
        for (int i = 0; i < policy.getRisks().size(); i++) {
            amount += policy.getRisks().get(i).getPrice();
        }
        return amount;
    }
}
