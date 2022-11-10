package com.uguz.test;

import com.uguz.entity.Comment;
import com.uguz.entity.Post;
import com.uguz.entity.Role;
import com.uguz.entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InsertTest {

    private EntityManagerFactory factory;
    private EntityManager em;

    @BeforeEach
    public void init() {
        factory = Persistence.createEntityManagerFactory("Hibernate");
        em = factory.createEntityManager();
    }

    @AfterEach
    public void tearDown() {
        em.close();
        factory.close();
    }

    private boolean persistInATransaction(Object obj) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            em.persist(obj);
            tx.commit();
        } catch (Exception e) {
            System.out.println("FAILED TRANSACTION: " + e.toString());
            tx.rollback();
            return false;
        }

        return true;
    }


    @Test
    public void insertUser() {

        User user1 = new User();
        boolean persisted = persistInATransaction(user1);
        assertTrue(persisted);
    }

    @Test
    public void insertRole() {

        Role role1 = new Role();
        boolean persisted = persistInATransaction(role1);
        assertTrue(persisted);
    }

    @Test
    public void insertPost() {

        Post post1 = new Post();
        boolean persisted = persistInATransaction(post1);
        assertTrue(persisted);

    }

    @Test
    public void insertComment() {

        Comment comment1 = new Comment();
        boolean persisted = persistInATransaction(comment1);
        assertTrue(persisted);
    }

}
