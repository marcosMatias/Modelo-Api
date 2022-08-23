package br.com.modelo.api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteEnderecoDto {
	private String cpf;
	private String rg;
	private String rua;
	private String bairro;
	private String cidade;
	private String estado;

}
