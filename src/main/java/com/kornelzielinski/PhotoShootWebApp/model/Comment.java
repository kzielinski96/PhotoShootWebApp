package com.kornelzielinski.PhotoShootWebApp.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;

@Entity(name="comments")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "image_id")
    @JsonIgnoreProperties(value = {"user", "image", "description", "resolution", "comments", "ratings", "categories"})
    private Image image;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties(value = {"email", "profilePic", "password", "createdAt", "images"})
    private User user;

    private String comment;

    @Column(name = "created_at")
    private String createdAt;

    public Comment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
