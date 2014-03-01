/**
 * 
 */
package es.noletia.gestioncfe.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import es.noletia.gestioncfe.service.EspaciosService;

/**
 * @author ramon
 *
 */
@Component
@Scope("prototype")
public class BuscaEspaciosAction extends ComunAction {

	private static final long serialVersionUID = 1L;
	@Autowired
	private EspaciosService espaciosService;

	public String inicio(){
		return SUCCESS;
	}
	
	public String buscar(){
		return SUCCESS;
	}

	/**
	 * @return the espaciosService
	 */
	public EspaciosService getEspaciosService() {
		return espaciosService;
	}

	/**
	 * @param espaciosService the espaciosService to set
	 */
	public void setEspaciosService(EspaciosService espaciosService) {
		this.espaciosService = espaciosService;
	}

}
