package cl.tbd.proyecto.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class TestService {
    @GetMapping("/hello")
    public String HelloWorld() {
        return "Hello, world";
    }
}
