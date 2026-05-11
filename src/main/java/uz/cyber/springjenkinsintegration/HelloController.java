package uz.cyber.springjenkinsintegration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "Salom! Bu loyiha Jenkins orqali avtomatik yig'ildi! yangilik kiritildi";
    }
}