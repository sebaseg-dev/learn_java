package fr.sebaseg.datalayer.service;

import fr.sebaseg.datalayer.model.Category;
import fr.sebaseg.datalayer.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public Iterable<Category> getServices() {
        return categoryRepository.findAll();
    }

    public Optional<Category> getServiceById(Integer id) {
        return categoryRepository.findById(id);
    }

    public Optional<Category> getCategoryById(int i) {
        return categoryRepository.findById(i);
    }
}
