package br.com.modelo.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.modelo.api.model.Usuario;
import br.com.modelo.api.model.dto.UsuarioDto;
import br.com.modelo.api.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioDto> retornarUsuarioPorId(@PathVariable Long id){
		
		UsuarioDto user = modelToDto(usuarioService.retornarUsuarioPorIdService(id));
		

		
		return ResponseEntity.ok(user);
		
	}
	
	
	
	private UsuarioDto modelToDto(Usuario usuario) {
		
		return modelMapper.map(usuario, UsuarioDto.class);
	}
	
	private Usuario dtoToModel(UsuarioDto usuarioDto) {
		return modelMapper.map(usuarioDto, Usuario.class);
	}

	private List<UsuarioDto> toCollectionDto(List<Usuario> usuarios){
	
	return usuarios.stream()
				   .map(usuario -> modelToDto(usuario))
				   .collect(Collectors.toList());
	}
	
	private List<Usuario> toCollectionModel(List<UsuarioDto> usuarioDtos ){
		
		return usuarioDtos.stream().map(usuarioDto -> dtoToModel(usuarioDto))
				.collect(Collectors.toList());
	}
	
}
