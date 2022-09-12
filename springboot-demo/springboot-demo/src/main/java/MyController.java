package com.training.springboot;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
class MyController {
    @GetMapping(value = "/name")
    public String getName() {
        return "Diviya Poorani";
    }

    @GetMapping(value = "/")
    public String getData() {
        return "Springboot testing";
    }

    @GetMapping(value = "/name/{hobby}")
    public String geHobby(@PathVariable("hobby") String hobby) {
        return "My hobby is " + hobby;
    }
}





