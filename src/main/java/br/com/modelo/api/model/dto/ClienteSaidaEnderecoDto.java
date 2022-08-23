package br.com.modelo.api.model.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteSaidaEnderecoDto {
	
	private List<CampoDto> campo = new ArrayList<>();
	

}
