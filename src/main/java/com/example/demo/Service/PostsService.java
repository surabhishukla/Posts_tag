package com.example.demo.Service;

import com.example.demo.Dao.PostsDao;
import com.example.demo.Dto.PostsDto;
import com.example.demo.Entity.Posts;
import com.example.demo.Request.PostsRequest;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostsService {

    @Autowired
    private PostsDao postsDao;

    public void savePosts(PostsRequest postsRequest) {
        Posts posts = new Posts();
        posts.setPost_name(postsRequest.getPost_name());
        posts.setPost_title(postsRequest.getPost_title());
        posts.setTags(postsRequest.getTags());
        postsDao.addPosts(posts);
    }

    public PostsDto getPostById(String id, Session session) {
        Posts posts = postsDao.getPostsById(id, session);
        return PostsDto.generateFrom(posts);
    }

    public void deletePosts(String id) {
        postsDao.deletePosts(id);
    }

    public void updatePosts(String id, Posts posts, Session session) {
        postsDao.getPostsById(id, session);
        postsDao.updatePosts(id, posts);
    }


}
