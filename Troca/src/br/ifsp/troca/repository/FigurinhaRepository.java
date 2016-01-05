package br.ifsp.troca.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.ifsp.troca.entities.Figurinha;

public class FigurinhaRepository {

	private EntityManager manager;
	
	/*------------------------------------------------
	 * Construtor da Classe
	 *------------------------------------------------
	 * Quando a classe � instanciada, recebe como 
	 * par�metro o EntityManager j� criado, o armazena
	 * no atributo manager da classe e o utiliza para
	 * realizar as transa��es necess�rias.
	 */ 
	public FigurinhaRepository(EntityManager manager){
		this.manager = manager;
	}
	
	/*
	 * M�todo, sem retorno, que abre uma transa��o a 
	 * partir do atributo manager, persiste o objeto
	 * do tipo Figurinha recebido como par�metro e
	 * o envia para o BD, ao final fecha o manager.
	 */
	public Boolean adiciona(Figurinha fig){
		try{
			this.manager.getTransaction().begin();
			this.manager.persist(fig);
			this.manager.getTransaction().commit();
			this.manager.close();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public Boolean alterar(Figurinha fig){
		try{
			this.manager.getTransaction().begin();
			this.manager.merge(fig);
			this.manager.getTransaction().commit();
			this.manager.close();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public Figurinha busca(int id){
		return this.manager.find(Figurinha.class, id);
	}
	
	public List<Figurinha> buscaTodos(){
		TypedQuery<Figurinha> query = manager.createQuery(
				"FROM Figurinha", Figurinha.class);
		List<Figurinha> result = query.getResultList();
		this.manager.close();
		return result;
	}
	
	// M�todo: Remove do BD a figurinha que possui o id recebido como par�mtro.
	// Retorno: sem
	public Boolean remove(int id){
		try{
			this.manager.getTransaction().begin();
			Figurinha fig = this.manager.find(Figurinha.class, id);
			this.manager.remove(fig);
			this.manager.getTransaction().commit();
			this.manager.close();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public List<Figurinha> buscaFigurinhaPorAlbum(int id){

		String querySql="FROM Figurinha f"
				+" WHERE f.album.id = "+id;	
		
		TypedQuery<Figurinha> query = manager.createQuery(querySql, Figurinha.class);
		
		List<Figurinha> result = query.getResultList();
		this.manager.close();
		return result;
	}
}
