package com.example.myapp2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
  @RequestMapping("/api/hello/string")
  public String sayHello() {
    return "Hello Hannah Weiss!";
  }
  @RequestMapping("/api/hello/object")
  public HelloObject sayHelloObject() {
    HelloObject obj = new HelloObject("Hello Hannah Weiss!");
    return obj;
  }
}
