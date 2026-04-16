package fr.sebaseg.regime_inde.repository;

import fr.sebaseg.regime_inde.entity.CfpRate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CfpRateRepository extends CrudRepository<CfpRate, Integer> {
}
