package pl.kgdev.jobboard.services;

import org.springframework.stereotype.Service;
import pl.kgdev.jobboard.entities.Category;
import pl.kgdev.jobboard.repositories.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }
}
