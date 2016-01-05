package br.ifsp.troca.entities;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="figurinha")
public class Figurinha {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column (name="cod", nullable=false)
	private String cod; //Refere-se ao código que indentifica a figurinha, ex: A13B

	@Column (name="nome", length=45)
	private String nome;
	
	@Column (name="grupo", length=45)
	private String grupo;
	
	@ManyToOne(optional=false) // cascade=CascadeType.ALL
	@JoinColumn(name="album_id")
	private Album album;

	//-------------------------------------------
	// Getters e Setters
	//-------------------------------------------	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}
	
}
