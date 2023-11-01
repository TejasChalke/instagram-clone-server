package com.example.instagramcloneserver.admincred;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdmincredRepository extends JpaRepository<Admincred, Integer> {
    Admincred findByEmailAndPass(String email, String pass);
}
