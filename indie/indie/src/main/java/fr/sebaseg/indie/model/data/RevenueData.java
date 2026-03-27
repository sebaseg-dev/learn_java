package fr.sebaseg.indie.model.data;

import java.math.BigDecimal;

public class RevenueData {
    private BigDecimal revenue;

    public RevenueData(BigDecimal revenue) {
        setRevenue(revenue);
    }

    public BigDecimal getRevenue() {
        return revenue;
    }

    public void setRevenue(BigDecimal revenue) {
        validateRevenue(revenue);
        this.revenue = revenue;
    }

    private void validateRevenue(BigDecimal revenue) {
        if (revenue == null) {
            throw new IllegalArgumentException("Le chiffre d'affaires ne peut pas être nul.");
        }

        if (revenue.signum() == -1) {
            throw new IllegalArgumentException("Le chiffre d'affaires doit être un nombre positif.");
        }
    }
}
