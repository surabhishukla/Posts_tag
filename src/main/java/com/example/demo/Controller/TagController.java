package com.example.demo.Controller;

import com.example.demo.Dto.TagDto;
import com.example.demo.Entity.Tag;
import com.example.demo.Request.TagRequest;
import com.example.demo.Service.TagService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    @RequestMapping(method = RequestMethod.POST)
    public void createTag(@Valid @RequestBody TagRequest tagRequest) {
        tagService.saveTag(tagRequest);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public void deleteTag(@PathVariable String id) {
        tagService.deleteTag(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json")
    public void updateTag(@Valid @PathVariable String id, @RequestBody Tag tag) {
        tag.setTag_id(id);
        tagService.updateTag(tag);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public TagDto getTagById(@PathVariable String id) {
        Session session = null;
        return tagService.getTagById(id);
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<Tag> getTag() {
        return tagService.getTag();
    }

}
