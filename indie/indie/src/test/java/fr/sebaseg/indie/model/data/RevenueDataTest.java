package fr.sebaseg.indie.model.data;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RevenueDataTest {

    @Test
    public void testValidRevenue() {
        RevenueData data = new RevenueData(new BigDecimal("100.0"));
        assertThat(data.getRevenue()).isEqualByComparingTo(new BigDecimal("100.0"));
    }

    @Test
    public void testRevenueZero() {
        RevenueData data = new RevenueData(new BigDecimal("0.0"));
        assertThat(data.getRevenue()).isEqualByComparingTo(new BigDecimal("0.0"));
    }

    @Test
    public void testSetRevenue() {
        RevenueData data = new RevenueData(new BigDecimal("100.0"));
        data.setRevenue(new BigDecimal("200.0"));
        assertThat(data.getRevenue()).isEqualByComparingTo(new BigDecimal("200.0"));
    }

    @Test
    public void testInvalidRevenueNegative() {
        BigDecimal negativeRevenue = new BigDecimal("-10.0");
        assertThatThrownBy(() -> new RevenueData(negativeRevenue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Le chiffre d'affaires doit être un nombre positif.");
    }

    @Test
    public void testInvalidRevenueNull() {
        assertThatThrownBy(() -> new RevenueData(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Le chiffre d'affaires ne peut pas être nul.");
    }

}
