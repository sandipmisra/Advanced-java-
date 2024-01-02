package dev.repository;

public class IncomeBreakDown {
    private double totalIncome;
    private double basicPay;
    private double houseRent;
    private double medicalAllowance;
    private double conveyanceAllowance;
    private double bonus;

    public IncomeBreakDown(double totalIncome, double basicPay, double houseRent, double medicalAllowance,
                           double conveyanceAllowance, double bonus) {
        this.basicPay = basicPay;
        this.houseRent = houseRent;
        this.medicalAllowance = medicalAllowance;
        this.conveyanceAllowance = conveyanceAllowance;
        this.bonus = bonus;
        this.totalIncome = totalIncome;
    }

    public void calculateBreakDown() {
        basicPay = totalIncome * 0.5625;
        houseRent = totalIncome * ((double) 169 / 600);
        medicalAllowance = totalIncome * ((double) 17 / 300);
        conveyanceAllowance = totalIncome * 0.1;
        bonus = basicPay * 2;
    }

    public double getBasicPay() {
        return basicPay;
    }

    public double getHouseRent() {
        return houseRent;
    }

    public double getMedicalAllowance() {
        return medicalAllowance;
    }

    public double getConveyanceAllowance() {
        return conveyanceAllowance;
    }

    public double getBonus() {
        return bonus;
    }
}
