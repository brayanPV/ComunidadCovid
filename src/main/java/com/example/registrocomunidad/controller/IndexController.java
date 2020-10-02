package com.example.registrocomunidad.controller;

import java.security.Principal;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@SessionAttributes("basico")
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
    public String home(Model model) {
        model.addAttribute("titulo", "Bienvenido");
        return "home";
    }

    @RequestMapping(value = "/ufps/login")
    public String loginUFPS(@RequestParam(value = "logout", required = false) String logout, Model model,
            Principal principal, RedirectAttributes flash) {
        if (principal != null) {
            flash.addFlashAttribute("info", "Usted ya ha iniciado sesion en el sistema");
            System.out.println(principal.getName());
            return "redirect:/index";
        }
        if (logout != null) {
            model.addAttribute("success", "Ha cerrado sesión con exito");
        }
        model.addAttribute("titulo", "Iniciar sesion");
        model.addAttribute("universidad", "ufps");
        return "login";
    }

    @RequestMapping(value = "/colport/login")
    public String loginSimon(@RequestParam(value = "logout", required = false) String logout, Model model,
            Principal principal, RedirectAttributes flash) {
        if (principal != null) {
            flash.addFlashAttribute("info", "Usted ya ha iniciado sesion en el sistema");
            System.out.println(principal.getName());
            return "redirect:/index";
        }
        if (logout != null) {
            model.addAttribute("success", "Ha cerrado sesión con exito");
            flash.addFlashAttribute("success", "Ha cerrado sesión con exito");
            return "redirect:/home";
        }
        model.addAttribute("titulo", "Iniciar sesion");
        model.addAttribute("universidad", "simon");
        return "login";
    }

    @GetMapping(value = "/login")
    public String loginErrororLogout(@RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout, Model model, Principal principal,
            RedirectAttributes flash) {
        if (error != null) {
            model.addAttribute("error", "Usuario o contraseña incorrecta");
            flash.addFlashAttribute("error", "Usuario o contraseña incorrecta");
            return "home";
        }
        if (logout != null) {
            model.addAttribute("info", "Ha cerrado sesión con exito");
            flash.addFlashAttribute("info", "Ha cerrado sesión con exito");
            return "home";
        }
        return "index";
    }

    @GetMapping(value = "/index")
    public String index(Model model, Principal principal) {
        String documento = principal.getName();
        Basico basico = basicoImpl.findByDocumento(documento);
        model.addAttribute("titulo", "Bienvenido " + basico.getNombre());

        return "index";

    }

    @GetMapping(value = "/datospersonales")
    public String crearDatosPersonales(Model model) {
        model.addAttribute("titulo", "Datos Personales");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String documento = auth.getName();
        Basico basico = basicoImpl.findByDocumento(documento);
        model.addAttribute("basico", basico);
        return "datospersonales";
    }

    @RequestMapping(value = "/formdatos", method = RequestMethod.POST)
    public String actualizarDatosPersonales(@Valid Basico basico, Model model, RedirectAttributes flash,
            SessionStatus status) {
        if (basico.getId() != null) {
            basicoImpl.save(basico);
            status.setComplete();
            String mensajeFlash = "Datos actualizados con exito";
            flash.addFlashAttribute("success", mensajeFlash);
            return "redirect:index";
        }
        return "";
    }
}
