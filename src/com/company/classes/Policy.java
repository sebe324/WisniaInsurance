package com.company.classes;


import java.util.List;
import com.company.classes.enums.PolicyType;
public class Policy {
    private int id;
    private Customer policyholder;
    private Customer insured;
    private Customer beneficiary;
    private List<Risk> risks;
    private String dateFrom;
    private String dateTo;
    private float contributionAmount;
    private PolicyType policyType;

    public Policy(int id, Customer policyholder, Customer insured, Customer beneficiary, List<Risk> risks, String dateFrom, String dateTo, float contributionAmount, PolicyType policyType) {
        this.id = id;
        this.policyholder = policyholder;
        this.insured = insured;
        this.beneficiary = beneficiary;
        this.risks = risks;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.contributionAmount = contributionAmount;
        this.policyType = policyType;
    }

    public int getId() {
        return id;
    }

    public List<Risk> getRisks() {
        return risks;
    }
}
