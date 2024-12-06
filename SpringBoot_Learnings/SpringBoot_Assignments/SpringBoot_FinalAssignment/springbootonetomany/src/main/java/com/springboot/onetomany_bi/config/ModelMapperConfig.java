package com.springboot.onetomany_bi.config;


import com.springboot.onetomany_bi.service.CommentService;
import com.springboot.onetomany_bi.service.PostService;
import com.springboot.onetomany_bi.service.impl.CommentServiceImpl;
import com.springboot.onetomany_bi.service.impl.PostServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {


    @Bean
    public ModelMapper modelMapperBean() {
        return new ModelMapper();
    }

    // Bean for CommentService
    @Bean
    public CommentService commentService() {
        return new CommentServiceImpl();
    }

    // Bean for PostService
    @Bean
    public PostService postService() {
        return new PostServiceImpl();
    }

}
