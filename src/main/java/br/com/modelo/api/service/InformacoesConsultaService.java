package br.com.modelo.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.modelo.api.model.dto.CampoDto;
import br.com.modelo.api.model.dto.ClienteDto;
import br.com.modelo.api.model.dto.ClienteEnderecoDto;
import br.com.modelo.api.model.dto.ClienteSaidaDto;
import br.com.modelo.api.model.dto.ClienteSaidaEnderecoDto;
import br.com.modelo.api.model.dto.InformacoesConsultaDto;

@Service
public class InformacoesConsultaService {

	
	
	public InformacoesConsultaDto carregarChaveValorService() {
		
		List<CampoDto> campos = new ArrayList<>();
		List<ClienteDto> clientes = carregarDadosCliente();
	    List<ClienteEnderecoDto> enderecos = carregarEnderecos();
		List<CampoDto> camposEndereco = new ArrayList<>();
	 
		campos = clientes.stream().map(c -> {Map<String, Object> map = new ObjectMapper().convertValue(c, Map.class);
											return  map.entrySet().stream().map(CampoDto::toCampo).collect(Collectors.toList());
											}).flatMap(List::stream)
											  .collect(Collectors.toList());
		
		camposEndereco =  enderecos.stream().map(e-> {Map<String, Object> map = new ObjectMapper().convertValue(e, Map.class);
														return  map.entrySet().stream().map(CampoDto::toCampo).collect(Collectors.toList());
														}).flatMap(List::stream)
														  .collect(Collectors.toList());
		
		ClienteSaidaDto clienteSaidaDto = new ClienteSaidaDto (); 
		ClienteSaidaEnderecoDto clienteSaidaEnderecoDto = new ClienteSaidaEnderecoDto();

		clienteSaidaDto.setCampo(campos);
		clienteSaidaEnderecoDto.setCampo(camposEndereco);
		
		List<ClienteSaidaEnderecoDto> clienteSaidaEnderecoDtos = new ArrayList<>();
		clienteSaidaEnderecoDtos.add(clienteSaidaEnderecoDto);
		
		clienteSaidaDto.setEnderecos(clienteSaidaEnderecoDtos);
	
		
		InformacoesConsultaDto informacoes = new InformacoesConsultaDto();
		informacoes.setClienteSaidaDto(clienteSaidaDto);
		
		
		return informacoes;
	}
	
	
	
	
	
	
	
	private List<ClienteDto> carregarDadosCliente() {

		ClienteDto cliente1 = new ClienteDto();
		cliente1.setCpf("123455");
		cliente1.setNome("cliente1");
		cliente1.setRg("888888");

		ClienteDto cliente2 = new ClienteDto();

		cliente2.setCpf("66789");
		cliente2.setNome("cliente2");
		cliente2.setRg("9999999");
		List<ClienteDto> clientes = new ArrayList<>();
		clientes.add(cliente1);
		clientes.add(cliente2);
		
		
		
		return clientes;

	}
	
	private List<ClienteEnderecoDto> carregarEnderecos() {
		ClienteEnderecoDto clienteEndereceo = new ClienteEnderecoDto();
		clienteEndereceo.setCpf("123455");
		clienteEndereceo.setRg("888888");
		clienteEndereceo.setRua("Rua das arvores n 44");
		clienteEndereceo.setBairro("Centro");
		clienteEndereceo.setCidade("Sao Paulo");
		clienteEndereceo.setEstado("SP");
		
		
		ClienteEnderecoDto clienteEndereceo2 = new ClienteEnderecoDto();
		clienteEndereceo2.setCpf("66789");
		clienteEndereceo2.setRg("9999999");
		clienteEndereceo2.setRua("Rua das pitangas n 19");
		clienteEndereceo2.setBairro("Copacabana");
		clienteEndereceo2.setCidade("Rio de Janeiro");
		clienteEndereceo2.setEstado("RJ");
		
		
		List<ClienteEnderecoDto> clienteEnderecoDtos= new ArrayList<>();
		clienteEnderecoDtos.add(clienteEndereceo);
		clienteEnderecoDtos.add(clienteEndereceo2);
		return  clienteEnderecoDtos;
	}

}
