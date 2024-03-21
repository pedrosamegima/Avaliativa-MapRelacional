package com.AtvAvaliativa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AtvAvaliativa.entities.Itempedido;
import com.AtvAvaliativa.repository.ItemPedidoRepository;

@Service
public class ItempedidoService {
	private final ItemPedidoRepository itemPedidoRepository;

	@Autowired
	public ItempedidoService(ItemPedidoRepository itemPedidoRepository) {
		this.itemPedidoRepository = itemPedidoRepository;
	}

	public List<Itempedido> getAllItempedido() {
		return itemPedidoRepository.findAll();
	}

	public Itempedido getItempedidoById(Long id) {
		Optional<Itempedido> Itempedido = itemPedidoRepository.findById(id);
		return Itempedido.orElse(null);
	}

	public Itempedido salvarItempedido(Itempedido Itempedido) {
		return itemPedidoRepository.save(Itempedido);
	}

	public Itempedido updateItempedido(Long id, Itempedido updatedItempedido) {
		Optional<Itempedido> existingItempedido = itemPedidoRepository.findById(id);
		if (existingItempedido.isPresent()) {
			updatedItempedido.setId(id);
			return itemPedidoRepository.save(updatedItempedido);
		}
		return null;
	}

	public boolean deleteItempedido(Long id) {
		Optional<Itempedido> existingItempedido = itemPedidoRepository.findById(id);
		if (existingItempedido.isPresent()) {
			itemPedidoRepository.deleteById(id);
			return true;
		}
		return false;
	}



}

