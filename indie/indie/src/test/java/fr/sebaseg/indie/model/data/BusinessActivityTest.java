package fr.sebaseg.indie.model.data;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;

public class BusinessActivityTest {
    @ParameterizedTest
    @EnumSource(BusinessActivity.class)
    void eachActivityShouldHaveAllCategoriesDefined(BusinessActivity activity) {
        assertThat(activity.getTaxCategory()).isNotNull();
        assertThat(activity.getSocialCategory()).isNotNull();
        assertThat(activity.getProfessionalTrainingContribution()).isNotNull();
    }
}
