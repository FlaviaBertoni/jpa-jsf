package br.ifsp.troca.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.ifsp.troca.entities.Album;
import br.ifsp.troca.repository.AlbumRepository;

@ManagedBean
@ViewScoped
public class AlbumBean {
	
	private int id; 
	private String nome;
	private int ano;
	private String editora;
	private String categoria;
	private String pais;
	private String busca;
	private String mensagem;
	private String paginaAnterior;
	private List<Album> albuns;
	private Album albumSelecionado;
	
	// Construtor: carrega a lista albuns com os dados do BD
	public AlbumBean(){
		AlbumRepository alRepository = new AlbumRepository(TFUtil.getManager());
		this.albuns = alRepository.buscaTodos();
	}
	
	// M�todo: Efetua o cadastro de um Album.
	// Retorno: String (nome da p�gina para qual ser� redirecionada) 
	public void cadastrarAlbum(){
		Album al = new Album();
		al.setNome(this.nome);
		al.setAno(this.ano);
		al.setEditora(this.editora);
		al.setCategoria(this.categoria);
		al.setPais(this.pais);
		al.setId(this.id);
		
		// Cria o AlbumRepository, passando como parametro o m�todo getManager
		// da classe TFUtil que retorna um Entity Manager
		AlbumRepository alRepository = new AlbumRepository((TFUtil.getManager()));
			
		// Persiste o objeto Album no BD e se teve sucesso cria a mensagem
		if(alRepository.adiciona(al)){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "álbum cadastrado com êxito."));
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Falha", "não foi possível cadastrar o álbum."));
		}
	}
	
	// M�todo: Efetua a altera��o de um Album
	// Retorno: String (nome da p�gina para qual ser� redirecionada) 
	public void alterarAlbum(){
				
		Album al = new Album();
		al.setNome(this.albumSelecionado.getNome());
		al.setAno(this.albumSelecionado.getAno());
		al.setEditora(this.albumSelecionado.getEditora());
		al.setCategoria(this.albumSelecionado.getEditora());
		al.setPais(this.albumSelecionado.getPais());
		al.setId(this.albumSelecionado.getId());
		
		AlbumRepository alRepository = new AlbumRepository(TFUtil.getManager());
		
		// Altera o objeto Album no BD e se teve sucesso cria a mensagem
		if(alRepository.altera(al)){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "álbum alterado com êxito."));
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Falha", "não foi possível alterar o álbum."));
		}
		
	}
	
	// M�todo: Efetua a exclus�o de um Album escolhido.
	// Retorno: String (nome da p�gina para qual ser� redirecionada) 	
	public void excluiAlbum(int id){
		
		AlbumRepository alRepository = new AlbumRepository(TFUtil.getManager());
		// Exclui o objeto Album que possui o id recebido como parâmetro
		// do BD e se teve sucesso cria a mensagem
		if(alRepository.remove(id)){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "álbum excluido com êxito."));
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Falha", "não foi possível excluir o álbum."));
		}
		alRepository = new AlbumRepository(TFUtil.getManager());
		this.albuns = alRepository.buscaTodos();
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

	public String getBusca() {
		return busca;
	}

	public void setBusca(String busca) {
		this.busca = busca;
	}

	public List<Album> getAlbuns() {
		return albuns;
	}

	public void setAlbuns(List<Album> albuns) {
		this.albuns = albuns;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getPaginaAnterior() {
		return paginaAnterior;
	}

	public void setPaginaAnterior(String paginaAnterior) {
		this.paginaAnterior = paginaAnterior;
	}

	public Album getAlbumSelecionado() {
		return albumSelecionado;
	}

	public void setAlbumSelecionado(Album albumSelecionado) {
		this.albumSelecionado = albumSelecionado;
	}
}
