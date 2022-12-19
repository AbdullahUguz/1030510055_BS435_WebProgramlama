package com.uguz.ejb;

import com.uguz.entity.Comment;
import com.uguz.entity.Post;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class CommentEjb {

    @PersistenceContext
    private EntityManager entityManager;

    public Long createCommentByPost(long postId, String contentOfComment) {
        PostEjb postEjb = new PostEjb();
        Post post = postEjb.getPostById(postId);

        Comment comment1 = new Comment();

        comment1.setContentOfComment(contentOfComment);
        comment1.setPost(post);
        entityManager.persist(comment1);

        return comment1.getId();
    }

    public Comment getCommentById(long commnetId) {

        Comment comment = entityManager.find(Comment.class, commnetId);

        return comment;
    }

    public List<Comment> getComments() {
        TypedQuery<Comment> query = entityManager.createQuery("select c from Comment c", Comment.class);
        return query.getResultList();
    }
}