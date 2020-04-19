package com.github.hansonhsc.loan.bean;



import java.io.IOException;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;

import com.github.hansonhsc.loan.dao.UserDao;
import com.github.hansonhsc.loan.model.User;
import com.github.hansonhsc.loan.service.UserServiceInterface;
import com.github.hansonhsc.loan.utils.SessionUtils;



@ManagedBean
@SessionScoped
public class Login implements Serializable {
	
	private User utenteLoggato;
	private String pwd;
	private String username;

	  @ManagedProperty(value="#{UserService}")
	    UserServiceInterface userService;

	//validate login
	public String validateUsernamePassword() {
		try {
			System.out.println("ACCESS REQUEST FOR USER "+username+" password "+pwd);

			User user = new User();
			user=getUserService().getUserByUsername(username);
			if (null != user) {
				//
				String digestedPassword = encode(pwd);	
				
				if (!user.getPassword().equals(digestedPassword)){
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(				
							FacesMessage.SEVERITY_ERROR,"Incorrect Username and Passowrd",""));
					return "login";
				}
				else {
					

					utenteLoggato = new User();
					utenteLoggato = user;
				
					HttpSession session = SessionUtils.getSession();
					session.setAttribute("utenteLoggato", utenteLoggato);																

					
					return "OK";
				}
			} else {
				System.out.println("USERNAME NON TROVATA");
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR,"UserId e Passowrd non corrette.",""));
				return "login";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(				
				FacesMessage.SEVERITY_ERROR,"Incorrect Username and Passowrd",""));
		return "login";
	}


	
	
	public UserServiceInterface getUserService() {
		return userService;
	}




	public void setUserService(UserServiceInterface userService) {
		this.userService = userService;
	}




	public void keepSessionAlive(){
		System.out.println("************** SESSIONE RIPRESA **********************+ ");
		//logout();
	}

	public User getUtenteLoggato() {
		return utenteLoggato;
	}

	public void setUtenteLoggato(User utenteLoggato) {
		this.utenteLoggato = utenteLoggato;
	}



	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}



	 private String encode(String string) throws NoSuchAlgorithmException{
	  		String base64 = Base64.encodeBase64String(string.getBytes());
	  		
	  		return base64;
	  	}
	
	
}
