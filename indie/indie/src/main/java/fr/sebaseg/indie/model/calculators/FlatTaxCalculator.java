package fr.sebaseg.indie.model.calculators;

import fr.sebaseg.indie.model.data.BusinessActivity;

import java.math.BigDecimal;

public interface FlatTaxCalculator {

    BigDecimal getRate(BusinessActivity activity);

    default BigDecimal calculate(BigDecimal turnover, BusinessActivity activity) {
        return turnover.multiply(getRate(activity));
    }

}
