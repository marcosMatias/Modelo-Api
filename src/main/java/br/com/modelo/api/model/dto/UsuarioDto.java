package br.com.modelo.api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {
	
	private Long id;
	private String nome;
	private String login;
	private String senha;
	private String inAtivo;
}
