package fr.sebaseg.indie.model.config;

import java.util.List;

public record IncomeTaxScale(
        String applicableFrom,
        List<TaxBracket> brackets,
        String sourceUrl
) {}
