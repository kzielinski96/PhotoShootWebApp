package com.kornelzielinski.PhotoShootWebApp.web;

import com.kornelzielinski.PhotoShootWebApp.model.Category;
import com.kornelzielinski.PhotoShootWebApp.model.Comment;
import com.kornelzielinski.PhotoShootWebApp.repos.CategoryRepository;
import com.kornelzielinski.PhotoShootWebApp.repos.CommentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping()
    public List<Comment> list() {
        return commentRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Comment get(@PathVariable Long id) {
        return commentRepository.getOne(id);
    }

    @PostMapping
    public void create(@RequestBody final Comment comment) {
        commentRepository.saveAndFlush(comment);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        commentRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Comment update(@PathVariable Long id, @RequestBody Comment comment) {
        Comment existingComment = commentRepository.getOne(id);
        BeanUtils.copyProperties(comment, existingComment, "id");
        return commentRepository.saveAndFlush(existingComment);
    }
}
