package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 文件上传测试
 */
@Controller
@Slf4j
public class formController {
    @GetMapping("/form_layouts")
    public String form(){
        return "/form/form_layouts";
    }

    /**
     * MultipartFile 会自动封装上传的文件
     * @param email
     * @param username
     * @param headerImg
     * @param photos
     * @return
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("headerImg")MultipartFile headerImg,
                         @RequestPart("photos") MultipartFile[] photos
                         ) throws IOException {

        log.info("上传的信息:email{},username={},headerImg={},photo={}",
                email,username,headerImg.getSize(),photos.length);
        if (!headerImg.isEmpty()){
            //保存到文件服务器，OOS服务器
            String originalFilename = headerImg.getOriginalFilename();
            headerImg.transferTo(new File("H:\\cache\\"+originalFilename));
        }
        if (photos.length>0){
            for (MultipartFile photo : photos) {
                String originalFilename = photo.getOriginalFilename();
                photo.transferTo(new File("H:\\cache\\"+originalFilename));
            }
        }

        return "main";
    }
}
