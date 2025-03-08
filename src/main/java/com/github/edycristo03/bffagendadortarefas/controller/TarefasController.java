package com.github.edycristo03.bffagendadortarefas.controller;


import com.github.edycristo03.bffagendadortarefas.business.TarefasService;
import com.github.edycristo03.bffagendadortarefas.business.dtos.in.TarefasDTORequest;
import com.github.edycristo03.bffagendadortarefas.business.dtos.out.TarefasDTOResponse;
import com.github.edycristo03.bffagendadortarefas.business.enuns.StatusNotificacaoEnum;
import com.github.edycristo03.bffagendadortarefas.infrestructure.client.securityConfig.SecurityConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
@Tag(name = "Tarefas", description = "Cadastro de tarefas de usuários")
@SecurityRequirement(name = SecurityConfig.SECURITY_SCHEME)
public class TarefasController {

    private final TarefasService tarefasService;

    @PostMapping
    @Operation(summary = "Cadastrar tarefa", description = "Cria uma nova tarefa")
    @ApiResponse(responseCode = "200", description = "Tarefa cadastrada com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    public ResponseEntity<TarefasDTOResponse> gravarTarefas(@RequestBody TarefasDTORequest tarefasDTO,
                                                            @RequestHeader(name = "Authorization",
                                                                    required = false) String token) {
        return ResponseEntity.ok(tarefasService.gravarTarefas(tarefasDTO, token));
    }

    @GetMapping("/eventos")
    @Operation(summary = "Buscar tarefas por periodo ", description = "Busca as tarefas agendadas por periodo")
    @ApiResponse(responseCode = "200", description = "Tarefa encontrada com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    public ResponseEntity<List<TarefasDTOResponse>> buscarListaTarefasPeriodo(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
                                                                              @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal,
                                                                              @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(tarefasService.buscaTarefasAgendadasPorPeriodo(dataInicial, dataFinal, token));
    }

    @GetMapping
    @Operation(summary = "Buscar lista de tarefas por usuario ", description = "Busca as tarefas cadastradas por usuario")
    @ApiResponse(responseCode = "200", description = "Tarefa encontrada com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    public ResponseEntity<List<TarefasDTOResponse>> buscarTarefasPorEmail(@RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(tarefasService.buscarTarefasPorEmail(token));
    }

    @DeleteMapping
    @Operation(summary = "Deletar tarefa por id", description = "Deleta uma tarefa cadastrada por id")
    @ApiResponse(responseCode = "200", description = "Tarefa deletada com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    public ResponseEntity<Void> deletarTarefaPorId(@RequestParam("id") String id,
                                                   @RequestHeader(name = "Authorization",
                                                           required = false) String token) {

        tarefasService.deletarTarefaPorId(id, token);
        return ResponseEntity.ok().build();
    }


    @PatchMapping
    @Operation(summary = "Alterar staus da tarefa", description = "Alterar status da tarefa cadastrada")
    @ApiResponse(responseCode = "200", description = "Tarefa alterada com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    public ResponseEntity<TarefasDTOResponse> alterarStatusNotificacao(@RequestParam("status") StatusNotificacaoEnum status,
                                                                       @RequestParam("id") String id, @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(tarefasService.alterarStatusTarefa(status, id, token));
    }

    @PutMapping
    @Operation(summary = "Alterar dados da tarefa", description = "Alterar dados da tarefa cadastrada")
    @ApiResponse(responseCode = "200", description = "Tarefa alterada com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    public ResponseEntity<TarefasDTOResponse> updateTarefas(@RequestBody TarefasDTORequest tarefasDTO,
                                                            @RequestParam("id") String id,
                                                            @RequestHeader(name = "Authorization",
                                                                    required = false) String token) {
        return ResponseEntity.ok(tarefasService.updateTarefas(tarefasDTO, id, token));
    }


}
