package com.example.demo.Request;

import com.example.demo.Entity.Posts;

import javax.validation.constraints.NotNull;
import java.util.Set;

public class TagRequest {

    @NotNull(message = "should not be NULL")
    private String tag_name;

    private Set<Posts> posts;

    public String getTag_name() {
        return tag_name;
    }

    public void setTag_name(String tag_name) {
        this.tag_name = tag_name;
    }

    public Set<Posts> getPosts() {
        return posts;
    }

    public void setPosts(Set<Posts> posts) {
        this.posts = posts;
    }
}
