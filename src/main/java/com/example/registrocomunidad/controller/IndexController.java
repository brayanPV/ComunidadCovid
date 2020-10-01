package com.example.registrocomunidad.controller;

import com.example.registrocomunidad.entities.Basico;
import com.example.registrocomunidad.entities.Usuario;
import com.example.registrocomunidad.loginutils.CustomAuthenticationProvider;
import com.example.registrocomunidad.service.BasicoServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @Autowired
    private BasicoServiceImpl basicoImpl;

    @Autowired
    private CustomAuthenticationProvider custom;


    @RequestMapping("/")
    public String root() {
        return "redirect:/home";
    }

    @RequestMapping("/home")
    public String index(Model model) {
        model.addAttribute("titulo", "Bienvenido");
        return "home";
    }

    @RequestMapping(value="/ufps/login")
    public String loginUFPS(Model model){
        model.addAttribute("titulo", "Iniciar sesion");
        model.addAttribute("universidad", "ufps");
        return "login";
    }

    @RequestMapping(value="/colport/login")
    public String loginSimon(Model model){
        model.addAttribute("titulo", "Iniciar sesion");
        model.addAttribute("universidad", "simon");
        return "login";
    }

    @GetMapping(value = "/datospersonales")
    public String crearDatosPersonales(Model model){
        model.addAttribute("titulo", "Datos Personales");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String documento = auth.getName();
        Basico basico = basicoImpl.findByDocumento(documento);
        model.addAttribute("basico", basico);
        return "datospersonales";
    }
}
