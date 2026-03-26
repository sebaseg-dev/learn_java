package fr.sebaseg.indie.model.data;

public enum BusinessActivity {
    SALES (SocialCategory.SALES, TaxCategory.BIC_SALES, ProfessionalTrainingContribution.SALES),
    ARTISAN (SocialCategory.OTHER_BIC, TaxCategory.BIC_SERVICES, ProfessionalTrainingContribution.ARTISAN),
    UNREGISTERED_LIBERAL (SocialCategory.UNREGISTERED_LIBERAL, TaxCategory.BNC, ProfessionalTrainingContribution.LIBERAL),
    REGISTERED_LIBERAL (SocialCategory.REGISTERED_LIBERAL, TaxCategory.BNC, ProfessionalTrainingContribution.LIBERAL),
    LISTED_FURNISHED_RENTAL (SocialCategory.LISTED_RENTAL, TaxCategory.BIC_LISTED_RENTAL, ProfessionalTrainingContribution.SALES),
    NON_LISTED_FURNISHED_RENTAL (SocialCategory.OTHER_BIC, TaxCategory.BIC_NON_LISTED_RENTAL, ProfessionalTrainingContribution.SALES);

    public enum SocialCategory {
        SALES,
        LISTED_RENTAL,
        OTHER_BIC,
        UNREGISTERED_LIBERAL,
        REGISTERED_LIBERAL,
    }

    public enum TaxCategory {
        BIC_SALES,
        BIC_SERVICES,
        BIC_LISTED_RENTAL,
        BIC_NON_LISTED_RENTAL,
        BNC,
    }

    public enum ProfessionalTrainingContribution {
        SALES,
        ARTISAN,
        LIBERAL,
    }

    private final SocialCategory socialCategory;
    private final TaxCategory taxCategory;
    private final ProfessionalTrainingContribution professionalTrainingContribution;

    BusinessActivity(SocialCategory socialCategory, TaxCategory taxCategory, ProfessionalTrainingContribution professionalTrainingContribution) {
        this.socialCategory = socialCategory;
        this.taxCategory = taxCategory;
        this.professionalTrainingContribution = professionalTrainingContribution;
    }

    public SocialCategory getSocialCategory() {
        return socialCategory;
    }

    public TaxCategory getTaxCategory() {
        return taxCategory;
    }

    public ProfessionalTrainingContribution getProfessionalTrainingContribution() {
        return professionalTrainingContribution;
    }
}
