package com.kornelzielinski.PhotoShootWebApp.repos;

import com.kornelzielinski.PhotoShootWebApp.model.Comment;
import com.kornelzielinski.PhotoShootWebApp.model.Image;
import com.kornelzielinski.PhotoShootWebApp.model.Rating;
import com.kornelzielinski.PhotoShootWebApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long> {

    List<Rating> findByUser(User user);
    List<Rating> findByImage(Image image);
}
