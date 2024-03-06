package br.com.fiap.produtomvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.produtomvc.models.Produto;

@Repository
public interface ProdutoReporitory extends JpaRepository<Produto, Long> {

	
	
}
