package com.kornelzielinski.PhotoShootWebApp;

import com.kornelzielinski.PhotoShootWebApp.model.*;
import com.kornelzielinski.PhotoShootWebApp.repos.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebAppConfiguration
@SpringBootTest
class PhotoShootWebAppApplicationTests {

	@Autowired
	UserRepository userRepository;
	@Autowired
	ImageRepository imageRepository;
	@Autowired
	CommentRepository commentRepository;
	@Autowired
	RatingRepository ratingRepository;
	@Autowired
	CategoryRepository categoryRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createUser() throws IOException {
		File file = new File("/home/korni/Obrazy/no-img.png");
		byte[] fileContent = new byte[(int) file.length()];
		FileInputStream inputStream = new FileInputStream(file);
		inputStream.read(fileContent);

		User user = new User();
		user.setUsername("user1");
		user.setEmail("user1@test.com");
		user.setProfilePic(fileContent);
		user.setPassword("123456");
		user.setCreatedAt("2020-04-10");

		userRepository.save(user);
		inputStream.close();
	}

	@Test
	public void createImage() throws IOException {
		File file = new File("/home/korni/Obrazy/891207.jpg");
		byte[] fileContent = new byte[(int) file.length()];
		FileInputStream inputStream = new FileInputStream(file);
		inputStream.read(fileContent);

		Image image = new Image();
		User user = userRepository.findById(1L).get();
		image.setUser(user);
		image.setData(fileContent);
		image.setDescription("Some nice view...");
		image.setResolution("1920x1080");
		image.setCreatedAt("2020-04-10");

		imageRepository.save(image);
		inputStream.close();
	}

	@Test
	public void addUserWithImage() throws IOException {
		File file = new File("/home/korni/Obrazy/no-img.png");
		byte[] fileContent = new byte[(int) file.length()];
		FileInputStream inputStream = new FileInputStream(file);
		inputStream.read(fileContent);

		User user = new User();
		user.setUsername("user2");
		user.setEmail("user2@test.com");
		user.setProfilePic(fileContent);
		user.setPassword("123456");
		user.setCreatedAt("2020-04-11");

		userRepository.save(user);
		inputStream.close();


		File file1 = new File("/home/korni/Pulpit/ism/PhotoShootWebApp/imgs/photo-1586463497376-5c427c61ad59.jpeg");
		byte[] fileContent1 = new byte[(int) file1.length()];
		FileInputStream inputStream1 = new FileInputStream(file1);
		inputStream1.read(fileContent1);

		Image image = new Image();
		image.setUser(user);
		image.setData(fileContent1);
		image.setDescription("My car...");
		image.setResolution("1920x1080");
		image.setCreatedAt("2020-04-11");

		user.addImage(image);
		userRepository.save(user);
		inputStream.close();
		inputStream1.close();
	}

	@Test
	public void addRating() {
		User user = userRepository.findById(1L).get();
		Image image = imageRepository.findById(1L).get();

		Rating rating = new Rating();
		rating.setUser(user);
		rating.setImage(image);
		rating.setRating(5);

		ratingRepository.save(rating);
	}

	@Test
	public void addCommentToImage() {
		User user = userRepository.findById(2L).get();
		Image image = imageRepository.findById(1L).get();

		Comment comment = new Comment();
		comment.setUser(user);
		comment.setComment("Nice one...");
		comment.setCreated_at("2020-04-10");

		image.addComment(comment);
		imageRepository.save(image);
	}

	@Test
	public void addCategory() {
		Set<Image> images = new HashSet<Image>();
		Set<Category> categories = new HashSet<Category>();

		Category category = new Category();
		category.setName("Cat1");
		category.setNum_images(0);
		categories.add(category);

		for (Image image : imageRepository.findAll()) {
			image.setCategories(categories);
			imageRepository.saveAndFlush(image);
			images.add(image);
		}
		category.setImages(images);
		categoryRepository.save(category);
	}

	@Test
	public void testFindImageByUser() {
		User user = userRepository.findById(1L).get();
		List<Image> imageList = imageRepository.findByUser(user);
		for (Image image : imageList) {
			System.out.println(image.getDescription());
		}
	}

	@Test
	public void testFindImageByCategory() {
		Category category = categoryRepository.findById(2L).get();
		List<Image> imageList = imageRepository.findByCategories(category);
		for (Image image : imageList) {
			System.out.println(image.getDescription());
		}
	}

	@Test
	public void testFindCommentByUser() {
		User user = userRepository.getOne(2L);
		List<Comment> commentList = commentRepository.findByUser(user);
		for (Comment comment : commentList) {
			System.out.println(comment.getComment());
		}
	}

	@Test
	public void testFindCommentByImage() {
		Image image = imageRepository.getOne(1L);
		List<Comment> commentList = commentRepository.findByImage(image);
		for (Comment comment : commentList) {
			System.out.println(comment.getComment());
		}
	}


	@Test
	public void testFindRatingByUser() {
		User user = userRepository.getOne(1L);
		List<Rating> ratingList = ratingRepository.findByUser(user);
		for (Rating rating : ratingList) {
			System.out.println(rating.getRating());
		}
	}

	@Test
	public void testFindRatingByImage() {
		Image image = imageRepository.getOne(1L);
		List<Rating> ratingList = ratingRepository.findByImage(image);
		for (Rating rating : ratingList) {
			System.out.println(rating.getRating());
		}
	}
}
