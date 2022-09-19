package com.example.kch.dockertest.controller;

import com.example.kch.dockertest.util.Util;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/sample")
    public String sample() {
        return "Sample!!";
    }

    @RequestMapping("/file/default")
    public String fileDefault(){

        Util.file.mkdir("ccc_tmp");
        Util.file.saveToFile("ccc_tmp" + "/ccc", "test");
        return "file!!";
    }
    @RequestMapping("/file/root")
    public String fileRoot(){

        Util.file.mkdir("/kkk_tmp");
        Util.file.saveToFile("/kkk_tmp" + "/kkk", "test");
        return "file!!";
    }

}
