package com.eternity.admin.controller;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Slf4j
@Controller
public class FromTestController {

    @GetMapping("/form_layouts")
    public String from_layouts(){
        return "form/form_layouts";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("headerImg") MultipartFile headImg,
                         @RequestPart("photos") MultipartFile[] photos) throws IOException {
        log.info("email={},username={},headImg={},photos={}",email,username,headImg.getSize(),photos.length);
        if (!headImg.isEmpty()){
            String originalFilename = headImg.getOriginalFilename();
            headImg.transferTo(new File("E:\\"+originalFilename));
        }

        if (photos.length>0){
            for (MultipartFile photo : photos) {
                if(!photo.isEmpty()){
                    String filename = photo.getOriginalFilename();
                    photo.transferTo(new File("E:\\"+filename));
                }
            }
        }
        return "main";
    }


}
