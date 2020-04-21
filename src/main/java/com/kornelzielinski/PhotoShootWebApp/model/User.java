package com.kornelzielinski.PhotoShootWebApp.model;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name="users")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;

    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    @Column(name = "profile_pic")
    private byte[] profilePic;

    private String password;
    @Column(name = "created_at")
    private String createdAt;

    @JsonIgnoreProperties(value = {"user", "comments", "ratings", "categories"})
    @OneToMany(mappedBy = "user", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Image> images;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Comment> comments;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Rating> ratings;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(byte[] profilePic) {
        this.profilePic = profilePic;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", created_at='" + createdAt + '\'' +
                ", images=" + images +
                '}';
    }

    public void addImage(Image image) {
        if (image != null) {
            if (images == null) {
                images = new HashSet<>();
            }
            image.setUser(this);
            images.add(image);
        }
    }

    public void addComment(Comment comment) {
        if (comment != null) {
            if (comments == null) {
                comments = new HashSet<>();
            }
            comment.setUser(this);
            comments.add(comment);
        }
    }

    public void addRating(Rating rating) {
        if (rating != null) {
            if (ratings == null) {
                ratings = new HashSet<>();
            }
            rating.setUser(this);
            ratings.add(rating);
        }
    }
}
