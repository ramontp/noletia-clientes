/**
 * 
 */
package es.noletia.gestioncfe.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.noletia.gestioncfe.dao.EspaciosDAO;
import es.noletia.gestioncfe.modelo.Espacios;
import es.noletia.gestioncfe.service.EspaciosService;

/**
 * @author ramon
 *
 */
@Service
public class EspaciosServiceImpl implements EspaciosService {
	
	@Autowired
	private EspaciosDAO espaciosDAO;

	/* (non-Javadoc)
	 * @see es.noletia.gestioncfe.service.EspaciosService#buscarEspacios(java.util.Map)
	 */
	@Override
	public List<Espacios> buscarEspacios(Map<String, Object> parametros) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alta(Espacios object) {
		espaciosDAO.alta(object);
	}

	@Override
	public void borra(Espacios object) {
		espaciosDAO.borra(object);
	}

	@Override
	public void actualiza(Espacios object) {
		espaciosDAO.actualiza(object);
	}

	@Override
	public Espacios getElemento(Espacios object) {
		return espaciosDAO.getElemento(object);
	}

	@Override
	public Espacios getElementoPorId(Long id) {
		return espaciosDAO.getElementoPorId(id);
	}

	@Override
	public List<Espacios> getListaElementos() {
		return espaciosDAO.getListaElementos();
	}

	@Override
	public List<Espacios> getElementosFiltrados(Map<String, Object> parametros) {
		return espaciosDAO.getElementosFiltrados(parametros);
	}

	/**
	 * @return the espaciosDAO
	 */
	public EspaciosDAO getEspaciosDAO() {
		return espaciosDAO;
	}

	/**
	 * @param espaciosDAO the espaciosDAO to set
	 */
	public void setEspaciosDAO(EspaciosDAO espaciosDAO) {
		this.espaciosDAO = espaciosDAO;
	}

}
