package dev.repository;

public class TaxCalculator {
    private double totalIncome;
    private String category;


    public TaxCalculator(double totalIncome, String category) {
        this.totalIncome = totalIncome;
        this.category = category;
    }

    public double calculateTax() {
        double taxAmount = 0;

        if (category.equalsIgnoreCase("Male") || category.equalsIgnoreCase("Female")) {
            if (totalIncome <= 350000) {
                taxAmount = totalIncome * 0.0;
            } else if (totalIncome <= 450000) {
                taxAmount = (totalIncome - 350000) * 0.05;
            } else if (totalIncome <= 750000) {
                taxAmount = (450000 - 350000) * 0.05 + (totalIncome - 450000) * 0.1;
            } else if (totalIncome <= 1150000) {
                taxAmount = (750000 - 450000) * 0.1 + (totalIncome - 750000) * 0.15;
            } else if (totalIncome <= 1650000) {
                taxAmount = (1150000 - 750000) * 0.15 + (totalIncome - 1150000) * 0.2;
            } else {
                taxAmount = (1650000 - 1150000) * 0.2 + (totalIncome - 1650000) * 0.25;
            }
        } else if (category.equalsIgnoreCase("Especially Abled")) {
            if (totalIncome <= 450000) {
                taxAmount = totalIncome * 0.0;
            } else if (totalIncome <= 550000) {
                taxAmount = (totalIncome - 450000) * 0.05;
            } else if (totalIncome <= 950000) {
                taxAmount = (550000 - 450000) * 0.05 + (totalIncome - 550000) * 0.1;
            } else if (totalIncome <= 1350000) {
                taxAmount = (950000 - 550000) * 0.1 + (totalIncome - 950000) * 0.15;
            } else if (totalIncome <= 1850000) {
                taxAmount = (1350000 - 950000) * 0.15 + (totalIncome - 1350000) * 0.2;
            } else {
                taxAmount = (1850000 - 1350000) * 0.2 + (totalIncome - 1850000) * 0.25;
            }
        } else if (category.equalsIgnoreCase("Freedom Fighter")) {
            if (totalIncome <= 475000) {
                taxAmount = totalIncome * 0.0;
            } else if (totalIncome <= 500000) {
                taxAmount = (totalIncome - 475000) * 0.05;
            } else if (totalIncome <= 875000) {
                taxAmount = (500000 - 475000) * 0.05 + (totalIncome - 500000) * 0.1;
            } else if (totalIncome <= 1275000) {
                taxAmount = (875000 - 500000) * 0.1 + (totalIncome - 875000) * 0.15;
            }


        }
        return taxAmount;
    }
}