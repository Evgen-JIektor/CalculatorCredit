package ru.calculator.creditCalc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.calculator.creditCalc.model.Calculator;

import javax.validation.Valid;

@Controller
public class CalcController{

    @GetMapping("/calc")
    public String NewCalculator(Calculator calculator) {
        return "calc";
    }

    @PostMapping("/calc")
    public String AddCalc(@ModelAttribute("calculator") @Valid Calculator calculator, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "calc";
        }
    return "calc";
    }

}