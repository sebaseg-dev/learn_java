package fr.sebaseg.indie.model.data;

import java.math.BigDecimal;

public class EntrepreneurProfile {
    private final BusinessActivity activity;
    private final boolean hasACRE;
    private final boolean hasTaxWithholding;
    private final BigDecimal turnover;

    public EntrepreneurProfile(BusinessActivity activity, boolean hasACRE, boolean hasTaxWithholding, BigDecimal turnover) {
        this.activity = activity;
        this.hasACRE = hasACRE;
        this.hasTaxWithholding = hasTaxWithholding;
        this.turnover = turnover;
    }

    public BusinessActivity getActivity() {
        return activity;
    }

    public boolean hasACRE() {
        return hasACRE;
    }

    public boolean hasTaxWithholding() {
        return hasTaxWithholding;
    }

    public BigDecimal getTurnover() {
        return turnover;
    }

}
