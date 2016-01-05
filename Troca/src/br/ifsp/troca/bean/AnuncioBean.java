package br.ifsp.troca.bean;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.ifsp.troca.entities.Album;
import br.ifsp.troca.entities.Anuncio;
import br.ifsp.troca.entities.Figurinha;
import br.ifsp.troca.entities.Usuario;
import br.ifsp.troca.repository.AlbumRepository;
import br.ifsp.troca.repository.AnuncioRepository;
import br.ifsp.troca.repository.FigurinhaRepository;

@ManagedBean
@ViewScoped
public class AnuncioBean {
	
	private int id;
	private String titulo;
	private String descricao;
	private Date data = new Date();
	private Usuario usuario;
	private int id_usuario;
	private List<Usuario> usuarios;
	private List<Anuncio> anuncios;
	private List<Anuncio> anunciosUsuario;
	private List<Figurinha> figurinhas;
	private Figurinha figurinha = new Figurinha();
	private List<Album> albuns;
	private int id_album=1;
	private int id_figurinha;
	private Anuncio anuncioSelecionado;
	
	// Construtor: carrega as listas de usuarios e anuncios
	public AnuncioBean(){
		AnuncioRepository anRepository = new AnuncioRepository(TFUtil.getManager());
		this.anuncios = anRepository.buscaTodos();
		carregaAlbuns();
		carregaFigurinhasAlbum();
		this.figurinha = figurinhas.get(0);
		anRepository = new AnuncioRepository(TFUtil.getManager());
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
		this.usuario = (Usuario) session.getAttribute("usuario");
		this.id_usuario = usuario.getId();
		this.anunciosUsuario = anRepository.buscaAnuncioPorUsuario(id_usuario);
	}
	
	public void cadastrarAnuncio(){
		
		Anuncio an = new Anuncio();
		an.setTitulo(this.titulo);
		an.setDescricao(this.descricao);
		an.setData(this.data);
		FigurinhaRepository figRepository = new FigurinhaRepository(TFUtil.getManager());
		this.figurinha = figRepository.busca(id_figurinha);
		an.setFigurinha(this.figurinha);
		an.setUsuario(this.usuario);
		
		AnuncioRepository anRepository = new AnuncioRepository(TFUtil.getManager());

		if(anRepository.adiciona(an)){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "anúncio cadastrada com êxito."));
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Falha", "não foi possível cadastrar o anúncio."));
		}
	}
	
	public String excluiAnuncio(int id){
		AnuncioRepository anRepository = new AnuncioRepository(TFUtil.getManager());
		if(anRepository.remove(id)){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "anúncio excluido com êxito."));
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Falha", "não foi possível excluir o anúncio."));
		}
		anRepository = new AnuncioRepository(TFUtil.getManager());
		this.anunciosUsuario = anRepository.buscaAnuncioPorUsuario(id_usuario);
		return "#";
	}
	
	public void carregaAlbuns(){
		AlbumRepository alRepository = new AlbumRepository(TFUtil.getManager());
		this.setAlbuns(alRepository.buscaTodos());
	}
	
	public void carregaFigurinhasAlbum(){
		FigurinhaRepository figRepository = new FigurinhaRepository(TFUtil.getManager());
		this.figurinhas =  figRepository.buscaFigurinhaPorAlbum(id_album);
	}

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
	public Figurinha getFigurinha() {
		return figurinha;
	}
	public void setFigurinha(Figurinha figurinha) {
		this.figurinha = figurinha;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	public List<Anuncio> getAnuncios() {
		return anuncios;
	}
	public void setAnuncios(List<Anuncio> anuncios) {
		this.anuncios = anuncios;
	}
	public int getId_album() {
		return id_album;
	}

	public void setId_album(int id_album) {
		this.carregaFigurinhasAlbum();
		this.id_album = id_album;
	}

	public List<Figurinha> getFigurinhas() {
		return figurinhas;
	}

	public void setFigurinhas(List<Figurinha> figurinhas) {
		this.figurinhas = figurinhas;
	}

	public List<Album> getAlbuns() {
		return albuns;
	}

	public void setAlbuns(List<Album> albuns) {
		this.albuns = albuns;
	}

	public int getId_figurinha() {
		return id_figurinha;
	}

	public void setId_figurinha(int id_figurinha) {
		this.id_figurinha = id_figurinha;
	}

	public Anuncio getAnuncioSelecionado() {
		return anuncioSelecionado;
	}

	public void setAnuncioSelecionado(Anuncio anuncioSelecionado) {
		this.anuncioSelecionado = anuncioSelecionado;
	}

	public List<Anuncio> getAnunciosUsuario() {
		return anunciosUsuario;
	}

	public void setAnunciosUsuario(List<Anuncio> anunciosUsuario) {
		this.anunciosUsuario = anunciosUsuario;
	}
}
