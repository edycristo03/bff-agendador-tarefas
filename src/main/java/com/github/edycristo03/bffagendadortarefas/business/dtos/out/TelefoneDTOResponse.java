package com.github.edycristo03.bffagendadortarefas.business.dtos.out;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TelefoneDTOResponse {
    private Long id;
    private String ddd;
    private String numero;
}
