package com.example.registrocomunidad.loginutils;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.example.registrocomunidad.entities.Basico;
import com.example.registrocomunidad.entities.Empresa;
import com.example.registrocomunidad.entities.Tipo;
import com.example.registrocomunidad.service.BasicoServiceImpl;
import com.example.registrocomunidad.service.EmpresaServiceImpl;
import com.example.registrocomunidad.service.TipoServiceImpl;

import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Lazy
    @Autowired
    BasicoServiceImpl basicoDao;

    @Lazy
    @Autowired
    TipoServiceImpl tipoDao;

    @Autowired(required = false)
    private HttpServletRequest request;

    private String url;
    private String documento;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String endpoint = request.getParameter("endpoint");
        System.out.println("request testing= " + endpoint);
        String name = authentication.getName();
        System.out.println("EL NOMBRE ES: " + name);
        String password = authentication.getCredentials().toString();
        System.out.println("LA CONTRASEÑA ES: " + password);
        if (endpoint != null) {
            if (endpoint.equalsIgnoreCase("ufps")) {
                System.out.println("AQUI ES UFPS");
                url = "http://siaweb.ufps.edu.co/prueba.php";
            } else {
                url = "http://siaweb.ufps.edu.co/unisimon.php";
            }
            System.out.println("DOMINIO: " + url);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

            MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
            map.add("documento", name);
            map.add("clave", password);

            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map,
                    headers);

            RestTemplate restTemplate = new RestTemplate();
            System.out.println("AAAAA EL NAME " + name);
            ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
            System.out.println(response.getBody());

            try {
                JSONObject obj = new JSONObject(response.getBody());
                List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
                if (obj.optString("error") == "false") {
                    documento = obj.optString("documento");
                    String nombre = obj.optString("nombre");
                    Long tipo = obj.optLong("tipo");
                    Tipo t = tipoDao.findById(tipo);
                    Basico b = basicoDao.findByDocumento(documento);
                    if (b == null) {
                        b = new Basico();
                        b.setDocumento(documento);
                        b.setNombre(nombre);
                        b.setTipo(t);
                        basicoDao.save(b);
                    }
                } else {
                    return null;
                }

                return new UsernamePasswordAuthenticationToken(documento, password, authorities);

            } catch (JSONException e) {

                e.printStackTrace();
                Logger.getLogger(CustomAuthenticationProvider.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {

        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
