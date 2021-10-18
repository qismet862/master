package com.example.glmrbackend.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;
@Configuration
@EnableWebMvc
public class WebConfiguration  implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/customerProfile/**")
                .addResourceLocations("file:./storage-picture/profilePicture/customer/");
    }

    @Bean
    CommandLineRunner createStorageDirectories() {
        return (args) -> {
            createFolder("storage-picture/profilePicture/master");
            createFolder("storage-picture/profilePicture/customer");
        };
    }

    private void createFolder(String path) {
        File folder = new File(path);
        boolean folderExist = folder.exists() && folder.isDirectory();
        if (!folderExist) {
            folder.mkdirs();
        }
    }
}
