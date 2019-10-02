package com.yanghan.base;

import com.yanghan.base.model.DemoProperties;
import com.yanghan.base.service.Animal;
import com.yanghan.customestarter.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = RedisAutoConfiguration.class)
@RestController
public class BaseApplication {
    @Value("${book.author}")
    private String author;

    @Value("${book.age}")
    private int age;

    @Value("#{T(System).currentTimeMillis()}")
    private long timestamp;

    @Value("#{'Spring EL'}")
    private String str;

    @Value("#{demoProperties.author}")
    private String authorTwo;

    @Value("#{demoProperties.author?.toUpperCase()}")
    private String upAuthor;

    @Value("#{demoProperties.author eq 'hellsinner'}")
    private boolean isHellsinner;

    @Value("#{demoProperties.age gt 5}")
    private boolean isAgeGtFive;

    @Autowired
    private DemoProperties properties;

    @Autowired
    private HelloService helloService;

    @Autowired
    private Animal dog;

    @Autowired
    @Qualifier("cat")
    private Animal animal;

    public static void main(String[] args) {
//        SpringApplication application = new SpringApplication(BaseApplication.class);
//        application.setBannerMode(Banner.Mode.OFF);
//        application.run(args);
        SpringApplication.run(BaseApplication.class, args);
    }

    @GetMapping("/index")
    public String index() {
        System.out.println(author + " : " + age);
        System.out.println(properties.getAuthor() + " : " + properties.getAge());
        helloService.hello();
        return "index";
    }

    @GetMapping("/dog")
    public void dog() {
        dog.say();
    }

    @GetMapping("/cat")
    public void cat() {
        animal.say();
    }

    @GetMapping("/spring/el")
    public String el() {
        System.out.println(timestamp);
        System.out.println(str);
        System.out.println(authorTwo);
        System.out.println(isHellsinner);
        System.out.println(upAuthor);
        System.out.println(isAgeGtFive);
        return "OK";
    }


}
