package fr.sebaseg.testing.service;

import fr.sebaseg.testing.domain.model.CalculationModel;

public interface CalculatorService {
    /**
     * Effectuer le calcul demandé par un modèle
     *
     * @param calculationModel Modèle de calcul
     * @return Modèle de calcul rempli du résultat
     */
    CalculationModel calculate(CalculationModel calculationModel);
}