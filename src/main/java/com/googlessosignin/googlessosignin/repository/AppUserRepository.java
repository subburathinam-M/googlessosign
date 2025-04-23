package com.googlessosignin.googlessosignin.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.googlessosignin.googlessosignin.entity.AppUser;

public interface AppUserRepository extends MongoRepository<AppUser, String> {

    Optional<AppUser> findByEmail(String email);

}
