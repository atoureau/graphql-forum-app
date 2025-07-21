package com.bgeneral.graphql.forum.resolver;

import com.bgeneral.graphql.forum.model.User;
import com.bgeneral.graphql.forum.repository.UserRepository;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsersQueriesResolver {
    private final UserRepository userRepo;

    public UsersQueriesResolver(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @SchemaMapping(typeName = "UsersQueries", field = "users")
    public List<User> users() {
        return userRepo.findAll();
    }
}