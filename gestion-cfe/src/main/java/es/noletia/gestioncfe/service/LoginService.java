/**
 * 
 */
package es.noletia.gestioncfe.service;

import es.noletia.gestioncfe.modelo.UsuarioSesion;

/**
 * @author ramon
 *
 */
public interface LoginService {

	public UsuarioSesion autenticarUsuario(UsuarioSesion usuario);
	
}
