package com.perea.ForoFPerea.controller;

import com.perea.ForoFPerea.usuario.DatosAutenticacion;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    //@Autowired
    //private TokenService tokenService;

    @Autowired
    private AuthenticationManager manager;
    @PostMapping
    public ResponseEntity iniciarSesion(@RequestBody @Valid DatosAutenticacion datos){

        var token= new UsernamePasswordAuthenticationToken(datos.user(),datos.password());
        var autenticacion= manager.authenticate(token);

        //var tokenJWT= tokenService.generarToken((Usuario) autenticacion.getPrincipal());
        return ResponseEntity.ok().build();//(new DatosTokenJWT(tokenJWT));
    }

    /*@Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {

        return configuration.getAuthenticationManager();
    }*/

}
