package com.hangain.accounting.controller;

import com.hangain.accounting.model.Greeting;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class hello {

    private AtomicLong counter = new AtomicLong();

    @RequestMapping("greet/{name}")
    @ResponseBody
    public Greeting sayHello(@PathVariable("name") String name) {
        return new Greeting(counter.incrementAndGet(),name);
    }
}
