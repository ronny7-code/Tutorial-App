package com.itn.TutorialApp.controller;

import com.itn.TutorialApp.entity.Content;
import com.itn.TutorialApp.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
public class ContentController {

    private final ContentService contentService;

    @GetMapping("/admin/content/add")
    public String getContentPage(Model model){
        model.addAttribute("content", new Content()); // needed for form binding
        return "admin/content";
    }


    @PostMapping("/admin/content/add")
    public String saveContent(@RequestParam String name,
                              @RequestParam String type,
                              @RequestParam String description,
                              @RequestParam MultipartFile file){
        Content content = new Content();
        content.setName(name);
        content.setType(type);
        content.setDescription(description);
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