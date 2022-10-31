package com.Altenticacao.Controller.Usuario;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.Altenticacao.Controller.Usuario.Request.UsuarioRequest;
import com.Altenticacao.Controller.Usuario.Response.UsuarioResponse;
import com.Altenticacao.Service.UsuarioService;

@RequestMapping("/autenticar")
@RestController
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	@PostMapping("/salvarusuario")
	public ResponseEntity<UsuarioResponse> cadastroUsuario(@RequestBody @Validated UsuarioRequest usuarioRequest,
			UriComponentsBuilder UriBuilder) throws Exception {
		
		UsuarioResponse usuario = usuarioService.save(usuarioRequest);
		
		URI uri = UriBuilder.path("/usuario/{id}").buildAndExpand(usuario.getId()).toUri();
		
		return ResponseEntity.created(uri).body(usuario);
		
	}

	@GetMapping("/buscarusuario")
	public List<UsuarioResponse> listar() {
		return usuarioService.buscar();
	}
}