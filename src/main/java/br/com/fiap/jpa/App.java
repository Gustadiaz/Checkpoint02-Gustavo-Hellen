package br.com.fiap.jpa;

import br.com.fiap.entity.Acessorio;
import br.com.fiap.entity.Adiciona;
import br.com.fiap.entity.Carro;
import br.com.fiap.entity.Modelo;
import br.com.fiap.jpa.service.AcessorioServiceImpl;
import br.com.fiap.jpa.service.AdicionaServiceImpl;
import br.com.fiap.jpa.service.CarroServiceImpl;
import br.com.fiap.jpa.service.ModeloServiceImpl;

public class App {
	
	public static void main(String[] args) {
		
		ModeloServiceImpl modeloService = ModeloServiceImpl.getInstance();
		
		Modelo modelo1 = new Modelo("Tiguan");
		
		modeloService.cadastrar(modelo1);
		
		AcessorioServiceImpl acessorioService = AcessorioServiceImpl.getInstance();
		
		Acessorio acessorio1 = new Acessorio("Teto Solar");
		Acessorio acessorio2 = new Acessorio("Parking Assistant");
		
		acessorioService.cadastrar(acessorio1);
		acessorioService.cadastrar(acessorio2);
		
		acessorioService.listar().forEach(System.out::println);
		
		CarroServiceImpl carroService = CarroServiceImpl.getInstance();
		
		Carro carro1 = new Carro("FSV4850", "Branco", "547B82FG3TR50B8PO");
		
		carroService.cadastrar(carro1);
		
		carroService.listar().forEach(System.out::println);
		
		AdicionaServiceImpl adicionaService = AdicionaServiceImpl.getInstance();
		
		Adiciona adiciona1 = new Adiciona(modelo1, acessorio1, carro1);
		Adiciona adiciona2 = new Adiciona(modelo1, acessorio2, carro1);
		
		adicionaService.cadastrar(adiciona1);
		adicionaService.cadastrar(adiciona2);
		
		adicionaService.listar().forEach(System.out::println);
		
		
	}

}
