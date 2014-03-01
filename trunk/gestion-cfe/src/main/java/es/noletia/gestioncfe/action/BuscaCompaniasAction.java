/**
 * 
 */
package es.noletia.gestioncfe.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import es.noletia.gestioncfe.modelo.Pas;
import es.noletia.gestioncfe.service.PasService;

/**
 * @author ramon
 *
 */
@Component
@Scope("prototype")
public class BuscaCompaniasAction extends ComunAction {

	private static final long serialVersionUID = 1L;
	
	private PasService companiasService;
	private List<Pas> listaCompanias;
	
	public String inicio(){
		//mostramos todas las compañias
		Map<String, Object> parametros = new HashMap<String, Object>(); 
		listaCompanias = companiasService.buscarCompanias(parametros);
		return SUCCESS;
	}
	
	public String buscar(){
		Map<String, Object> parametros = new HashMap<String, Object>();
		listaCompanias = companiasService.buscarCompanias(parametros);
		return SUCCESS;
	}

	/**
	 * @return the companiasService
	 */
	public PasService getCompaniasService() {
		return companiasService;
	}

	/**
	 * @param companiasService the companiasService to set
	 */
	public void setCompaniasService(PasService companiasService) {
		this.companiasService = companiasService;
	}

	/**
	 * @return the listaCompanias
	 */
	public List<Pas> getListaCompanias() {
		return listaCompanias;
	}

	/**
	 * @param listaCompanias the listaCompanias to set
	 */
	public void setListaCompanias(List<Pas> listaCompanias) {
		this.listaCompanias = listaCompanias;
	}

}
