package com.uguz.entity;

import javax.persistence.*;

@Entity
@Table(name="comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="contentOfComment")
    private String contentOfComment;

    //,cascade = {CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.MERGE}

    @ManyToOne(fetch =FetchType.EAGER)
    @JoinColumn(name ="postId")
    private Post post;

    public Comment() {
    }

    public Long getId() {
        return id;
    }

//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getContentOfComment() {
        return contentOfComment;
    }

    public void setContentOfComment(String contentOfComment) {
        this.contentOfComment = contentOfComment;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
