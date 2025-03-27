package com.kenny.ecommerceapp.repo;

import com.kenny.ecommerceapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
}
