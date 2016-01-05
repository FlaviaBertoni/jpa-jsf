package br.ifsp.troca.bean;
//public class AutenticarBean {}
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

import br.ifsp.troca.entities.Usuario;
import br.ifsp.troca.repository.UsuarioRepository;

@ViewScoped
@ManagedBean
public class AutenticarBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String usuario;
	private String senha;
	
	public String autenticar() {
		try {
			EntityManager manager = TFUtil.getManager();
			UsuarioRepository uRepository = new UsuarioRepository(TFUtil.getManager());
			manager.getTransaction().begin();
			this.senha = TFUtil.md5(this.senha);
			System.out.println("MD5: " + this.senha);
			Usuario u = uRepository.busca(this.usuario, this.senha);
			// System.out.println("Senha do banco: " + u.getSenha());
			manager.getTransaction().commit();

			FacesContext fc = FacesContext.getCurrentInstance();

			if (u != null) {
				ExternalContext ec = fc.getExternalContext();
				HttpSession session = (HttpSession) ec.getSession(false);
				if (u.getTipo() == 0) {
					session.setAttribute("usuario", u);
					System.out.println("user");
					return "/user/inicio";
				} else if (u.getTipo() == 1) {
					session.setAttribute("administrador", u);
					System.out.println("admin");
					return "/admin/inicio";
				}
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha", "usuário ou senha incorretos."));
				System.out.println("Autenticar");
				return "Autenticar";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Null");
		return null;
	}

	public String registrarSaida() {
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();
		HttpSession session = (HttpSession) ec.getSession(false);
	
		if (session.getAttribute("usuario") != null) {
		session.removeAttribute("usuario");
		} else if (session.getAttribute("administrador") != null) {
		session.removeAttribute("administrador");
		}
		
		return "Autenticar";
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}