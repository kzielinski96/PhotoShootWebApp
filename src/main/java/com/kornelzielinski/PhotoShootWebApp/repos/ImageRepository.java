package com.kornelzielinski.PhotoShootWebApp.repos;

import com.kornelzielinski.PhotoShootWebApp.model.Category;
import com.kornelzielinski.PhotoShootWebApp.model.Image;
import com.kornelzielinski.PhotoShootWebApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {

    List<Image> findByUser(User user);
    List<Image> findByCategories(Category category);
}
