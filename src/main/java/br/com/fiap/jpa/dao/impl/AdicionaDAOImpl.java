package br.com.fiap.jpa.dao.impl;

import br.com.fiap.entity.Adiciona;

public class AdicionaDAOImpl extends HibernateGenericDAO<Adiciona, Long> {

	private static AdicionaDAOImpl instance = null;
	
	public static AdicionaDAOImpl getInstance() {
		if (instance == null) {
			instance = new AdicionaDAOImpl();
		}
		
		return instance;
	}
	
	private AdicionaDAOImpl() {
		super(Adiciona.class);
	}

}