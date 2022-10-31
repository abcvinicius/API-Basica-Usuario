package com.Altenticacao.Utils;

import java.util.List;

import org.springframework.stereotype.Component;

import com.Altenticacao.Controller.Usuario.Request.UsuarioRequest;
import com.Altenticacao.Controller.Usuario.Response.UsuarioResponse;
import com.Altenticacao.Model.Usuario;

@Component
public class UsuarioBuilder {
	

	//List 
	public List<UsuarioResponse> buildUsuarioResponse(List<Usuario> usuario) {
		return usuario.stream().map(usuarios -> buildUsuarioResponse(usuarios)).toList();
	}
	
	//Response 
	public UsuarioResponse buildUsuarioResponse(Usuario usuario) {
		return UsuarioResponse.builder().id(usuario.getId()).nome(usuario.getNome()).senha(usuario.getSenha()).build();
	}
	
	
	//Request
	public Usuario buildUsuario(UsuarioRequest usuarioRequest){
		return Usuario.builder().nome(usuarioRequest.getNome()).senha(usuarioRequest.getSenha()).build();
}
}
