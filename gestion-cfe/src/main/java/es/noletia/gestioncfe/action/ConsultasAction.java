/**
 * 
 */
package es.noletia.gestioncfe.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import es.noletia.gestioncfe.interceptor.UserAware;

/**
 * @author ramon
 *
 */
@Component
@Scope("prototype")
public class ConsultasAction extends ComunAction implements UserAware {

	private static final long serialVersionUID = -447880446733111590L;
	
	public String entradaConsultas(){
		return SUCCESS;
	}

}
