package com.yanghan.web.controller;

import com.yanghan.web.commpent.UserVailder;
import com.yanghan.web.model.DemoException;
import com.yanghan.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Part;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

/**
 * Created by yanghan on 2019-09-27.
 */
@RestController
public class IndexController {

    @Autowired
    private UserVailder userVailder;

    @GetMapping(value = "/json", produces = APPLICATION_JSON_UTF8_VALUE)
    public User json() {
        User user = new User();
        user.setAge(10);
        user.setName("哈哈");
        return user;
    }

    @GetMapping(value = "/xml", produces = APPLICATION_XML_VALUE)
    public User xml() {
        User user = new User();
        user.setAge(10);
        user.setName("哈哈");
        return user;
    }

    @PostMapping(value = "/json", consumes = APPLICATION_JSON_UTF8_VALUE)
    public User json(@RequestBody User user) {
        return user;
    }

    @PostMapping(value = "/xml", consumes = APPLICATION_XML_VALUE)
    public User xml(@RequestBody User user) {
        return user;
    }

    @PostMapping("/vaild")
    public User vaild(User user) {
        uailderUser(user, userVailder);
        return user;
    }

    private void uailderUser(User user, UserVailder userVailder) {
        DataBinder binder = new DataBinder(user);
        binder.addValidators(userVailder);
        binder.validate();
    }

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(userVailder);
    }

    @PostMapping("/vaild2")
    public User vaild2(@Valid User user) {
        return user;
    }

    @PostMapping("/upload/multipart")
    public String upload(MultipartFile file) {
        String filename = file.getOriginalFilename();
        try {
            file.transferTo(new File(filename));
        } catch (IOException e) {
            return "failed";
        }
        return "success";
    }

    @PostMapping("/upload/part")
    public String upload(Part file) {
        String fileName = file.getSubmittedFileName();
        try {
            file.write(fileName);
        } catch (IOException e) {
            return "failed";
        }
        return "success";
    }

    @GetMapping("/interceptor")
    public String interceptor(){
        return "interceptor";
    }

    @GetMapping("/no/interceptor")
    public String nointerceptor(){
        return "no/interceptor";
    }

    @GetMapping("/demo/exception")
    public String exception(String name){
        if (StringUtils.isEmpty(name)){
            throw new DemoException("name is empty");
        }
        return name;
    }

    @GetMapping("/ex/exception")
    public String exexception(){
        throw new IndexOutOfBoundsException();
    }
}
