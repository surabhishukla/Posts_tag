package com.example.demo.Controller;

import com.example.demo.Dto.PostsDto;
import com.example.demo.Entity.Posts;
import com.example.demo.Request.PostsRequest;
import com.example.demo.Service.PostsService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/posts")
public class PostsController {

    @Autowired
    private PostsService postsService;

    @RequestMapping(method = RequestMethod.POST)
    public void createPosts(@Valid @RequestBody PostsRequest postsRequest) {
        postsService.savePosts(postsRequest);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public void deletePosts(@PathVariable String id) {
        postsService.deletePosts(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json")
    public void updatePosts(@Valid @PathVariable(name = "id") String id, @RequestBody Posts posts) {
        Session session = null;
        posts.setPost_id(id);
        postsService.updatePosts(id, posts, session);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public PostsDto getPostById(@PathVariable String id) {
        Session session = null;
        return postsService.getPostById(id, session);
    }

}
