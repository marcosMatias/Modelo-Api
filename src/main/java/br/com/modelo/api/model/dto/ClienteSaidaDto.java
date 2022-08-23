package br.com.modelo.api.model.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteSaidaDto {
	
	
	private List<CampoDto> campo = new ArrayList<>();
	@JsonProperty("locais-Cliente")
	private List<ClienteSaidaEnderecoDto> enderecos = new ArrayList<>();

}
