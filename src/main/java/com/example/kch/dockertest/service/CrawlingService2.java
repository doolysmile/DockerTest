package com.example.kch.dockertest.service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CrawlingService2 {

    private final String DRIVER_ID = "webdriver.chrome.driver";
    //크롬 드라이버 경로 설정
//    private final String DRIVER_PATH = "./src/main/resources/chromedriver.exe";
//    private final String DRIVER_PATH = "./src/main/resources/chromedriver";
    private final String DRIVER_PATH = "/server/src/main/resources/chromedriver";
    public String crawlingTest(String url){
        System.setProperty(DRIVER_ID, DRIVER_PATH);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--window-size=1400,600");
        WebDriver driver = new ChromeDriver(options);
        //url 설정
        String base_url = url;

        String review = "";

        try {
            driver.get(base_url);
            String[] en = driver.findElement(By.className("box_page_msg")).getText().split(" ");


            List<WebElement> element = driver.findElements(By.className("review-contents__text"));
            review = element.get(0).getText();
            System.out.println(review);



        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.close();
        return review;
    }

}
