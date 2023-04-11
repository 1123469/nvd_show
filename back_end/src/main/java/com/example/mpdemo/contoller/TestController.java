package com.example.mpdemo.contoller;

import com.example.mpdemo.service.FaceService;
import com.example.mpdemo.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
//    private FaceService faceService;
    private MyService myService;

    @RequestMapping("/face")
    public void face() throws IOException {
        myService.faceRecognition();
    }

    @GetMapping ("/cve")
    public void cve() throws IOException {
//        String cveType = myService.getCVEType();
//        System.out.println("Controller:-------------"+cveType);
    }

}
