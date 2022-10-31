package com.Altenticacao.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Altenticacao.Controller.Usuario.Request.UsuarioRequest;
import com.Altenticacao.Controller.Usuario.Response.UsuarioResponse;
import com.Altenticacao.Repository.UsuarioRepository;
import com.Altenticacao.Utils.UsuarioBuilder;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	UsuarioBuilder usuarioBuilder;

	//Save
	public UsuarioResponse save(UsuarioRequest usuarioRequest) {
		return usuarioBuilder.buildUsuarioResponse(usuarioRepository.save(usuarioBuilder.buildUsuario(usuarioRequest)));
	}
	

	//Search
	public List<UsuarioResponse> buscar() {
		return usuarioBuilder.buildUsuarioResponse(usuarioRepository.findAll());
	}		
}
