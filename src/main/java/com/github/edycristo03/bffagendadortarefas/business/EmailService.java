package com.github.edycristo03.bffagendadortarefas.business;


import com.github.edycristo03.bffagendadortarefas.business.dtos.out.TarefasDTOResponse;
import com.github.edycristo03.bffagendadortarefas.infrestructure.client.EmailClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final EmailClient emailClient;

    public void enviarEmail(TarefasDTOResponse tarefasDTO) {
        emailClient.enviarEmail(tarefasDTO);
    }


}
