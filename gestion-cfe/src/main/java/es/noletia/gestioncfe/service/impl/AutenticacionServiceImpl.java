/**
 * 
 */
package es.noletia.gestioncfe.service.impl;

import org.springframework.stereotype.Service;

import es.noletia.gestioncfe.modelo.UsuarioSesion;
import es.noletia.gestioncfe.service.AutenticacionService;

/**
 * @author ramon
 *
 */
@Service
public class AutenticacionServiceImpl implements AutenticacionService {

	/* (non-Javadoc)
	 * @see es.noletia.gestioncfe.service.AutenticacionService#recuperaUsuarioSesion()
	 */
	@Override
	public UsuarioSesion recuperaUsuarioSSO() {
		UsuarioSesion user = new UsuarioSesion();
		user.setUsuario("admin");
		user.setPassword("admin");
		user.setRol("ADMIN");
		return user;
	}

}
