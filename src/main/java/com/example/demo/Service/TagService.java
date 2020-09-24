package com.example.demo.Service;

import com.example.demo.Dao.TagDao;
import com.example.demo.Dto.TagDto;
import com.example.demo.Entity.Tag;
import com.example.demo.Request.TagRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    @Autowired
    private TagDao tagDao;

    public void saveTag(TagRequest tagRequest) {
        Tag tag = new Tag();
        tag.setTag_name(tagRequest.getTag_name());
        tag.setPosts(tagRequest.getPosts());
        tagDao.addTag(tag);
    }

    public TagDto getTagById(String id) {
        Tag tag = tagDao.getTagById(id);
        return TagDto.generateFrom(tag);
    }

    public List<Tag> getTag() {
        return tagDao.getTags();
    }

    public void deleteTag(String id) {
        tagDao.deleteTag(id);
    }

    public void updateTag(Tag tag) {
        tagDao.updateTag(tag);
    }

}
