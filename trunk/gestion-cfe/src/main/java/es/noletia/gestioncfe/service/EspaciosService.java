/**
 * 
 */
package es.noletia.gestioncfe.service;

import java.util.List;
import java.util.Map;

import es.noletia.gestioncfe.modelo.Espacios;

/**
 * @author ramon
 *
 */
public interface EspaciosService extends CRUDService<Espacios>{

	public List<Espacios> buscarEspacios(Map<String, Object> parametros);
	
}
