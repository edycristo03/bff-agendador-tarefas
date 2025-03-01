package com.github.edycristo03.bffagendadortarefas.business;

import com.github.edycristo03.bffagendadortarefas.business.dtos.in.EnderecoDTOResquest;
import com.github.edycristo03.bffagendadortarefas.business.dtos.in.LoginDTORequest;
import com.github.edycristo03.bffagendadortarefas.business.dtos.in.TelefoneDTORequest;
import com.github.edycristo03.bffagendadortarefas.business.dtos.in.UsuarioDTORequest;
import com.github.edycristo03.bffagendadortarefas.business.dtos.out.EnderecoDTOResponse;
import com.github.edycristo03.bffagendadortarefas.business.dtos.out.TelefoneDTOResponse;
import com.github.edycristo03.bffagendadortarefas.business.dtos.out.UsuarioDTOResponse;
import com.github.edycristo03.bffagendadortarefas.infrestructure.client.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {
private final UsuarioClient usuarioClient;


    public UsuarioDTOResponse salvarUsuario(UsuarioDTORequest usuarioDTO) {
        return usuarioClient.salvarUsuario(usuarioDTO);
    }

    public String loginUsuario(LoginDTORequest loginDTO) {
        return usuarioClient.login(loginDTO);

    }



    public UsuarioDTOResponse buscarUsuarioPorEmail(String email, String token) {
        return usuarioClient.buscarUsuarioPorEmail(email, token);
    }

    public void deletarUsuarioPorEmail(String email, String token) {
        usuarioClient.deletarUsuarioPorEmail(email,token);
    }


    public UsuarioDTOResponse atualizarUsuario(String token, UsuarioDTORequest usuarioDTO) {

        return usuarioClient.atualizarUsuario(usuarioDTO,token);
    }

    public EnderecoDTOResponse atualizarEndereco(Long idEndereco, EnderecoDTOResquest enderecoDTO, String token){
        return usuarioClient.atualizarEndereco(enderecoDTO,idEndereco,token);
    }

    public TelefoneDTOResponse atualizarTelefone(Long idTelefone, TelefoneDTORequest telefoneDTO, String token){
        return usuarioClient.atualizatTelefone(telefoneDTO,idTelefone,token);
    }


    public EnderecoDTOResponse cadastrarEndereco(EnderecoDTOResquest enderecoDTO, String token){
        return usuarioClient.cadastrarEndereco(enderecoDTO,token);//ignore


    }

    public TelefoneDTOResponse cadastrarTelefone(TelefoneDTORequest telefoneDTO, String token){
        return usuarioClient.cadastrarTelefone(telefoneDTO,token);


    }




}
