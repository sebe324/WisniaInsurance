package com.company.classes;

import java.util.List;

public class Risks {
    List<Risk> risk;

    public Risks(List<Risk> risk) {
        this.risk = risk;
    }

    public int getSize() {
        return risk.size();
    }

    public Risk getRisk(int index) {
        return risk.get(index);
    }

    public void setRisk(List<Risk> risk) {
        this.risk = risk;
    }
}
