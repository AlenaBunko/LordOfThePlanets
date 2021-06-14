package com.example.LordsOfThePlanets.controller;

import com.example.LordsOfThePlanets.Service.IPlanetService;
import com.example.LordsOfThePlanets.model.Planet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PlanetController {

    private final IPlanetService planetService;

    @Autowired
    public PlanetController(IPlanetService planetService) {
        this.planetService = planetService;
    }

    @GetMapping("/allPlanets")
    public String findAllPlanets(Model model) {
        List<Planet> planets = planetService.findAll();
        model.addAttribute("allPlanets", planets);
        return "allPlanets";
    }

    @PostMapping("/delete/{id}")
    public String deletePlanet(@PathVariable("id") Long id) {
        planetService.delete(id);
        return "redirect:/planets";
    }
}
