package com.kornelzielinski.PhotoShootWebApp.web;

import com.kornelzielinski.PhotoShootWebApp.model.Comment;
import com.kornelzielinski.PhotoShootWebApp.model.Image;
import com.kornelzielinski.PhotoShootWebApp.repos.CommentRepository;
import com.kornelzielinski.PhotoShootWebApp.repos.ImageRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    @Autowired
    private ImageRepository imageRepository;

    @GetMapping()
    public List<Image> list() {
        return imageRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Image get(@PathVariable Long id) {
        return imageRepository.getOne(id);
    }

    @PostMapping
    public void create(@RequestBody final Image image) {
        imageRepository.saveAndFlush(image);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        imageRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Image update(@PathVariable Long id, @RequestBody Image image) {
        Image existingImage = imageRepository.getOne(id);
        BeanUtils.copyProperties(image, existingImage, "id");
        return imageRepository.saveAndFlush(existingImage);
    }
}
