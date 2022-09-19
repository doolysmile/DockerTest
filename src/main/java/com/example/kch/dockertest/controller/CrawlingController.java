package com.example.kch.dockertest.controller;

import com.example.kch.dockertest.service.CrawlingService;
import com.example.kch.dockertest.service.CrawlingService2;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CrawlingController {

    private final CrawlingService crawlingService;
    private final CrawlingService2 crawlingService2;

    @GetMapping("/crawling")
    public ResponseEntity<String> crawlingTest(){
        return ResponseEntity.status(HttpStatus.OK).body(crawlingService.crawlingTest("https://www.musinsa.com/app/goods/1885631"));
    }
    @GetMapping("/crawling2")
    public ResponseEntity<String> crawlingTest2(){
        return ResponseEntity.status(HttpStatus.OK).body(crawlingService2.crawlingTest("https://www.musinsa.com/app/goods/1885631"));
    }
}
