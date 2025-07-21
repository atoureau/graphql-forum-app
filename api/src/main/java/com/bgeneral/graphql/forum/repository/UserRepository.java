package com.bgeneral.graphql.forum.repository;

import com.bgeneral.graphql.forum.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {}
