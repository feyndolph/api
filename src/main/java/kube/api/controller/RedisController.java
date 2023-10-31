package kube.api.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;



@RestController
@Slf4j
public class RedisController {
    
    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping("/redisTest")
    public ResponseEntity<?> addRedisKey() {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("yellow", "banana");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/redisTest/{key}")
    public ResponseEntity<?> getRedisKey(@PathVariable String key){
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        String value = valueOperations.get(key);
        return new ResponseEntity<>(value, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<?> login(HttpSession httpSession){
        httpSession.setAttribute("uid", "1111");
        return new ResponseEntity<>("로그인 성공", HttpStatus.OK);
    }

    @PostMapping("/sessionTest")
    public String sessionTest(HttpSession httpSession){
        String id = "test123";
        httpSession.setAttribute("sessionID", id);
        return "session Test";
    }

    @GetMapping("/getSessionId")
    public String getSessionId(HttpSession httpSession){
        String sessionId = (String)httpSession.getAttribute("sessionID");
        System.out.println(sessionId);
        return httpSession.getId();
    }
}
