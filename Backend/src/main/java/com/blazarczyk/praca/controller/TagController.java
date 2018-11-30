package com.blazarczyk.praca.controller;

import com.blazarczyk.praca.model.json.ProjectJson;
import com.blazarczyk.praca.model.json.TagJson;
import com.blazarczyk.praca.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
public class TagController {

    @Autowired
    TagService tagService;

    @RequestMapping(path = "/tags", method = RequestMethod.GET)
    @ResponseBody
    public List<TagJson> getTags(){
        List<TagJson> response = new LinkedList<>();
        tagService.getAllTags().forEach(x -> response.add(new TagJson(x)));

        return response;
    }
}
