package com.github.edycristo03.bffagendadortarefas.business;



import com.github.edycristo03.bffagendadortarefas.business.dtos.in.TarefasDTORequest;
import com.github.edycristo03.bffagendadortarefas.business.dtos.out.TarefasDTOResponse;
import com.github.edycristo03.bffagendadortarefas.business.enuns.StatusNotificacaoEnum;
import com.github.edycristo03.bffagendadortarefas.infrestructure.client.TarefasClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefasService {
    private final TarefasClient tarefasClient;



    public TarefasDTOResponse gravarTarefas( TarefasDTORequest tarefasDTO, String token) {
        return tarefasClient.gravarTarefas(tarefasDTO, token);
    }

    public List<TarefasDTOResponse> buscaTarefasAgendadasPorPeriodo(LocalDateTime dataInicial, LocalDateTime dataFinal, String token) {
        return tarefasClient.buscarListaTarefasPeriodo(dataInicial, dataFinal,token);

    }

    public List<TarefasDTOResponse> buscarTarefasPorEmail(String token) {
        return tarefasClient.buscarTarefasPorEmail(token);
    }

    public void deletarTarefaPorId(String id,String token) {

        tarefasClient.deletarTarefaPorId(id,token);
    }


    public TarefasDTOResponse alterarStatusTarefa(StatusNotificacaoEnum status, String id, String token) {
        return tarefasClient.alterarStatusNotificacao(status, id,token);

    }

    public TarefasDTOResponse updateTarefas(TarefasDTORequest tarefasDTO, String id, String token) {
        return tarefasClient.updateTarefas(tarefasDTO, id,token);
    }

}
