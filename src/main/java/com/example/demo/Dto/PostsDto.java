package com.example.demo.Dto;

import com.example.demo.Entity.Posts;
import com.example.demo.Entity.Tag;

import java.util.Set;

public class PostsDto {

    private String post_id;

    private String post_name;

    private String post_title;

    private Set<Tag> tags;

    public String getPost_id() {
        return post_id;
    }

    public void setPost_id(String post_id) {
        this.post_id = post_id;
    }

    public String getPost_name() {
        return post_name;
    }

    public void setPost_name(String post_name) {
        this.post_name = post_name;
    }

    public String getPost_title() {
        return post_title;
    }

    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public static PostsDto generateFrom(Posts posts) {
        PostsDto postsDto = new PostsDto();
        postsDto.setPost_id(posts.getPost_id());
        postsDto.setPost_name(posts.getPost_name());
        postsDto.setPost_title(posts.getPost_title());
        postsDto.setTags(posts.getTags());
        return postsDto;

    }
}
