package com.myproject.ExpenseTracker.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    //constructor
    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    //returns a list of categories from the database
    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }


    //add category in database
    public boolean addNewCategory(Category category){

        //check if category already exists
        if(categoryRepository.existsById(category.id)){
            return false;
        } else{
            categoryRepository.save(category);
        }
        return true;
    }

    public boolean updateCategory(Long id, Category updatedCategory) {
        for(Category category : getCategories()){
            if(category.getId() == id) {
                category.setName(updatedCategory.getName());
                category.setDescription(updatedCategory.getDescription());
                category.setSubscription(updatedCategory.getSubscription());
                return true;
            }
        }
        return false;
    }
}
