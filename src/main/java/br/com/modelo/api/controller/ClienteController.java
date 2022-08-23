package br.com.modelo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.modelo.api.model.dto.InformacoesConsultaDto;
import br.com.modelo.api.service.InformacoesConsultaService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	@Autowired
	private InformacoesConsultaService informacoesConsultaService;

	@GetMapping
	public ResponseEntity<InformacoesConsultaDto> recuperarClienteChaveValor() {

		return ResponseEntity.ok(informacoesConsultaService.carregarChaveValorService());
	}

}
