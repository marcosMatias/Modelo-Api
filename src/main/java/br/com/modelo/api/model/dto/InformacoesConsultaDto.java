package br.com.modelo.api.model.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InformacoesConsultaDto {
	@JsonProperty("Cliente")
	private ClienteSaidaDto  clienteSaidaDto;

}
