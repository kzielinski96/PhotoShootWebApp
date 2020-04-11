package com.kornelzielinski.PhotoShootWebApp.repos;

import com.kornelzielinski.PhotoShootWebApp.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
