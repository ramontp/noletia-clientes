/**
 * 
 */
package es.noletia.gestioncfe.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import es.noletia.gestioncfe.constantes.NoletiaConstantes;
import es.noletia.gestioncfe.modelo.UsuarioSesion;
import es.noletia.gestioncfe.service.AutenticacionService;


/**
 * @author ramon
 *
 */
@Component
@Scope("prototype")
public class InicioAction extends ComunAction{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private AutenticacionService autenticacionService;
		
	public String inicio(){
		UsuarioSesion user = autenticacionService.recuperaUsuarioSSO();
		
		if (user == null){
			return ERROR;
		}
		
		session.put(NoletiaConstantes.USUARIO_AUTENTICADO, user);

		return SUCCESS;
	}

	/**
	 * @return the autenticacionService
	 */
	public AutenticacionService getAutenticacionService() {
		return autenticacionService;
	}

	/**
	 * @param autenticacionService the autenticacionService to set
	 */
	public void setAutenticacionService(AutenticacionService autenticacionService) {
		this.autenticacionService = autenticacionService;
	}

}
