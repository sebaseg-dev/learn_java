package fr.sebaseg.indie.model.config;

import java.math.BigDecimal;

public record TaxBracket(
        BigDecimal limit,
        BigDecimal rate
) {}
