package com.example.registrocomunidad.controller;

import com.example.registrocomunidad.entities.Usuario;
import com.example.registrocomunidad.service.UsuarioServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ufps")
public class UfpsController {
    
    @Autowired
    private UsuarioServiceImpl usuarioImpl;

    @GetMapping(value="/")
    public String index(Model model){
        model.addAttribute("titulo", "Bienvenido");
        return "index";
    }

    @GetMapping(value = "/datospersonales")
    public String crearDatosPersonales(Model model){
        model.addAttribute("titulo", "Datos Personales");
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "datospersonales";
    }

    @GetMapping(value="/login")
    public String login(Model model){
        model.addAttribute("titulo", "Iniciar sesion");
        model.addAttribute("universidad", "ufps");
        return "login";
    }

}
