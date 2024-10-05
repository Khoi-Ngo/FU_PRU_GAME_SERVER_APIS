package pru.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pru.demo.SimpleGameService;
import pru.demo.dtos.LoginRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/v1")
public class SimpleGameController {
    @Autowired
    private SimpleGameService simpleGameService;

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(simpleGameService.checkLogin(request));
    }

    @GetMapping("questions")
    public ResponseEntity<?> getQuestions() {
        return ResponseEntity.ok(simpleGameService.getAllQuestions());

    }
}
