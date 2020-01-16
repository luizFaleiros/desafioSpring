
package com.example.desafioSpring.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.example.desafioSpring.domain.dto.request.ClientCreateRequest;
import com.example.desafioSpring.domain.dto.response.ClientResponse;
import com.example.desafioSpring.domain.entities.Client;
import com.example.desafioSpring.domain.mapper.ClientMapper;
import com.example.desafioSpring.services.client.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/clients")
public class ClientController {

	private final ClientService clientService;
	private final ClientMapper mapper;

	@Autowired
	public ClientController(ClientService clientService, ClientMapper clientMapper) {
		this.clientService = clientService;
		this.mapper = clientMapper;
	}

	@GetMapping(value = "/{id}")
    public ResponseEntity<ClientResponse> getById(@PathVariable Integer id) {
         return ResponseEntity.ok(mapper.toDto(clientService.findById(id))) ;
    }
	@GetMapping
	public ResponseEntity<List<ClientResponse>> list() {
		return ResponseEntity.ok(clientService.listClient().stream() //
				.map(x -> mapper.toDto(x)) //
				.collect(Collectors.toList()));
	}


	@PostMapping
	public ResponseEntity<ClientResponse> post(@Valid @RequestBody ClientCreateRequest model) {

		Client client = clientService.createClient(mapper.fromDto(model));

		return ResponseEntity.ok(mapper.toDto(client));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id){
		clientService.deletClient(id);
		return ResponseEntity.ok("Cliente deletado com sucesso");

	}
	@PutMapping("/{id}")
	public ResponseEntity<ClientResponse> put(@Valid @RequestBody ClientCreateRequest model,@PathVariable Integer id) {
		Client client = clientService.findById(id);
		client.setName(model.getName());
		client.setPhone(model.getPhone());
		clientService.createClient(client);
		return ResponseEntity.ok(mapper.toDto(client));
		
	}

}