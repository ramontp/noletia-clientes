/**
 * 
 */
package es.noletia.gestioncfe.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import es.noletia.gestioncfe.service.FuncionesService;

/**
 * @author ramon
 *
 */
@Component
@Scope("prototype")
public class BuscaFuncionesAction extends ComunAction {

	private static final long serialVersionUID = 1L;
	@Autowired
	private FuncionesService funcionesService;

	public String inicio(){
		return SUCCESS;
	}
	
	public String buscar(){
		return SUCCESS;
	}

	/**
	 * @return the funcionesService
	 */
	public FuncionesService getFuncionesService() {
		return funcionesService;
	}

	/**
	 * @param funcionesService the funcionesService to set
	 */
	public void setFuncionesService(FuncionesService funcionesService) {
		this.funcionesService = funcionesService;
	}

}
