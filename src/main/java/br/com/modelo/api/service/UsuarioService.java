package br.com.modelo.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.modelo.api.model.Usuario;
import br.com.modelo.api.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	public Usuario retornarUsuarioPorIdService(Long id) {
		Optional<Usuario> opt = usuarioRepository.findById(id);
		
		
		if (opt.isPresent()) {
			Usuario usuario;
			return usuario = opt.get();
		}
		
		return null ;
		
	}
	
	
	
}
