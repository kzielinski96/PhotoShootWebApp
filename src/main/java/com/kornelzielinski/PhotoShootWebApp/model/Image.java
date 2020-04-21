package com.kornelzielinski.PhotoShootWebApp.model;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "images")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties(value = {"images", "profilePic"})
    private User user;

    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    private byte[] image;

    private String description;
    private String resolution;
    @Column(name = "created_at")
    private String createdAt;

    @OneToMany(mappedBy = "image", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Comment> comments;

    @OneToMany(mappedBy = "image", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Rating> ratings;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "images_categories",
                joinColumns = @JoinColumn(name = "image_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
    private Set<Category> categories;

    public Image() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] data) {
        this.image = data;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Set<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(Set<Rating> ratings) {
        this.ratings = ratings;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public void addComment(Comment comment) {
        if (comment != null) {
            if (comments == null) {
                comments = new HashSet<>();
            }
            comment.setImage(this);
            comments.add(comment);
        }
    }

    public void addRating(Rating rating) {
        if (rating != null) {
            if (ratings == null) {
                ratings = new HashSet<>();
            }
            rating.setImage(this);
            ratings.add(rating);
        }
    }
}
