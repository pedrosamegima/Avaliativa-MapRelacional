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

import com.AtvAvaliativa.entities.Pedido;
import com.AtvAvaliativa.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
	private final PedidoService pedidoService;
	@Autowired
	public PedidoController(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pedido> getPedidoById(@PathVariable Long id) {
		Pedido pedido = pedidoService.getPedidoById(id);
		if (pedido != null) {
			return ResponseEntity.ok(pedido);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Pedido>> getAllPedido() {
		List<Pedido> pedido = pedidoService.getAllPedido();
		return ResponseEntity.ok(pedido);
	}


	@PostMapping("/")
	public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido pedido) {
		Pedido criarPedido = pedidoService.salvarPedido(pedido);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarPedido);
	}


	@PutMapping("/{id}")
	public ResponseEntity<Pedido> updatePedido(@PathVariable Long id,@RequestBody Pedido pedido) {
		Pedido updatedPedido = pedidoService.updatePedido(id, pedido);
		if (updatedPedido != null) {
			return ResponseEntity.ok(updatedPedido);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePedido(@PathVariable Long id) {
		boolean deleted = pedidoService.deletePedido(id);
		if (deleted) {
			return ResponseEntity.ok().body("O Pedido foi excluído com sucesso.");
		} else {
			return ResponseEntity.notFound().build();
		}
	}


	}

