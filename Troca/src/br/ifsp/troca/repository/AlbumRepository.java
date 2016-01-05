package br.ifsp.troca.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.ifsp.troca.entities.Album;

public class AlbumRepository {

	private EntityManager manager;
	
	/*------------------------------------------------
	 * Construtor da Classe
	 *------------------------------------------------
	 * Quando a classe é instanciada, recebe como 
	 * par�metro o EntityManager j� criado, o armazena
	 * no atributo manager da classe e o utiliza para
	 * realizar as transações necessárias.
	 */
	public AlbumRepository(EntityManager manager){
		this.manager = manager;
	}
	
	// Método: abre uma transação a partir do atributo manager, persiste 
	// o objeto do tipo Album recebido como par�metro e o envia para o BD,
	// ao final fecha o manager.
	// Retorno: sem
	public Boolean adiciona(Album al){
		try{
			this.manager.getTransaction().begin();
			this.manager.persist(al);
			this.manager.getTransaction().commit();
			this.manager.close();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	// Método: Abre a transação, persiste o objeto Album recebido como
	// par�metro, encerra a transação e fecha o manager.
	// Retorno: sem
	public Boolean altera(Album al){	
		try{
			this.manager.getTransaction().begin();
			this.manager.merge(al);
			this.manager.getTransaction().commit();
			this.manager.close();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	// Método: busca o album no BD que possuia como identificador, o id
	// recebido como par�metro e o retorna.
	// Retorno: Album
	public Album busca(int id){
		return this.manager.find(Album.class, id);
	}

	// Método: busca todos os albuns que estão guardados no BD.
	// Retorno: Lista de objetos do tipo Album
	public List<Album> buscaTodos(){
		TypedQuery<Album> query = manager.createQuery("FROM Album a", Album.class);
		return query.getResultList();
	}

	// Método: Remove do BD o album que possui o id recebido como par�mtro.
	// Retorno: sem
	public Boolean remove(int id){
		try{
			this.manager.getTransaction().begin();
			Album al = this.manager.find(Album.class, id);
			this.manager.remove(al);
			this.manager.getTransaction().commit();
			this.manager.close();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
}
