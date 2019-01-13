package com.rafaelbiase.cursojava;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rafaelbiase.cursojava.domain.Categoria;
import com.rafaelbiase.cursojava.domain.Cidade;
import com.rafaelbiase.cursojava.domain.Cliente;
import com.rafaelbiase.cursojava.domain.Endereco;
import com.rafaelbiase.cursojava.domain.Estado;
import com.rafaelbiase.cursojava.domain.ItemPedido;
import com.rafaelbiase.cursojava.domain.Pagamento;
import com.rafaelbiase.cursojava.domain.PagamentoComCartão;
import com.rafaelbiase.cursojava.domain.PagamentoComboleto;
import com.rafaelbiase.cursojava.domain.Pedido;
import com.rafaelbiase.cursojava.domain.Produto;
import com.rafaelbiase.cursojava.domain.enums.EstadoPagamento;
import com.rafaelbiase.cursojava.domain.enums.TipoCliente;
import com.rafaelbiase.cursojava.repositories.CategoriaRepository;
import com.rafaelbiase.cursojava.repositories.CidadeRepository;
import com.rafaelbiase.cursojava.repositories.ClienteRepository;
import com.rafaelbiase.cursojava.repositories.EnderecoRepository;
import com.rafaelbiase.cursojava.repositories.EstadoRepository;
import com.rafaelbiase.cursojava.repositories.ItemPedidoRepository;
import com.rafaelbiase.cursojava.repositories.PagamentoRepository;
import com.rafaelbiase.cursojava.repositories.PedidoRepository;
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
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

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
		
		Cliente cli1 = new Cliente(null, "Jonny", "jonny@gmail.com", "123456", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("33616413", "992643131"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "apto 203", "Jardim", "38220000", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "sala 800", "centro", "38220000", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null,sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null,sdf.parse("10/10/2017 10:32"), cli1, e2);
		
		Pagamento pagto1 = new PagamentoComCartão(null, EstadoPagamento.QUITADO, ped1 , 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComboleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 23:00"), null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));		
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2.000);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3)); 
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
	}

}

