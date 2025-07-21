package com.bgeneral.graphql.forum.resolver;

import com.bgeneral.graphql.forum.model.Post;
import com.bgeneral.graphql.forum.repository.CommentRepository;
import com.bgeneral.graphql.forum.repository.PostRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PostsQueriesResolver {
    private final PostRepository postRepo;
    private final CommentRepository commentRepo;

    public PostsQueriesResolver(PostRepository postRepo, CommentRepository commentRepo) {
        this.postRepo = postRepo;
        this.commentRepo = commentRepo;
    }

    @SchemaMapping(typeName = "PostsQueries", field = "post")
    public Post post(@Argument Integer id) {
        return postRepo.findById(id).orElse(null);
    }

    @SchemaMapping(typeName = "PostsQueries", field = "posts")
    public List<Post> posts(@Argument int page, @Argument int size) {
        final Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
        return postRepo.findAll(pageable).getContent();
    }

    @SchemaMapping(typeName = "PostsQueries", field = "mostPopularPosts")
    public List<Post> mostPopularPosts(@Argument int page, @Argument int size) {
        Pageable pageable = PageRequest.of(page, size);
        return postRepo.findMostPopular(pageable).getContent();
    }

    @SchemaMapping(typeName = "PostsQueries", field = "commentsCount")
    public Integer commentsCount(@Argument Integer postId) {
        return commentRepo.countByPostId(postId);
    }
}