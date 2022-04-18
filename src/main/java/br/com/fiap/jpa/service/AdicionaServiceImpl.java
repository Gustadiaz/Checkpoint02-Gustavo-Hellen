package br.com.fiap.jpa.service;

import java.util.List;

import br.com.fiap.entity.Adiciona;
import br.com.fiap.jpa.dao.impl.AdicionaDAOImpl;

public class AdicionaServiceImpl extends GenericService<Adiciona, Long> {
	private static AdicionaServiceImpl instance = null;
	private AdicionaDAOImpl adicionaDAO;

	private AdicionaServiceImpl() {
		adicionaDAO = AdicionaDAOImpl.getInstance();
	}

	public static AdicionaServiceImpl getInstance() {
		if (instance == null) {
			instance = new AdicionaServiceImpl();
		}
		return instance;
	}

	@Override
	public void cadastrar(Adiciona instance) {
		try {
			adicionaDAO.salvar(instance, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}

	@Override
	public void atualizar(Adiciona instance) {
		try {
			adicionaDAO.atualizar(instance, getEntityManager());
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
			adicionaDAO.remover(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}

	@Override
	public Adiciona obter(Long id) {
		Adiciona matricula = null;
		try {
			matricula = adicionaDAO.obterPorId(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
		return matricula;
	}

	@Override
	public List<Adiciona> listar() {
		List<Adiciona> adicionar = null;
		try {
			adicionar = adicionaDAO.listar(getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
		return adicionar;
	}
}
