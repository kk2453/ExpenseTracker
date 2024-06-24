package com.myproject.ExpenseTracker.Category;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/category")
public class CategoryController {

    private final CategoryService categoryService;

    //constructor
    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    //function to get a list of all categories
    @GetMapping
    public List<Category> getCategories(){
        return categoryService.getCategories();
    }

    //adding new category
    @PostMapping
    public String addNewCategory(@RequestBody Category category){
        if(categoryService.addNewCategory(category)){
            return "Category added successfully";
        } else{
            return "Category already exists";
        }
    }

    @PutMapping
    public String updateCategory(@PathVariable Long id, @RequestBody Category updatedCategory){
        boolean isCategoryUpdated = categoryService.updateCategory(id, updatedCategory);
        if(isCategoryUpdated){
            return "Category updated successfully";
        } else{
            return "Category not updated";
        }

    }

}
