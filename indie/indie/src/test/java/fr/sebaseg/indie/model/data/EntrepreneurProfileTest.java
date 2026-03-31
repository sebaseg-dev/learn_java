package fr.sebaseg.indie.model.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class EntrepreneurProfileTest {
    EntrepreneurProfile testProfile;

    BusinessActivity activity = BusinessActivity.SALES;
    boolean hasACRE = false;
    boolean hasTaxWithholding = true;
    BigDecimal turnover = new BigDecimal("100000.0");

    @BeforeEach
    void setUp() {
        testProfile = new EntrepreneurProfile(
                activity,
                hasACRE,
                hasTaxWithholding,
                turnover
        );
    }

    @Test
    public void testGetActivity() {
        assertThat(testProfile.getActivity()).isEqualTo(activity);
    }

    @Test
    public void testHasACRE() {
        assertThat(testProfile.hasACRE()).isEqualTo(hasACRE);
    }

    @Test
    public void testHasTaxWithholding() {
        assertThat(testProfile.hasTaxWithholding()).isEqualTo(hasTaxWithholding);
    }

    @Test
    public void testGetTurnover() {
        assertThat(testProfile.getTurnover()).isEqualByComparingTo(turnover);
    }


}
