package com.github.edycristo03.bffagendadortarefas.infrestructure.client;


import com.github.edycristo03.bffagendadortarefas.business.dtos.in.TarefasDTORequest;
import com.github.edycristo03.bffagendadortarefas.business.dtos.out.TarefasDTOResponse;
import com.github.edycristo03.bffagendadortarefas.business.enuns.StatusNotificacaoEnum;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@FeignClient(name = "agendador-tarefas", url = "${agendador-tarefas.url}")
public interface TarefasClient {
    @PostMapping
    TarefasDTOResponse gravarTarefas(@RequestBody TarefasDTORequest tarefasDTO,
                                     @RequestHeader("Authorization") String token);

    @GetMapping("/eventos")
    List<TarefasDTOResponse> buscarListaTarefasPeriodo(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
                                                       @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal,
                                                       @RequestHeader("Authorization") String token);


    @GetMapping
    List<TarefasDTOResponse> buscarTarefasPorEmail(@RequestHeader("Authorization") String token);


    @DeleteMapping
    void deletarTarefaPorId(@RequestParam("id") String id,
                            @RequestHeader("Authorization") String token);

    @PatchMapping
    TarefasDTOResponse alterarStatusNotificacao(@RequestParam("status") StatusNotificacaoEnum status,
                                                @RequestParam("id") String id,
                                                @RequestHeader("Authorization") String token);


    @PutMapping
    TarefasDTOResponse updateTarefas(@RequestBody TarefasDTORequest tarefasDTO,
                                     @RequestParam("id") String id,
                                     @RequestHeader("Authorization") String token);
}


