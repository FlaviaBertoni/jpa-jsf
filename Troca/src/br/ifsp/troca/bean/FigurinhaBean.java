package br.ifsp.troca.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.ifsp.troca.entities.Album;
import br.ifsp.troca.entities.Figurinha;
import br.ifsp.troca.repository.AlbumRepository;
import br.ifsp.troca.repository.FigurinhaRepository;

@ManagedBean
@ViewScoped
public class FigurinhaBean {
	
	private int id;
	private String cod;
	private String nome="";
	private String grupo="";
	private List<Album> albuns;
	private int id_album;
	private List<Figurinha> figurinhas;
	private Figurinha figurinhaSelecionada;
	
	// Construtor: carrega a lista albuns com os dados do BD
	public FigurinhaBean(){
		
		AlbumRepository alRepository = new AlbumRepository(TFUtil.getManager());
		this.albuns = alRepository.buscaTodos();
		FigurinhaRepository figRepository = new FigurinhaRepository(TFUtil.getManager());
		this.figurinhas = figRepository.buscaTodos();
		figurinhaSelecionada = new Figurinha();
		figurinhaSelecionada.setAlbum(this.albuns.get(0));
	}
	
	// M�todo: Efetua o cadastro de uma Figurinha.
	// Retorno: String (nome da p�gina para qual ser� redirecionada) 
	public void cadastrarFigurinha(){
		
		Figurinha fig = new Figurinha();
		fig.setCod(this.cod);
		fig.setNome(this.nome);
		fig.setGrupo(this.grupo);
		AlbumRepository alRepository = new AlbumRepository(TFUtil.getManager());
		fig.setAlbum(alRepository.busca(id_album));
		
		FigurinhaRepository figRepository = new FigurinhaRepository(TFUtil.getManager());
		
		if(figRepository.adiciona(fig)){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "figurinha cadastrada com êxito."));
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Falha", "não foi possível cadastrar a figurinha."));
		}
				
	}

	// M�todo: Efetua o cadastro de uma Figurinha.
	// Retorno: String (nome da p�gina para qual ser� redirecionada) 
	public void alterarFigurinha(){
		
		Figurinha fig = new Figurinha();
		fig.setId(this.figurinhaSelecionada.getId());
		fig.setCod(this.figurinhaSelecionada.getCod());
		fig.setNome(this.figurinhaSelecionada.getNome());
		fig.setGrupo(this.figurinhaSelecionada.getGrupo());
		fig.setAlbum(figurinhaSelecionada.getAlbum());

		FigurinhaRepository figRepository = new FigurinhaRepository(TFUtil.getManager());
				
		if(figRepository.alterar(fig)){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "figurinha alterada com êxito."));
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Falha", "não foi possível alterar a figurinha."));
		}
	}

	public void excluiFigurinha(int id){
		
		FigurinhaRepository figRepository = new FigurinhaRepository(TFUtil.getManager());
		if(figRepository.remove(id)){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "figurinha excluida com êxito."));
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Falha", "não foi possível excluir a figurinha."));
		}
		figRepository = new FigurinhaRepository(TFUtil.getManager());
		this.figurinhas = figRepository.buscaTodos();
	}
	
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
	public List<Album> getAlbuns() {
		return albuns;
	}
	public void setAlbuns(List<Album> albuns) {
		this.albuns = albuns;
	}
	public int getId_album() {
		return id_album;
	}
	public void setId_album(int id_album) {
		this.id_album = id_album;
	}
	public List<Figurinha> getFigurinhas() {
		return figurinhas;
	}

	public void setFigurinhas(List<Figurinha> figurinhas) {
		this.figurinhas = figurinhas;
	}

	public Figurinha getFigurinhaSelecionada() {
		return figurinhaSelecionada;
	}

	public void setFigurinhaSelecionada(Figurinha figurinhaSelecionada) {
		this.figurinhaSelecionada = figurinhaSelecionada;
	}
}
