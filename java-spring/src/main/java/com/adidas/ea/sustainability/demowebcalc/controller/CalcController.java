package com.adidas.ea.sustainability.demowebcalc.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("calc")
public class CalcController {
    
    @RequestMapping("/add/{first}/{second}")
    public Map<String, Object> add(@PathVariable(name = "first", required = true) int first, @PathVariable(name = "second", required = true) int second) {
        return Collections.singletonMap("result", first + second);
    }

    @RequestMapping("/sub/{first}/{second}")
    public Map<String, Object> sub(@PathVariable(name = "first", required = true) int first, @PathVariable(name = "second", required = true) int second) {
        return Collections.singletonMap("result", first - second);
    }

    @RequestMapping("/mul/{first}/{second}")
    public Map<String, Object> mul(@PathVariable(name = "first", required = true) int first, @PathVariable(name = "second", required = true) int second) {
        return Collections.singletonMap("result", first * second);
    }

    @RequestMapping("/div/{first}/{second}")
    public Map<String, Object> div(@PathVariable(name = "first", required = true) int first, @PathVariable(name = "second", required = true) int second) {
        if (second == 0) {
            return Collections.singletonMap("error", "Division by zero");
        }

        return Collections.singletonMap("result", first / second);
    }
}
