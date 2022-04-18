package br.com.fiap.entity;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tb_adiciona")
@SequenceGenerator(name = "adiciona", sequenceName = "SQ_TB_ADICIONA", allocationSize = 1)
public class Adiciona implements Serializable{

	private static final long serialVersionUID = 8141234168416028055L;

	@Lob
	private Carro carro;

	private Acessorio acessorio;

	private Modelo modelo;
	
	public Adiciona(Modelo modelo, Acessorio acessorio, Carro carro) {
		this();
		this.carro = carro;
		this.acessorio = acessorio;
		this.modelo = modelo;
	}
	
	public Adiciona() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "acessorio")
	private Long id;
	
	@ManyToMany
	@JoinTable(
			name = "tb_carro_acessorio",
			joinColumns = @JoinColumn(name = "carro_id"),
			inverseJoinColumns = @JoinColumn(name = "acessorio_id"))
	private List<Acessorio> acessorios;
	
	@ManyToOne
	@JoinColumn(name="modelo_id")
	private Modelo modelos;

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public Acessorio getAcessorio() {
		return acessorio;
	}

	public void setAcessorio(Acessorio acessorio) {
		this.acessorio = acessorio;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
@Override
public String toString() {
	return "\nCarro: " + this.getCarro() 
		+ "\nModelo: " + this.getModelo()
		+ "\nAcessorio: " + this.getAcessorio();
}

}
	
	


