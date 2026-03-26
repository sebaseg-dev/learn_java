package fr.sebaseg.indie.model;

import fr.sebaseg.indie.model.data.RevenueData;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RevenueDataTest {

    @Test
    public void testValidRevenue() {
        RevenueData data = new RevenueData(100.0);
        assertEquals(100.0, data.getRevenue());
    }

    @Test
    public void testSetRevenue() {
        RevenueData data = new RevenueData(100.0);
        data.setRevenue(200.0);
        assertEquals(200.0, data.getRevenue());
    }

    @Test
    public void testInvalidRevenueNegative() {
        assertThrows(IllegalArgumentException.class, () -> new RevenueData(-1.0));
    }

    @Test
    public void testInvalidRevenueNaN() {
        assertThrows(IllegalArgumentException.class, () -> new RevenueData(Double.NaN));
    }

    @Test
    public void testInvalidRevenueInfinite() {
        assertThrows(IllegalArgumentException.class, () -> new RevenueData(Double.POSITIVE_INFINITY));
    }

    @Test
    public void testExceptionMessage() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new RevenueData(-10.0));
        assertEquals("Le chiffre d'affaires doit être un nombre positif.", exception.getMessage());
    }
}
