package com.github.edycristo03.bffagendadortarefas.infrestructure.client;


import com.github.edycristo03.bffagendadortarefas.business.dtos.in.EnderecoDTOResquest;
import com.github.edycristo03.bffagendadortarefas.business.dtos.in.LoginDTORequest;
import com.github.edycristo03.bffagendadortarefas.business.dtos.in.TelefoneDTORequest;
import com.github.edycristo03.bffagendadortarefas.business.dtos.in.UsuarioDTORequest;
import com.github.edycristo03.bffagendadortarefas.business.dtos.out.EnderecoDTOResponse;
import com.github.edycristo03.bffagendadortarefas.business.dtos.out.TelefoneDTOResponse;
import com.github.edycristo03.bffagendadortarefas.business.dtos.out.UsuarioDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usuario",url = "${usuario.url}")
public interface UsuarioClient {

@GetMapping("/usuario")
UsuarioDTOResponse buscarUsuarioPorEmail(@RequestParam("email") String email,
                                         @RequestHeader("Authorization")String token);


    @PostMapping
    UsuarioDTOResponse salvarUsuario(@RequestBody UsuarioDTORequest usuarioDTO);


    @PostMapping("/login")
    String login(@RequestBody LoginDTORequest loginDTO);




    @DeleteMapping("/{email}")
    void deletarUsuarioPorEmail(@PathVariable String email,
                                @RequestHeader("Authorization") String token);


    @PutMapping
    UsuarioDTOResponse atualizarUsuario(@RequestBody UsuarioDTORequest usuarioDTO ,
                                        @RequestHeader("Authorization") String token);

    @PutMapping("/endereco")
    EnderecoDTOResponse atualizarEndereco(@RequestBody EnderecoDTOResquest enderecoDTO,
                                          @RequestParam ("id") Long id,
                                          @RequestHeader("Authorization") String token);


    @PutMapping("/telefone")
    TelefoneDTOResponse atualizatTelefone(@RequestBody TelefoneDTORequest telefoneDTO ,
                                          @RequestParam("id") Long id,
                                          @RequestHeader("Authorization") String token);


    @PostMapping("/endereco")
    EnderecoDTOResponse cadastrarEndereco(@RequestBody EnderecoDTOResquest enderecoDTO,
                                          @RequestHeader("Authorization") String token);

    @PostMapping("/telefone")
    TelefoneDTOResponse cadastrarTelefone(@RequestBody TelefoneDTORequest telefoneDTO,
                                          @RequestHeader("Authorization")String token);






}
