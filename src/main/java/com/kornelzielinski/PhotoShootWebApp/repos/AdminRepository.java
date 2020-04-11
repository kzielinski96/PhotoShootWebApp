package com.kornelzielinski.PhotoShootWebApp.repos;

import com.kornelzielinski.PhotoShootWebApp.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
