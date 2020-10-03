package com.example.registrocomunidad.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import com.example.registrocomunidad.entities.Basico;
import com.example.registrocomunidad.entities.Eps;
import com.example.registrocomunidad.entities.Modalidad;
import com.example.registrocomunidad.entities.Tipo;
import com.example.registrocomunidad.entities.Usuario;
import com.example.registrocomunidad.loginutils.CustomAuthenticationProvider;
import com.example.registrocomunidad.service.BasicoServiceImpl;
import com.example.registrocomunidad.service.EpsServiceImpl;
import com.example.registrocomunidad.service.ModalidadServiceImpl;
import com.example.registrocomunidad.service.TipoServiceImpl;

import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@SessionAttributes("basico")
public class IndexController {

    @Lazy
    @Autowired
    private BasicoServiceImpl basicoImpl;

    @Lazy
    @Autowired
    private TipoServiceImpl tipoImpl;
    
    @Lazy
    @Autowired
    private CustomAuthenticationProvider custom;
    
    @Lazy
    @Autowired
    private EpsServiceImpl epsImpl;
    
    @Lazy
    @Autowired
    private ModalidadServiceImpl modalidadImpl;

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
            return "index";
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
        
        model.addAttribute("titulo", "Iniciar sesion");
        model.addAttribute("universidad", "simon");
        return "login";
    }

    @GetMapping(value = "/login")
    public String loginErrorOrLogout(@RequestParam(value = "error", required = false) String error,
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
        model.addAttribute("basico", basico);
        return "index";

    }

    @GetMapping(value = "/datospersonales/{id}")
    public String crearDatosPersonales(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("titulo", "Datos Personales");
        
        Basico basico = basicoImpl.findById(id);
        List<Tipo> tipo = tipoImpl.findByEmpresa(basico.getTipo().getEmpresa());
        List<Eps> eps = epsImpl.findAll();
        List<Modalidad> modalidad =  modalidadImpl.findAll();
        System.out.println("TAMAÑO AAAAA "+tipo.size());
        model.addAttribute("tipos", tipo);
        model.addAttribute("basico", basico);
        model.addAttribute("epss", eps);
        model.addAttribute("modalidades", modalidad);
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

    @GetMapping(value="/personas/{id}")
    public String mostrarFormPersonas(@PathVariable(value = "id") Long id, Model model){
        model.addAttribute("titulo", "Vive con personas de algunas de estas caracteristicas");
        Basico basico = basicoImpl.findById(id);
        model.addAttribute("basico", basico);
        return "personas";
    }

    @GetMapping(value="/cormobilidad/{id}")
    public String mostrarFormCormobilidad(){
        return "";
    }
}
