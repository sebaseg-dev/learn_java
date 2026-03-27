package fr.sebaseg.indie.model;

import fr.sebaseg.indie.model.data.RevenueData;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class RevenueDataTest {

    @Test
    public void testValidRevenue() {
        RevenueData data = new RevenueData(new BigDecimal("100.0"));
        assertEquals(new BigDecimal("100.0"), data.getRevenue());
    }

    @Test
    public void testSetRevenue() {
        RevenueData data = new RevenueData(new BigDecimal("100.0"));
        data.setRevenue(new BigDecimal("200.0"));
        assertEquals(new BigDecimal("200.0"), data.getRevenue());
    }

    @Test
    public void testInvalidRevenueNegative() {
        assertThrows(IllegalArgumentException.class, () -> new RevenueData(new BigDecimal("-1.0")));
    }

    @Test
    public void testInvalidRevenueNull() {
        assertThrows(IllegalArgumentException.class, () -> new RevenueData(null));
    }

    @Test
    public void testExceptionMessage() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new RevenueData(new BigDecimal("-10.0")));
        assertEquals("Le chiffre d'affaires doit être un nombre positif.", exception.getMessage());
    }
}
