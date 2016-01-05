package br.ifsp.troca.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name="anuncio")
public class Anuncio {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column (name="titulo", nullable=false)
	private String titulo;

	@Column (name="descricao", length=200)
	private String descricao;
	
	//Armazenar� somente a data
	@Temporal(TemporalType.DATE)
	@Column (name="data")
	private Date data;
	
	@ManyToOne
	@JoinColumn(name="figurinha_id")
	private Figurinha figurinha;

	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	//------------------------------------------
	// Getters e Setters
	//------------------------------------------	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Figurinha getFigurinha() {
		return figurinha;
	}

	public void setFigurinha(Figurinha figurinha) {
		this.figurinha = figurinha;
	}
	
}
