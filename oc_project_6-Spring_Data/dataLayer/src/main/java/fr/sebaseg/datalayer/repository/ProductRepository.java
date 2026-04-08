package fr.sebaseg.datalayer.repository;

import fr.sebaseg.datalayer.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
