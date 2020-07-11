package br.com.alura.microservice.loja.service;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.alura.microservice.loja.controller.dto.CompraDTO;
import br.com.alura.microservice.loja.dto.InfoFornecedorDTO;

@Service
public class CompraService {

	public void realizaCompra(CompraDTO compra) {
		RestTemplate client = new RestTemplate(); 
		//ferramenta do Spring para requisições HTTP síncronas (get, post...) através de alguns métodos
		//Vamos usar o método exchange
		ResponseEntity<InfoFornecedorDTO> exchange = 
		client.exchange("http://fornecedor:8081/info/"+compra.getEndereco().getEstado()
				,HttpMethod.GET, null, InfoFornecedorDTO.class);
		
		System.out.println(exchange.getBody().getEndereco());
	}

}
