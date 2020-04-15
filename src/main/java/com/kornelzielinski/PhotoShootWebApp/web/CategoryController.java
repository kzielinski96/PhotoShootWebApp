package com.kornelzielinski.PhotoShootWebApp.web;

import com.kornelzielinski.PhotoShootWebApp.model.Admin;
import com.kornelzielinski.PhotoShootWebApp.model.Category;
import com.kornelzielinski.PhotoShootWebApp.model.Image;
import com.kornelzielinski.PhotoShootWebApp.repos.CategoryRepository;
import com.kornelzielinski.PhotoShootWebApp.repos.ImageRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ImageRepository imageRepository;

    @GetMapping()
    public List<Category> list() {
        return categoryRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Category get(@PathVariable Long id) {
//        Category category = categoryRepository.getOne(id);
//        return imageRepository.findByCategories(category);
        return categoryRepository.getOne(id);
    }

    @PostMapping
    public void create(@RequestBody final Category category) {
        categoryRepository.saveAndFlush(category);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        categoryRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Category update(@PathVariable Long id, @RequestBody Category category) {
        Category existingCategory = categoryRepository.getOne(id);
        BeanUtils.copyProperties(category, existingCategory, "id");
        return categoryRepository.saveAndFlush(existingCategory);
    }
}
