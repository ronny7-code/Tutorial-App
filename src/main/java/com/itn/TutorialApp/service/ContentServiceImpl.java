package com.itn.TutorialApp.service;

import com.itn.TutorialApp.entity.Content;
import com.itn.TutorialApp.dao.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@Service
public class ContentServiceImpl implements ContentService{

    @Autowired
    private ContentRepository contentRepository;

    @Override
    public void addContent(Content content) {
        contentRepository.save(content);
    }

    @Override
    public List<Content> getAllContents() {
        return contentRepository.findAll();
    }

    @Override
    public Optional<Content> getContentById(Long id) {
        return contentRepository.findById(id);
    }

    @Override
    public void deleteContentById(Long id) {
        contentRepository.deleteById(id);
    }

    @Override
    public Content updateContent(Content content, Long id) {
        return null;
    }

    @Override
    public void uploadContent(MultipartFile file) {
        try {
            String fileName = file.getOriginalFilename();
            Path path = Paths.get("c://users//asus//desktop//tuteapp_uploads//" + fileName);
            Files.createDirectories(path.getParent());
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

//            String downloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                    .path("/files/download/")
//                    .path(fileName)
//                    .toUriString();


        } catch (IOException e) {
            System.out.println("File upload failed.");
        }

    }
}