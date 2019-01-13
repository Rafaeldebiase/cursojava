package com.rafaelbiase.cursojava;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rafaelbiase.cursojava.domain.Categoria;
import com.rafaelbiase.cursojava.domain.Cidade;
import com.rafaelbiase.cursojava.domain.Estado;
import com.rafaelbiase.cursojava.domain.Produto;
import com.rafaelbiase.cursojava.repositories.CategoriaRepository;
import com.rafaelbiase.cursojava.repositories.CidadeRepository;
import com.rafaelbiase.cursojava.repositories.EstadoRepository;
import com.rafaelbiase.cursojava.repositories.ProdutoRepository;

@SpringBootApplication
public class CursoJavaApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursoJavaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		Estado est1 = new Estado(null, "Rio de Janeiro");
		Estado est2 = new Estado(null, "Santa Catarina");
		
		Cidade c1 = new Cidade(null, "Rio de Janeiro", est1);
		Cidade c2 = new Cidade(null, "Itapema", est2);
		Cidade c3 = new Cidade(null, "Balneário Camburiú", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
	}

}

