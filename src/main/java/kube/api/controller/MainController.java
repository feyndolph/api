package kube.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MainController {
    @GetMapping("/")
    public String main(){
        System.out.println("Main 페이지 요청");
        return "index";
    }
}
