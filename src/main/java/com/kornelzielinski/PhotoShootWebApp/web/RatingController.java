package com.kornelzielinski.PhotoShootWebApp.web;

import com.kornelzielinski.PhotoShootWebApp.model.Image;
import com.kornelzielinski.PhotoShootWebApp.model.Rating;
import com.kornelzielinski.PhotoShootWebApp.repos.ImageRepository;
import com.kornelzielinski.PhotoShootWebApp.repos.RatingRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {

    @Autowired
    private RatingRepository ratingRepository;

    @GetMapping()
    public List<Rating> list() {
        return ratingRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Rating get(@PathVariable Long id) {
        return ratingRepository.getOne(id);
    }

    @PostMapping
    public void create(@RequestBody final Rating rating) {
        ratingRepository.saveAndFlush(rating);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        ratingRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Rating update(@PathVariable Long id, @RequestBody Rating rating) {
        Rating existingRating = ratingRepository.getOne(id);
        BeanUtils.copyProperties(rating, existingRating, "id");
        return ratingRepository.saveAndFlush(existingRating);
    }
}
