package com.AtvAvaliativa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AtvAvaliativa.entities.Produto;

public interface ProdutoRepository extends JpaRepository <Produto, Long>{

}
