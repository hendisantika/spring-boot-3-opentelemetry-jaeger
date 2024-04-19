package id.my.hendisantika.springboot3opentelemetryjaeger.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-3-opentelemetry-jaeger
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 4/19/24
 * Time: 16:38
 * To change this template use File | Settings | File Templates.
 */
@RestController
@Slf4j
public class DemoController {
    @GetMapping("/hello")
    public String index() {
        return "Greetings from Spring Boot! " + LocalDateTime.now();
    }
}
