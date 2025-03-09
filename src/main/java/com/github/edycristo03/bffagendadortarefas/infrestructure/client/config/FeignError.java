package com.github.edycristo03.bffagendadortarefas.infrestructure.client.config;

import com.github.edycristo03.bffagendadortarefas.infrestructure.exceptions.BusinessException;
import com.github.edycristo03.bffagendadortarefas.infrestructure.exceptions.ConflictException;
import com.github.edycristo03.bffagendadortarefas.infrestructure.exceptions.IllegalArgumentException;
import com.github.edycristo03.bffagendadortarefas.infrestructure.exceptions.ResourceNotFoundException;
import com.github.edycristo03.bffagendadortarefas.infrestructure.exceptions.UnauthorizedException;
import feign.Response;
import feign.codec.ErrorDecoder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class FeignError implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {
        String mesagemErro = mensagemErro(response);

        switch (response.status()) {
            case 409:
                return new ConflictException("Erro " + mesagemErro);
            case 403:
                return new ResourceNotFoundException("Erro " + mesagemErro);
            case 401:
                return new UnauthorizedException("Erro " + mesagemErro);
            case 400:
                return new IllegalArgumentException("Erro " + mesagemErro);
            default:
                return new BusinessException("Erro " + mesagemErro);

        }
    }

    private String mensagemErro(Response response) {
        try {
            if(Objects.isNull(response.body())) return "";

           return new String(response.body().asInputStream().readAllBytes(), StandardCharsets.UTF_8); // response.body().asInputStream().readAllBytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
