package com.example.LordsOfThePlanets.controller;

import com.example.LordsOfThePlanets.Service.ILordService;
import com.example.LordsOfThePlanets.Service.IPlanetService;
import com.example.LordsOfThePlanets.model.Lord;
import com.example.LordsOfThePlanets.model.Planet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes(value = {LordController.LORD})
public class LordController {

    static final String LORD = "lord";

    private final ILordService lordService;

    private final IPlanetService planetService;

    @Autowired
    public LordController(ILordService lordService, IPlanetService planetService) {
        this.lordService = lordService;
        this.planetService = planetService;
    }

    @GetMapping("/lords")
    public String lords(Model model) {
        //показать всех лордов
        List<Lord> lords = lordService.findAll();
        model.addAttribute("lord", lords);
        return "lords";
    }

    @PostMapping("/addLord")
    public String addLord(@RequestParam String name, @RequestParam Integer age) {
        //добавить лорда
        lordService.createLord(name, age);
        return "redirect:/lords";
    }

    @GetMapping("/freeLords")
    public String freeLords(Model model) {
        //показать лордов, не имеющих планет
        List<Lord> freeLords = lordService.findAllFreeLords();
        model.addAttribute("freeLords", freeLords);
        return "freeLords";
    }

    @GetMapping("/top10")
    public String top10(Model model, @RequestParam Integer age) {
        //показать топ 10 самых молодых лордов
        List<Lord> topLord = lordService.findTop10ByYoungLords(age, Boolean.TRUE);
        model.addAttribute("top10YoungerLords", topLord);
        return "top10";
    }

    @PostMapping("/addPlanet")
    //добавить планету лорду
    public String addPlanet(Model model, @RequestParam String name, @SessionAttribute Lord lord) {
        Planet planet = planetService.createPlanet(lord, name);
        lord.getPlanets().add(planet);
        model.addAttribute("planet", planet);
        return "redirect:/allPlanets";
    }

}
