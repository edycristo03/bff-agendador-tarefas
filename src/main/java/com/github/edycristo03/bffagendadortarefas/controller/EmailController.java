package com.github.edycristo03.bffagendadortarefas.controller;


import com.github.edycristo03.bffagendadortarefas.business.EmailService;
import com.github.edycristo03.bffagendadortarefas.business.dtos.out.TarefasDTOResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/email")
public class EmailController {
    private final EmailService emailService;

    @PostMapping
    public ResponseEntity<Void> enviarEmail(@RequestBody TarefasDTOResponse tarefaDTO) {
        emailService.enviaEmail(tarefaDTO);
        return ResponseEntity.ok().build();
    }
}
