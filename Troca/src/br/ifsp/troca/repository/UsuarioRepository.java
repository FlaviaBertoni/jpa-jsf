package br.ifsp.troca.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.ifsp.troca.entities.Usuario;

public class UsuarioRepository {

	private EntityManager manager;

	/*------------------------------------------------
	* Construtor da Classe
	*------------------------------------------------
	* Quando a classe é instanciada, recebe como 
	* parâmetro o EntityManager já criado, o armazena
	* no atributo manager da classe e o utiliza para
	* realizar as transações necessárias.
	*/
	public UsuarioRepository(EntityManager manager) {
		this.manager = manager;
	}

	/*
	 * Método, sem retorno, que abre uma transação a partir do atributo manager,
	 * persiste o objeto do tipo Usuario recebido como parâmetro e o envia para
	 * o BD, ao final fecha o manager.
	 */
	public Boolean adiciona(Usuario u) {
		try{
			this.manager.getTransaction().begin();
			this.manager.persist(u);
			this.manager.getTransaction().commit();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally {
			this.manager.close();
		}
	}

	public Boolean alterar(Usuario u) {
		try{
			this.manager.getTransaction().begin();
			this.manager.merge(u);
			this.manager.getTransaction().commit();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally {
			this.manager.close();
		}
	}

	public Usuario busca(String usuario, String senha) {
		String querySQL = "SELECT u FROM Usuario u WHERE u.usuario = :usuario AND u.senha = :senha";
		TypedQuery<Usuario> query = this.manager.createQuery(querySQL, Usuario.class).setParameter("usuario", usuario)
				.setParameter("senha", senha);
		List<Usuario> result = query.getResultList();
		Usuario u;
		if (result != null && result.size() != 0) {
			u = result.get(0);
			System.out.println("ENCONTROU!");
		} else {
			u = null;
		}
		this.manager.close();
		return u;
	}

	public Usuario busca(int id) {
		return this.manager.find(Usuario.class, id);
	}

	public Boolean remove(int id) {
		try{
			this.manager.getTransaction().begin();
			Usuario u = this.manager.find(Usuario.class, id);
			System.out.println(u.getId());
			this.manager.remove(u);
			this.manager.getTransaction().commit();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally {
			this.manager.close();
		}
	}
}