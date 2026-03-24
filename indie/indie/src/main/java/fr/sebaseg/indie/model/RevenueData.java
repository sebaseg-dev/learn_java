package fr.sebaseg.indie.model;

public class RevenueData {
    private final double revenue;

    public RevenueData(double revenue) {
        if (revenue < 0 || Double.isNaN(revenue) || Double.isInfinite(revenue)) {
            throw new IllegalArgumentException("Veuillez saisir un chiffre d'affaires correct.");
        }

        this.revenue = revenue;
    }

    public double getRevenue() {
        return revenue;
    }
}
