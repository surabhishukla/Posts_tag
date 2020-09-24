package com.example.demo.Dto;

import com.example.demo.Entity.Posts;
import com.example.demo.Entity.Tag;

import java.util.Set;

public class TagDto {

    private String tag_id;

    private String tag_name;

    private Set<Posts> posts;

    public String getTag_id() {
        return tag_id;
    }

    public void setTag_id(String tag_id) {
        this.tag_id = tag_id;
    }

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

    public static TagDto generateFrom(Tag tag) {
        TagDto tagDto = new TagDto();
        tagDto.setTag_id(tag.getTag_id());
        tagDto.setTag_name(tag.getTag_name());
        tagDto.setPosts(tag.getPosts());
        return tagDto;
    }
}
