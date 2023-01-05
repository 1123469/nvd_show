package com.example.mpdemo.contoller;

import com.example.mpdemo.service.FaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private FaceService faceService;

    @RequestMapping("/face")
    public void face() throws IOException {
        faceService.faceRecognition();
    }

}
