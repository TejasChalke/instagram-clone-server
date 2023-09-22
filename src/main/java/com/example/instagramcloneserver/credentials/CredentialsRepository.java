package com.example.instagramcloneserver.credentials;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CredentialsRepository extends JpaRepository<Credentials, Integer> {
    Credentials findByEmailAndPass(String email, String pass);

    Credentials findByEmail(String email);
}
