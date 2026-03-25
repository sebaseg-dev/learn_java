package fr.sebaseg.indie.model;

public class RevenueData {
    private double revenue;

    public RevenueData(double revenue) {
        setRevenue(revenue);
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        validateRevenue(revenue);
        this.revenue = revenue;
    }

    private void validateRevenue(double revenue) {
        if (revenue < 0 || Double.isNaN(revenue) || Double.isInfinite(revenue)) {
            throw new IllegalArgumentException("Le chiffre d'affaires doit être un nombre positif.");
        }
    }
}
