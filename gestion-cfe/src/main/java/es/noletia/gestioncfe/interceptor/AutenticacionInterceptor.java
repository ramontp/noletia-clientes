/**
 * 
 */
package es.noletia.gestioncfe.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import es.noletia.gestioncfe.constantes.NoletiaConstantes;
import es.noletia.gestioncfe.modelo.UsuarioSesion;

/**
 * @author ramon
 * 
 */
public class AutenticacionInterceptor implements Interceptor {

	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.interceptor.Interceptor#destroy()
	 */
	@Override
	public void destroy() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.interceptor.Interceptor#init()
	 */
	@Override
	public void init() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.opensymphony.xwork2.interceptor.Interceptor#intercept(com.opensymphony
	 * .xwork2.ActionInvocation)
	 */
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String, Object> sesion = invocation.getInvocationContext()
				.getSession();

		UsuarioSesion usuario = (UsuarioSesion) sesion
				.get(NoletiaConstantes.USUARIO_AUTENTICADO);

		if (usuario == null) {
			return Action.ERROR;
		} else {

			Action action = (Action) invocation.getAction();

			if (action instanceof UserAware) {
				if (!(NoletiaConstantes.ROL_ADMIN.equals(usuario.getRol())
						|| NoletiaConstantes.ROL_USUARIO.equals(usuario
								.getRol())) ) {
					return Action.ERROR;
				}
			} else if (action instanceof AdminAware){
				if (!NoletiaConstantes.ROL_ADMIN.equals(usuario.getRol())){
					return Action.ERROR;
				}
			}
			return invocation.invoke();
		}
	}

}
