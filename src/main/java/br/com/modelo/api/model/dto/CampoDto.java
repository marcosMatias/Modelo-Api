package br.com.modelo.api.model.dto;

import java.util.Map.Entry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CampoDto {

	private String chave;
	private String valor;

	public static CampoDto toCampo(Entry<String, Object> entry) {
		return new CampoDto(entry.getKey(), String.valueOf(entry.getValue()));
	}
}
