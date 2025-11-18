package com.itn.TutorialApp.controller;

import com.itn.TutorialApp.entity.Content;
import com.itn.TutorialApp.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Controller
public class ContentController {

    @Autowired
    private ContentService contentService;

    @PostMapping("/admin/content/add")
    public String saveContent(@RequestParam String name,
                              @RequestParam String type,
                              @RequestParam String description,
                              @RequestParam MultipartFile file){
        Content content = new Content();
        content.setName(name);
        content.setType(type);
        content.setDescription(type);
        //content.setFile(file);  // do not save file into database
        content.setFileName(file.getOriginalFilename());
        content.setAddedDate(LocalDate.now());

        // send to upload the content file
        contentService.uploadContent(file);
        // after upload save content object into database
        contentService.addContent(content);
        return "redirect:/admin/content/show";
    }
}