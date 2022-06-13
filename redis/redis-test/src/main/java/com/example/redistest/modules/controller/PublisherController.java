package com.example.redistest.modules.controller;

import com.example.redistest.modules.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年03月09日 2:26 PM
 */
@RestController
@RequestMapping("publisher")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @RequestMapping("/test/{name}")
    public String sendMessage(@PathVariable("name") String name) {
        return publisherService.sendMessage(name);
    }
}
