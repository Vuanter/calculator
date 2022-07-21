package com.example.calculator.controller;

import com.example.calculator.service.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String greetings() {
        return "Добро пожаловать в калькулятор";
    }
    @GetMapping("/plus")
    public String plus(@RequestParam Integer num1,
                       @RequestParam Integer num2) {
        if (num1 == null || num2 == null) {
            return "Какой-то параметр не передан";
        }
        return num1 + " + " + num2 + " = " + calculatorService.plus(num1, num2);
    }
    @GetMapping("/minus")
    public String minus(@RequestParam Integer num1,
                        @RequestParam Integer num2) {
        if (num1 == null || num2 == null) {
            return "Какой-то параметр не передан";
        }
        return num1 + " - " + num2 + " = " + calculatorService.minus(num1, num2);
    }
    @GetMapping("/multiply")
    public String multiply(@RequestParam Integer num1,
                           @RequestParam Integer num2) {
        if (num1 == null || num2 == null) {
            return "Какой-то параметр не передан";
        }
        return num1 + " * " + num2 + " = " + calculatorService.multiply(num1, num2);
    }
    @GetMapping("/divide")
    public String divide(@RequestParam Integer num1,
                         @RequestParam Integer num2) {
        if (num1 == null || num2 == null) {
            return "Какой-то параметр не передан";
        }
        if (num2 == 0) {
            return "Делить на 0 нельзя!";
        }
        return num1 + " / " + num2 + " = " + calculatorService.divide(num1, num2);
    }
}
