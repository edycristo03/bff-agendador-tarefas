package com.github.edycristo03.bffagendadortarefas.infrestructure.client;


import com.github.edycristo03.bffagendadortarefas.business.dtos.out.TarefasDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "agendador-tarefas", url = "${agendador-tarefas.url}")
public interface EmailClient {

    void enviarEmail(@RequestBody TarefasDTOResponse tarefasDTO);
}


