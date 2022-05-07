package fr.univrouen.rss22.services;

import fr.univrouen.rss22.iServices.CategoryService;
import fr.univrouen.rss22.models.Category;
import fr.univrouen.rss22.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ICategoryService implements CategoryService{

    @Autowired
    CategoryRepository categoryRepository;


    @Override
    public void updateCategory(Category category) {
        categoryRepository.save(category);
    }
}
