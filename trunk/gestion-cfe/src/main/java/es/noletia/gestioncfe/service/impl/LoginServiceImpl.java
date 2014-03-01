/**
 * 
 */
package es.noletia.gestioncfe.service.impl;

import org.springframework.stereotype.Service;

import es.noletia.gestioncfe.modelo.UsuarioSesion;
import es.noletia.gestioncfe.service.LoginService;

/**
 * @author ramon
 *
 */
@Service
public class LoginServiceImpl implements LoginService {

	/* (non-Javadoc)
	 * @see es.noletia.gestioncfe.service.LoginService#autenticarUsuario(es.noletia.gestioncfe.modelo.UsuarioSesion)
	 */
	@Override
	public UsuarioSesion autenticarUsuario(UsuarioSesion usuario) {
		//TODO: autenticar contra base de datos
		if (usuario.getUsuario().equals("admin") && usuario.getPassword().equals("admin")){
			return usuario;
		} 
		return null;
	}

}
