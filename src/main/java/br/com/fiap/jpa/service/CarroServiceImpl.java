package br.com.fiap.jpa.service;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.entity.Acessorio;
import br.com.fiap.entity.Carro;
import br.com.fiap.jpa.dao.impl.AcessorioDAOImpl;
import br.com.fiap.jpa.dao.impl.CarroDAOImpl;


public class CarroServiceImpl extends GenericService<Carro, Long> {

	private static CarroServiceImpl instance = null;

	private CarroDAOImpl carroDAO;
	private AcessorioDAOImpl acessorioDAO;


	private CarroServiceImpl() {
		carroDAO = CarroDAOImpl.getInstance();
	}

	public static CarroServiceImpl getInstance() {
		if (instance == null) {
			instance = new CarroServiceImpl();
		}
		return instance;
	}

	@Override
	public void cadastrar(Carro instance) {
		try {
			carroDAO.salvar(instance, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}
	
	
	

	@Override
	public void atualizar(Carro instance) {
		try {
			carroDAO.atualizar(instance, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}

	@Override
	public void remover(Long id) {
		try {
			carroDAO.remover(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}

	@Override
	public Carro obter(Long id) {
		Carro carro = null;
		try {
			carro = carroDAO.obterPorId(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		return carro;
	}

	@Override
	public List<Carro> listar() {
		List<Carro> carros = null;
		try {
			carros = carroDAO.listar(getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		return carros;
	}

	public void adicionar(Long idCarro, Long idAcessorio) {
		try {
			Carro carro = obter(idCarro);
			Acessorio acessorio = acessorioDAO.obterPorId(idAcessorio, getEntityManager());

			List<Acessorio> acessorios = carro.getAcessorios();
			Boolean adicionado = false;

			if (acessorios == null) {
				acessorios = new ArrayList<Acessorio>();
			} else {
				for (Acessorio acessorioDB : acessorios) {
					if (acessorioDB.getId().equals(idAcessorio)) {
						adicionado = true;
						break;
					}
				}
			}

			if (!adicionado) {
				acessorios.add(acessorio);
				carro.setAcessorios(acessorios);
				carroDAO.atualizar(carro, getEntityManager());
			}

		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}
}