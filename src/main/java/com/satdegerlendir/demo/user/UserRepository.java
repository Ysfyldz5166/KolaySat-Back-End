package com.satdegerlendir.demo.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<user, Long>{
    
    user findByEmail(String email);
}
