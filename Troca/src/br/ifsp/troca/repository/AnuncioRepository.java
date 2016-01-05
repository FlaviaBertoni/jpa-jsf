package br.ifsp.troca.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.ifsp.troca.entities.Anuncio;

public class AnuncioRepository {
	
	private EntityManager manager;
	
	/*------------------------------------------------
	 * Construtor da Classe
	 *------------------------------------------------
	 * Quando a classe � instanciada, recebe como 
	 * par�metro o EntityManager j� criado, o armazena
	 * no atributo manager da classe e o utiliza para
	 * realizar as transa��es necess�rias.
	 */ 	
	public AnuncioRepository(EntityManager manager){
		this.manager = manager;
	}
	
	public Boolean adiciona(Anuncio a){
		try{
			System.out.println("----- REPOSITORY ----");
			System.out.println("FIGURINHA");
			System.out.println("Id: "+a.getFigurinha().getId());
			System.out.println("Cod: "+a.getFigurinha().getCod());
			System.out.println("Grupo: "+a.getFigurinha().getGrupo());
			System.out.println("Nome: "+a.getFigurinha().getNome());
			System.out.println("Album: "+a.getFigurinha().getAlbum().getId());
			System.out.println("ALBUM");
			System.out.println("Id: "+a.getFigurinha().getAlbum().getId());
			System.out.println("Nome: "+a.getFigurinha().getAlbum().getNome());
			System.out.println("Categoria: "+a.getFigurinha().getAlbum().getCategoria());
			System.out.println("Ano: "+a.getFigurinha().getAlbum().getAno());
			System.out.println("Editora: "+a.getFigurinha().getAlbum().getEditora());
			System.out.println("Pais: "+a.getFigurinha().getAlbum().getPais());
			System.out.println("------------------------");
			this.manager.getTransaction().begin();
			this.manager.persist(a);
			this.manager.getTransaction().commit();
			this.manager.close();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public List<Anuncio> buscaTodos(){
		TypedQuery<Anuncio> query = manager.createQuery(
				"FROM Anuncio", Anuncio.class);
		List<Anuncio> result = query.getResultList();
		this.manager.close();
		return result;
	}
	
	public List<Anuncio> buscaAnuncioPorUsuario(int id){
		try{
			String querySql = "FROM Anuncio a"
							+ " WHERE a.usuario.id = :id";
			TypedQuery<Anuncio> query = manager.createQuery(querySql, Anuncio.class)
					.setParameter("id", id);
			List<Anuncio> result = query.getResultList();
			this.manager.close();
			return result;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public Boolean remove(int id){
		try{
			this.manager.getTransaction().begin();
			Anuncio a = this.manager.find(Anuncio.class, id); 
			this.manager.remove(a);
			this.manager.getTransaction().commit();
			this.manager.close();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
}
