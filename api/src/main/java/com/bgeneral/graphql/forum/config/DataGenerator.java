package com.bgeneral.graphql.forum.config;

import com.bgeneral.graphql.forum.model.Comment;
import com.bgeneral.graphql.forum.model.Post;
import com.bgeneral.graphql.forum.model.User;
import com.bgeneral.graphql.forum.repository.CommentRepository;
import com.bgeneral.graphql.forum.repository.PostRepository;
import com.bgeneral.graphql.forum.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Esta clase generar data aleatoria en las tablas de la base de datos relacional del proyecto.
 */
@Configuration
public class DataGenerator {
    private static final Random RANDOM = new Random();

    @Bean
    public CommandLineRunner seedData(UserRepository userRepo, PostRepository postRepo, CommentRepository commentRepo) {
        return args -> {
            // 1. Crear usuarios aleatorios.
            final var users = new ArrayList<User>();

            for (var i = 1; i <= 10; i++) {
                User user = new User();
                user.setFirstName("Nombre" + i);
                user.setLastName("Apellido" + i);
                user = userRepo.save(user);
                users.add(user);
            }

            // 2. Crear publicaciones aleatorias.
            final int postCount = RANDOM.nextInt(51) + 50; // 50 a 100

            final List<Post> posts = new ArrayList<>();

            for (var i = 1; i <= postCount; i++) {
                Post post = new Post();
                post.setTitle("Publicación #" + i);
                post.setBody("Este es el cuerpo de la publicación #" + i);
                post.setTags(List.of("Etiqueta" + (i % 5), "common"));
                post.setUpvotes(RANDOM.nextInt(50));
                post.setDownvotes(RANDOM.nextInt(10));
                post.setUser(users.get(RANDOM.nextInt(users.size())));
                post = postRepo.save(post);
                posts.add(post);
            }

            // 3. Crear comentarios aleatorios.
            posts.forEach(post -> {
                final int numComments = RANDOM.nextInt(18) + 3; // 3 a 20

                for (var j = 1; j <= numComments; j++) {
                    final Comment comment = new Comment();
                    comment.setBody("Este es el cuerpo del comentario " + j + " en la publicación #" + post.getId());
                    comment.setUpvotes(RANDOM.nextInt(10));
                    comment.setDownvotes(RANDOM.nextInt(5));
                    comment.setUser(users.get(RANDOM.nextInt(users.size())));
                    comment.setPost(post);
                    commentRepo.save(comment);
                }
            });
        };
    }
}