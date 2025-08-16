package com.perea.ForoFPerea.topico;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;

public class Topico {

    private Long id;
    private String título;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    private StatusTopico  status;
    private Long autorId;
    private Long curso;




}
