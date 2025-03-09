package com.github.edycristo03.bffagendadortarefas.controller;


import com.github.edycristo03.bffagendadortarefas.business.UsuarioService;
import com.github.edycristo03.bffagendadortarefas.business.dtos.in.EnderecoDTOResquest;
import com.github.edycristo03.bffagendadortarefas.business.dtos.in.LoginDTORequest;
import com.github.edycristo03.bffagendadortarefas.business.dtos.in.TelefoneDTORequest;
import com.github.edycristo03.bffagendadortarefas.business.dtos.in.UsuarioDTORequest;
import com.github.edycristo03.bffagendadortarefas.business.dtos.out.EnderecoDTOResponse;
import com.github.edycristo03.bffagendadortarefas.business.dtos.out.TelefoneDTOResponse;
import com.github.edycristo03.bffagendadortarefas.business.dtos.out.UsuarioDTOResponse;
import com.github.edycristo03.bffagendadortarefas.business.dtos.out.ViaCepDTOResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
@Tag(name = "Usuário", description = "Cadastro e login de usuários")
public class UsuarioController {
    private final UsuarioService usuarioService;




    @PostMapping
    @Operation(summary = "Cadastrar usuário",description = "Cria um novo usuário")
    @ApiResponse(responseCode = "201", description = "Usuário criado com sucesso")
    @ApiResponse(responseCode = "409", description = "Usuário já cadastrado")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")

    public ResponseEntity <UsuarioDTOResponse> salvarUsuario(@RequestBody UsuarioDTORequest usuarioDTO) {
       return ResponseEntity.ok(usuarioService.salvarUsuario(usuarioDTO));
    }

    @PostMapping("/login")
    @Operation(summary = "Login de usuário",description = "Realiza o login de um usuário")
    @ApiResponse(responseCode = "200", description = "Usuário logado com sucesso")
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")

    public String login(@RequestBody LoginDTORequest loginDTO) {
        return usuarioService.loginUsuario(loginDTO);


    };

    @GetMapping
    @Operation(summary = "Buscar usuário por email",description = "Busca um usuário por email")
    @ApiResponse(responseCode = "200", description = "Usuário encontrado com sucesso")
    @ApiResponse(responseCode = "403", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    public ResponseEntity<UsuarioDTOResponse> buscarUsuarioPorEmail(@RequestParam("email") String email,
                                                                    @RequestHeader(name= "Authorization",required = false) String token) {
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorEmail(email,token));
    }

    @DeleteMapping("/{email}")
    @Operation(summary = "Deletar usuário por email",description = "Deleta um usuário por email")
    @ApiResponse(responseCode = "200", description = "Usuário deletado com sucesso")
    @ApiResponse(responseCode = "403", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    public ResponseEntity<Void> deletarUsuarioPorEmail(@PathVariable String email,
                                                       @RequestHeader(name= "Authorization",required = false) String token) {
        usuarioService.deletarUsuarioPorEmail(email,token);
        return ResponseEntity.ok().build();

    }


    @PutMapping
    @Operation(summary = "Atualizar dados do usuário",description = "Atualiza dados de um usuário")
    @ApiResponse(responseCode = "200", description = "Usuário atualizado com sucesso")
    @ApiResponse(responseCode = "403", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    public ResponseEntity<UsuarioDTOResponse> atualizarDadosUsuario(@RequestBody UsuarioDTORequest usuarioDTO ,
                                                               @RequestHeader(name= "Authorization",required = false) String token) {
        return ResponseEntity.ok(usuarioService.atualizarDadosUsuario(token, usuarioDTO));
    }

    @PutMapping("/endereco")
    @Operation(summary = "Atualizar endereço",description = "Atualiza endereço de um usuário")
    @ApiResponse(responseCode = "200", description = "Endereço atualizado com sucesso")
    @ApiResponse(responseCode = "403", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    public ResponseEntity <EnderecoDTOResponse> atualizarEndereco(@RequestBody EnderecoDTOResquest enderecoDTO,
                                                                  @RequestParam ("id") Long id,
                                                                  @RequestHeader(name= "Authorization",required = false) String token) {
        return ResponseEntity.ok(usuarioService.atualizarEndereco(id, enderecoDTO,token));
    }

    @PutMapping("/telefone")
    @Operation(summary = "Atualizar telefone",description = "Atualiza um telefone de um usuário")
    @ApiResponse(responseCode = "200", description = "Telefone atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    public ResponseEntity<TelefoneDTOResponse> atualizatTelefone(@RequestBody TelefoneDTORequest telefoneDTO ,
                                                                 @RequestParam("id") Long id,
                                                                 @RequestHeader(name= "Authorization",required = false) String token) {
        return ResponseEntity.ok(usuarioService.atualizarTelefone(id, telefoneDTO,token));
    }


    @PostMapping("/endereco")
    @Operation(summary = "Cadastrar endereço",description = "Cria um novo endereço")
    @ApiResponse(responseCode = "200", description = "Endereço cadastrado com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    public ResponseEntity <EnderecoDTOResponse> cadastrarEndereco(@RequestBody EnderecoDTOResquest enderecoDTO,
                                                                  @RequestHeader(name= "Authorization",required = false) String token) {
        return ResponseEntity.ok(usuarioService.cadastrarEndereco(enderecoDTO,token));
    }

    @PostMapping("/telefone")
    @Operation(summary = "Cadastrar telefone",description = "Cria um novo telefone")
    @ApiResponse(responseCode = "200", description = "Telefone cadastrado com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    public ResponseEntity<TelefoneDTOResponse>cadastrarTelefone(@RequestBody TelefoneDTORequest telefoneDTO,
                                                                @RequestHeader("Authorization")String token) {
        return ResponseEntity.ok(usuarioService.cadastrarTelefone(telefoneDTO,token));
    }

    @GetMapping("/endereco/{cep}")
    @Operation(summary = "Buscar endereço pelo cep",description = "Busca dados de endereço recebendo um cep")
    @ApiResponse(responseCode = "200", description = "Dados de endereço retornado com sucesso")
    @ApiResponse(responseCode = "404", description = "CEP inválido")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
        public ResponseEntity<ViaCepDTOResponse>buscarEndereco(@PathVariable("cep") String cep) {
        return ResponseEntity.ok(usuarioService.buscarEnderecoPorCep(cep));
    }



}
