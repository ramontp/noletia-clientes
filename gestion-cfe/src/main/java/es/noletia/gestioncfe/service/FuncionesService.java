/**
 * 
 */
package es.noletia.gestioncfe.service;

import java.util.List;
import java.util.Map;

import es.noletia.gestioncfe.modelo.Funciones;

/**
 * @author ramon
 *
 */
public interface FuncionesService extends CRUDService<Funciones>{

	public List<Funciones> buscarFunciones(Map<String, Object> parametros);
	
}
