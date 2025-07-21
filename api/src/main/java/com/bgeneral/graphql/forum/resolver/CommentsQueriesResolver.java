package com.bgeneral.graphql.forum.resolver;

import com.bgeneral.graphql.forum.model.Comment;
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
public class CommentsQueriesResolver {
    private final CommentRepository commentRepo;
    private final PostRepository postRepo;

    public CommentsQueriesResolver(CommentRepository commentRepo, PostRepository postRepo) {
        this.commentRepo = commentRepo;
        this.postRepo = postRepo;
    }

    @SchemaMapping(typeName = "CommentsQueries", field = "comments")
    public List<Comment> comments(@Argument Integer postId, @Argument int page, @Argument int size) {
        final Post post = postRepo.findById(postId).orElse(null);
        final Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
        return commentRepo.findByPost(post, pageable).getContent();
    }

    @SchemaMapping(typeName = "CommentsQueries", field = "mostPopularComments")
    public List<Comment> mostPopularComments(@Argument Integer postId, @Argument int page, @Argument int size) {
        final Pageable pageable = PageRequest.of(page, size);
        return commentRepo.findMostPopularByPostId(postId, pageable).getContent();
    }
}