package com.Altenticacao.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Altenticacao.Model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
