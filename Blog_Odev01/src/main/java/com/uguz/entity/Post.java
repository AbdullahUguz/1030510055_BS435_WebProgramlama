package com.uguz.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name="contentOfPost")
    private String contentOfPost;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="userId")
    private User user;

    @OneToMany(mappedBy = "post",fetch = FetchType.LAZY)
    private List<Comment> comments=new ArrayList<Comment>();

    public Long getId() {
        return id;
    }

//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContentOfPost() {
        return contentOfPost;
    }

    public void setContentOfPost(String contentOfPost) {
        this.contentOfPost = contentOfPost;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
