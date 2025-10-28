package com.AyushDwivedi.SpingBootProject.repository;

import com.AyushDwivedi.SpingBootProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
