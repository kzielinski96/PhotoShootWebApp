package com.kornelzielinski.PhotoShootWebApp.web;

import com.kornelzielinski.PhotoShootWebApp.model.Admin;
import com.kornelzielinski.PhotoShootWebApp.model.User;
import com.kornelzielinski.PhotoShootWebApp.repos.AdminRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    @GetMapping()
    public List<Admin> list() {
        return adminRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Admin get(@PathVariable Long id) {
        return adminRepository.getOne(id);
    }

    @PostMapping
    public void create(@RequestBody final Admin admin) {
        adminRepository.saveAndFlush(admin);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        adminRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Admin update(@PathVariable Long id, @RequestBody Admin admin) {
        Admin existingAdmin = adminRepository.getOne(id);
        BeanUtils.copyProperties(admin, existingAdmin, "id");
        return adminRepository.saveAndFlush(existingAdmin);
    }
}