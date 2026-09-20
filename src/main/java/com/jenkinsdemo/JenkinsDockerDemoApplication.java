package com.jenkinsdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class JenkinsDockerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JenkinsDockerDemoApplication.class, args);
    }

    @GetMapping("/")
    public String home() {
        return "<h1>Jenkins CI/CD Demo</h1>"
             + "<p>Application deployed successfully!</p>"
             + "<p>GitHub → Jenkins → Maven → Test → SonarQube → Docker</p>";
    }
}