package br.ifsp.troca.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.ifsp.troca.entities.Usuario;
import br.ifsp.troca.repository.UsuarioRepository;

@ManagedBean
@ViewScoped
public class UsuarioBean {

	private int id;
	private String usuario;
	private String nome;
	private String email;
	private String senha;
	private int tipo;
	private Usuario usuariologado;

	public UsuarioBean(){
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
		if(session.getAttribute("usuario")!=null){
			this.usuariologado = (Usuario) session.getAttribute("usuario");
			this.senha = usuariologado.getSenha();
		}
	}
	
	public void cadastrarUsuario(){
		Usuario u = new Usuario();
		u.setNome(this.nome);
		u.setUsuario(this.usuario);
		u.setEmail(this.email);
		u.setSenha(TFUtil.md5(this.senha));
		u.setTipo(0);
		UsuarioRepository usrRepository = new UsuarioRepository(TFUtil.getManager());
		if(usrRepository.adiciona(u)){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "usuário cadastrado com êxito."));
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Falha", "não foi possível cadastrar o usuário."));
		}
	}
	
	public void alterarUsuario(){
		
		if(this.usuariologado.getSenha().equals("")){
			this.usuariologado.setSenha(senha);
		}
		Usuario u = new Usuario();
		u.setId(this.usuariologado.getId());
		u.setNome(this.usuariologado.getNome());
		u.setUsuario(this.usuariologado.getUsuario());
		u.setEmail(this.usuariologado.getEmail());
		u.setSenha(TFUtil.md5(this.usuariologado.getSenha()));
		UsuarioRepository usrRepository = new UsuarioRepository(TFUtil.getManager());
		if(usrRepository.alterar(u)){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "usuário alterado com êxito."));
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Falha", "não foi possível alterar o usuário."));
		}
	}
	
	public void excluirUsuario(){
		UsuarioRepository usrRepository = new UsuarioRepository(TFUtil.getManager());
		this.senha = TFUtil.md5(this.usuariologado.getSenha());
		String usuario = this.usuariologado.getUsuario();
		System.out.println("Usuario: "+usuario);
		System.out.println("Senha: "+senha);
		if(usrRepository.busca(usuario, this.senha)!=null){
			usrRepository = new UsuarioRepository(TFUtil.getManager());
			System.out.println("Id 1:"+this.usuariologado.getId());
			if(usrRepository.remove(this.usuariologado.getId())){
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "usuário excluído com êxito."));
				AutenticarBean autentica = new AutenticarBean();
				autentica.registrarSaida();
			}else{
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Falha", "não foi possível excluir o usuário."));
			}
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha", "usuário ou senha incorretos."));
		}
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}


	public Usuario getUsuariologado() {
		return usuariologado;
	}


	public void setUsuariologado(Usuario usuariologado) {
		this.usuariologado = usuariologado;
	}
}