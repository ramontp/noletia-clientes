/**
 * 
 */
package es.noletia.gestioncfe.service;

import java.util.List;
import java.util.Map;

import es.noletia.gestioncfe.modelo.Pas;

/**
 * @author ramon
 *
 */
public interface PasService  extends CRUDService<Pas>{

	public List<Pas> buscarCompanias(Map<String, Object> parametros);
	
}
