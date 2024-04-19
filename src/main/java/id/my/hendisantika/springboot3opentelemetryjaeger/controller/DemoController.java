package id.my.hendisantika.springboot3opentelemetryjaeger.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Random;

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
    Random random = new Random();

    private RestTemplate restTemplate;
    @Value("${spring.application.name}")
    private String applicationName;

    @GetMapping("/hello")
    public String index() {
        return "Greetings from Spring Boot! " + LocalDateTime.now();
    }

    @GetMapping("/path1")
    public ResponseEntity<String> path1() {
        log.info("Incoming request at {} for request /path1 ", applicationName);
        doNothingButSleepForSomeTime();
        String response = restTemplate.getForObject("http://localhost:8080/hello/path2", String.class);
        doNothingButSleepForSomeTime();
        return ResponseEntity.ok("response from /path1 + " + response);
    }

    @GetMapping("/path2")
    public ResponseEntity<String> path2() {
        log.info("Incoming request at {} at /path2", applicationName);
        doNothingButSleepForSomeTime();
        return ResponseEntity.ok("response from /path2 ");
    }

    public void doNothingButSleepForSomeTime() {
        try {
            int sleepTime = random.nextInt(1, 2);
            log.info("sleeping for " + sleepTime + " seconds");
            Thread.sleep(sleepTime * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
