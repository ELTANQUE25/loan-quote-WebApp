package com.github.hansonhsc.loan.filter;

import java.io.IOException;
import java.util.ResourceBundle;

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

import org.apache.commons.codec.binary.Base64;

import com.github.hansonhsc.loan.model.User;

@WebFilter(filterName = "AuthSSOFilter", urlPatterns = { "*.xhtml" })
public class AuthorizationFilter implements Filter {


	private User utenteLoggato;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		try {


			System.out.println("Inizio filter");

			HttpServletRequest requestHttp = (HttpServletRequest) request;
			HttpServletResponse resp = (HttpServletResponse) response;
			HttpSession httpSession = requestHttp.getSession(true);
//			System.out.println("La richiesta è "+requestHttp);
			String requestURI = requestHttp.getRequestURI();
			
			if (requestURI.indexOf("/login.xhtml") >= 0
					|| (null != httpSession && null != httpSession.getAttribute("utenteLoggato"))
					//	|| reqURI.indexOf("/public/") >= 0
					|| requestURI.contains("javax.faces.resource")) {
				System.out.println("login effettuato con successo");
				chain.doFilter(request, response);	
			}else {
				resp.sendRedirect(requestHttp.getContextPath() + "/login.xhtml");	
			}



		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void destroy() {

	}


	//	@WebFilter("/secured/*")
	//	public class NoCacheFilter implements Filter {
	//
	//	    @Override
	//	    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
	//	        HttpServletRequest request = (HttpServletRequest) req;
	//	        HttpServletResponse response = (HttpServletResponse) res;
	//
	//	        if (!request.getRequestURI().startsWith(request.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER)) { // Skip JSF resources (CSS/JS/Images/etc)
	//	            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	//	            response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	//	            response.setDateHeader("Expires", 0); // Proxies.
	//	        }
	//
	//	        chain.doFilter(req, res);
	//	    }
	//
	//	    // ...
	//
	//	}

}
