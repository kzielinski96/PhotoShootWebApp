package com.kornelzielinski.PhotoShootWebApp.repos;

import com.kornelzielinski.PhotoShootWebApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
