package com.uguz.ejb;

import com.uguz.entity.Post;
import com.uguz.entity.Role;
import com.uguz.entity.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class UserEjb {

    @PersistenceContext
    private EntityManager entityManager;

    public Long createUser(String userName,String password){
        User user1= new User();
        user1.setUserName(userName);
        user1.setPassword(password);

        entityManager.persist(user1);

        return user1.getId();
    }

    public User getUserById(long userId){

        User user = entityManager.find(User.class,userId);

        return user;
    }

    public Role getUserRole(long roleId){
        TypedQuery<Role> query = entityManager.createQuery("select r from Role r where r.id =:roleId ", Role.class);
        query.setParameter("roleId", roleId);

        return query.getSingleResult();
    }

    public List<User> getUsers() {
        TypedQuery<User> query = entityManager.createQuery("select u from User u", User.class);
        return query.getResultList();
    }

    public List<Post> getUserAllPost(long userId){
        TypedQuery<Post> query = entityManager.createQuery("select p from Post p where p.user.id=:userId", Post.class);
        query.setParameter("userId", userId);

        return query.getResultList();
    }




}