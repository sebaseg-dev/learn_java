package fr.sebaseg.indie.model.data;

import java.math.BigDecimal;

public class EntrepreneurProfile {
    private final BusinessActivity activity;
    private boolean hasACRE;
    private boolean hasTaxWithholding;
    private final BigDecimal turnover;

    EntrepreneurProfile(BusinessActivity activity, boolean hasACRE, boolean hasTaxWithholding, BigDecimal turnover) {
        this.activity = activity;
        this.hasACRE = false;
        this.hasTaxWithholding = true;
        this.turnover = turnover;
    }

    public BusinessActivity getActivity() {
        return activity;
    }

    public BigDecimal getTurnover() {
        return turnover;
    }
}
