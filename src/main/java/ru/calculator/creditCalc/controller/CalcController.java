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
      //  model.addAttribute("calculator", new Calculator());
        return "calc";
    }

    @PostMapping("/calc")
    public String AddCalc(@ModelAttribute("calculator") @Valid Calculator calculator, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return "calc";
        }

    return "calc";
    }

   /* @RequestMapping(value="/calc", method=RequestMethod.GET)
    public String showForm(Calculator calculator) {
        return "form";
    }*/

   /* @RequestMapping(value="/calc", method= RequestMethod.POST)
    public String checkPersonInfo( Calculator calculator, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        return "calc";
    }*/

/*    @GetMapping("/newCalc")
    public String AddNewCalculator(Model model) {
       model.addAttribute("calculator", new Calculator());
        return "/newCalc";
    }*/

}