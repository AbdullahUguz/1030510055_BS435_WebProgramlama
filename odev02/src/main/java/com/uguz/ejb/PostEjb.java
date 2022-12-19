package com.uguz.ejb;

import com.uguz.entity.Post;
import com.uguz.entity.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class PostEjb {

    @PersistenceContext
    private EntityManager entityManager;

    public Long createPostByUser(long userId,String contentOfPost,String postTitle){
        UserEjb userEjb = new UserEjb();
        User user = userEjb.getUserById(userId);

        Post post1= new Post();

        post1.setContentOfPost(contentOfPost);
        post1.setTitle(postTitle);
        post1.setUser(user);

        entityManager.persist(post1);

        return post1.getId();
    }

    public Post getPostById(long postId){

        Post post = entityManager.find(Post.class,postId);

        return post;
    }

    public List<Post> getPosts() {
        TypedQuery<Post> query = entityManager.createQuery("select p from Post p", Post.class);
        return query.getResultList();
    }

    public List<Post> getPostAllComment(long postId){
        TypedQuery<Post> query = entityManager.createQuery("select c from Comment c where c.post.id=:postId", Post.class);
        query.setParameter("postId", postId);

        return query.getResultList();
    }


}