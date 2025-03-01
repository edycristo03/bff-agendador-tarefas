package com.github.edycristo03.bffagendadortarefas.business.dtos.in;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TelefoneDTORequest {

    private String ddd;
    private String numero;
}
