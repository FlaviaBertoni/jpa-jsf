package br.ifsp.troca.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table (name="album")
public class Album {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column (name="nome", nullable=false, length=45)
	private String nome;

	@Column(name="ano", nullable=false, length=4)
	private int ano;
	
	@Column(name="editora", nullable=false, length=45)
	private String editora;
	
	@Column(name="categoria", nullable=false, length=45)
	private String categoria;
	
	@Column(name="pais", nullable=false, length=45)
	private String pais;
	
	//-------------------------------------------
	// Getters e Setters
	//-------------------------------------------
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
}
