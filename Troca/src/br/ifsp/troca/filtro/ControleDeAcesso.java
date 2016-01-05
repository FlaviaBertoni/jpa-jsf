package br.ifsp.troca.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(servletNames = { "Faces Servlet" })
public class ControleDeAcesso implements Filter {
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		HttpServletResponse res;

		String path = req.getRequestURI();
		System.out.println("PATH:" + path);

		if (session.getAttribute("usuario") == null && session.getAttribute("administrador") == null) {
			if (path.startsWith("/Troca/javax.faces")) {
				chain.doFilter(request, response);
			}else if (path.equals("/Troca/Autenticar.xhtml")) {
				chain.doFilter(request, response);
			} else {
				res = (HttpServletResponse) response;
				res.sendRedirect("/Troca/Autenticar.xhtml");
			}
		} else if (session.getAttribute("usuario") != null) {
			if (path.startsWith("/Troca/javax.faces")) {
				chain.doFilter(request, response);
			}else if (path.startsWith("/Troca/user/")) {
				chain.doFilter(request, response);
			} else {
				res = (HttpServletResponse) response;
				res.sendRedirect("/Troca/user/inicio.xhtml");
			}
		} else if (session.getAttribute("administrador") != null) {
			if (path.startsWith("/Troca/javax.faces")) {
				chain.doFilter(request, response);
			}else if (path.startsWith("/Troca/admin/")) {
				chain.doFilter(request, response);
			} else {
				res = (HttpServletResponse) response;
				res.sendRedirect("/Troca/admin/inicio.xhtml");
			}
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}
}
