package com.example.demo.dal.utils;

import com.example.demo.domain.entities.Comment;
import com.example.demo.domain.entities.FriendShip;
import com.example.demo.domain.entities.Like;
import com.example.demo.domain.entities.Post;
import com.example.demo.domain.entities.User;
import com.example.demo.dal.repositories.CommentRepository;
import com.example.demo.dal.repositories.FriendShipRepository;
import com.example.demo.dal.repositories.LikeRepository;
import com.example.demo.dal.repositories.PostRepository;
import com.example.demo.dal.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final LikeRepository likeRepository;
    private final CommentRepository commentRepository;
    private final FriendShipRepository friendShipRepository;

    @Override
    public void run(String...args) throws Exception {
        if (true) {
            //region USERS

            User user1 = createUser("fredou");
            User user2 = createUser("teddy");

            //endregion

            //region POSTS

            Post post1 = createPost(user1);
            Post post2 = createPost(user2);

            addPostToUser(user1, post1);
            addPostToUser(user2, post2);

            //endregion

            //region LIKES

            Like like1 = createLike(user1, post1);
            Like like2 = createLike(user2, post2);

            // endregion

            //region COMMENTS

            Comment comment1 = createComment(user1, post1);
            Comment comment2 = createComment(user2, post2);

            //endregion

            //region FRIENDSHIPS

            FriendShip fs1 = createFriendShip(user1, user2);
            addFriendShipToUser(user1, fs1);
            addFriendShipToUser(user2, fs1);

            //endregion
        }
    }

    private User createUser(String username) {
        User user = new User();
        user.setUsername(username);
        user.setEmail(username.concat("@gmail.com"));
        user.setPassword("password");
        userRepository.save(user);
        return user;
    }

    private Post createPost(User user) {
        Post post = new Post();
        post.setContent("This is a post");
        post.setCreationDate(LocalDateTime.now());
        post.setUser(user);
        postRepository.save(post);
        return post;
    }

    private Like createLike(User user, Post post) {
        Like like = new Like();
        like.setUser(user);
        like.setPost(post);
        likeRepository.save(like);
        return like;
    }

    private Comment createComment(User user, Post post) {
        Comment comment = new Comment();
        comment.setContent("content");
        comment.setUser(user);
        comment.setPost(post);
        commentRepository.save(comment);
        return comment;

    }

    private FriendShip createFriendShip(User user, User friend) {
        FriendShip fs = new FriendShip();
        fs.setStartDate(LocalDateTime.now());
        fs.setUser(user);
        fs.setFriend(friend);
        friendShipRepository.save(fs);
        return fs;
    }

    private void addPostToUser(User user, Post post) {
        user.getPosts().add(post);
        userRepository.save(user);
    }

    private void addFriendShipToUser(User user, FriendShip fs) {
        user.getFriendships().add(fs);
        userRepository.save(user);
    }


}
