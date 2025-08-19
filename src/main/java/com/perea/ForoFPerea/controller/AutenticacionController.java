package com.perea.ForoFPerea.controller;

import com.perea.ForoFPerea.infraestructura.security.DatosTokenJWT;
import com.perea.ForoFPerea.infraestructura.security.TokenService;
import com.perea.ForoFPerea.usuario.DatosAutenticacion;
import com.perea.ForoFPerea.usuario.Usuario;
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

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager manager;
    @PostMapping
    public ResponseEntity iniciarSesion(@RequestBody @Valid DatosAutenticacion datos){

        var authenticationToken= new UsernamePasswordAuthenticationToken(datos.user(),datos.password());
        var autenticacion= manager.authenticate(authenticationToken);

        var tokenJWT= tokenService.generarToken((Usuario) autenticacion.getPrincipal());
        return ResponseEntity.ok(new DatosTokenJWT(tokenJWT));
    }

}
