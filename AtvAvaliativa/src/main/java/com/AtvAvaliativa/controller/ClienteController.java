package com.AtvAvaliativa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AtvAvaliativa.entities.Cliente;
import com.AtvAvaliativa.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
private final ClienteService clienteService;
@Autowired
public ClienteController(ClienteService clienteService) {
	this.clienteService = clienteService;
}

@GetMapping("/{id}")
public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
	Cliente cliente = clienteService.getClienteById(id);
	if (cliente != null) {
		return ResponseEntity.ok(cliente);
	} else {
		return ResponseEntity.notFound().build();
	}
}

@GetMapping("/")
public ResponseEntity<List<Cliente>> getAllCliente() {
	List<Cliente> cliente = clienteService.getAllCliente();
	return ResponseEntity.ok(cliente);
}


@PostMapping("/")
public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente) {
	Cliente criarCliente = clienteService.salvarCliente(cliente);
	return ResponseEntity.status(HttpStatus.CREATED).body(criarCliente);
}


@PutMapping("/{id}")
public ResponseEntity<Cliente> updateCliente(@PathVariable Long id,@RequestBody Cliente cliente) {
	Cliente updatedCliente = clienteService.updateCliente(id, cliente);
	if (updatedCliente != null) {
		return ResponseEntity.ok(updatedCliente);
	} else {
		return ResponseEntity.notFound().build();
	}
}

@DeleteMapping("/{id}")
public ResponseEntity<String> deleteCliente(@PathVariable Long id) {
	boolean deleted = clienteService.deleteCliente(id);
	if (deleted) {
		return ResponseEntity.ok().body("O cliente foi excluído com sucesso.");
	} else {
		return ResponseEntity.notFound().build();
	}
}


}

