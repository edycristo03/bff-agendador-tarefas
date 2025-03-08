package com.github.edycristo03.bffagendadortarefas.infrestructure.client;


import com.github.edycristo03.bffagendadortarefas.business.dtos.out.TarefasDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notificacao", url = "${notificacao.url}")
public interface EmailClient {

    @PostMapping
    void enviarEmail(@RequestBody TarefasDTOResponse tarefasDTO);


}


