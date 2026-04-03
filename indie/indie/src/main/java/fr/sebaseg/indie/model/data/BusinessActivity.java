package fr.sebaseg.indie.model.data;

public enum BusinessActivity {
    SALES (TaxCategory.BIC_SALES, SocialCategory.SALES, ProfessionalTrainingContribution.SALES),
    ARTISAN (TaxCategory.BIC_SERVICES, SocialCategory.OTHER_BIC, ProfessionalTrainingContribution.ARTISAN),
    UNREGISTERED_LIBERAL (TaxCategory.BNC, SocialCategory.UNREGISTERED_LIBERAL, ProfessionalTrainingContribution.LIBERAL),
    REGISTERED_LIBERAL (TaxCategory.BNC, SocialCategory.REGISTERED_LIBERAL, ProfessionalTrainingContribution.LIBERAL),
    LISTED_FURNISHED_RENTAL (TaxCategory.BIC_LISTED_RENTAL, SocialCategory.LISTED_RENTAL, ProfessionalTrainingContribution.SALES),
    NON_LISTED_FURNISHED_RENTAL (TaxCategory.BIC_NON_LISTED_RENTAL, SocialCategory.OTHER_BIC, ProfessionalTrainingContribution.SALES);

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

    BusinessActivity(TaxCategory taxCategory, SocialCategory socialCategory, ProfessionalTrainingContribution professionalTrainingContribution) {
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
