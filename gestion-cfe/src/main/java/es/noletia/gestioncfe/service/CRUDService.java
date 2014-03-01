/**
 * 
 */
package es.noletia.gestioncfe.service;

import java.util.List;
import java.util.Map;

/**
 * @author ramon
 *
 */
public interface CRUDService<T> {
	public void alta(T object);
	public void borra(T object);
	public void actualiza(T object);
	public T getElemento(T object);
	public T getElementoPorId(Long id);
	public List<T> getListaElementos();
	public List<T> getElementosFiltrados(Map<String, Object> parametros);
}
