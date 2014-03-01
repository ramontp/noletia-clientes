/**
 * 
 */
package es.noletia.gestioncfe.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;

import es.noletia.gestioncfe.constantes.NoletiaConstantes;
import es.noletia.gestioncfe.modelo.UsuarioSesion;
import es.noletia.gestioncfe.service.LoginService;


/**
 * @author ramon
 *
 */
@Component
@Scope("prototype")
public class LoginAction extends ComunAction {

	private static final long serialVersionUID = 1L;
	@Autowired
	private LoginService loginService;

	private String usuario;
	private String password;
	private Object usuarioSesion;
	
	public String login(){
		UsuarioSesion aux = new UsuarioSesion();
		aux.setUsuario(getUsuario());
		aux.setPassword(getPassword());
		usuarioSesion = loginService.autenticarUsuario(aux);
		
		if (usuarioSesion != null){
			session.put(NoletiaConstantes.USUARIO_AUTENTICADO, usuarioSesion);
			return ActionSupport.SUCCESS;
		} else {
			return ActionSupport.INPUT;
		}
	}
	
	public String logout(){
		session.clear();

		return SUCCESS;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the loginService
	 */
	public LoginService getLoginService() {
		return loginService;
	}

	/**
	 * @param loginService the loginService to set
	 */
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

}
