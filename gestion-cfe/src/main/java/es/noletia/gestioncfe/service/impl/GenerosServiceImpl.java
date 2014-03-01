/**
 * 
 */
package es.noletia.gestioncfe.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.noletia.gestioncfe.dao.GenerosDAO;
import es.noletia.gestioncfe.modelo.Generos;
import es.noletia.gestioncfe.service.GenerosService;

/**
 * @author ramon
 *
 */
@Service
public class GenerosServiceImpl implements GenerosService {

	@Autowired
	public GenerosDAO generosDAO; 
	/* (non-Javadoc)
	 * @see es.noletia.gestioncfe.service.CRUDService#alta(java.lang.Object)
	 */
	@Override
	public void alta(Generos object) {
		generosDAO.alta(object);
	}

	/* (non-Javadoc)
	 * @see es.noletia.gestioncfe.service.CRUDService#borra(java.lang.Object)
	 */
	@Override
	public void borra(Generos object) {
		generosDAO.borra(object);
	}

	/* (non-Javadoc)
	 * @see es.noletia.gestioncfe.service.CRUDService#actualiza(java.lang.Object)
	 */
	@Override
	public void actualiza(Generos object) {
		generosDAO.actualiza(object);
	}

	/* (non-Javadoc)
	 * @see es.noletia.gestioncfe.service.CRUDService#getElemento()
	 */
	@Override
	public Generos getElemento(Generos object) {
		return generosDAO.getElemento(object);
	}

	/* (non-Javadoc)
	 * @see es.noletia.gestioncfe.service.CRUDService#getElementoPorId(java.lang.Long)
	 */
	@Override
	public Generos getElementoPorId(Long id) {
		return generosDAO.getElementoPorId(id);
	}

	/* (non-Javadoc)
	 * @see es.noletia.gestioncfe.service.CRUDService#getListaElementos()
	 */
	@Override
	public List<Generos> getListaElementos() {
		return generosDAO.getListaElementos();
	}

	/* (non-Javadoc)
	 * @see es.noletia.gestioncfe.service.CRUDService#getElementosFiltrados(java.util.Map)
	 */
	@Override
	public List<Generos> getElementosFiltrados(Map<String, Object> parametros) {
		return generosDAO.getElementosFiltrados(parametros);
	}

	/**
	 * @return the generosDAO
	 */
	public GenerosDAO getGenerosDAO() {
		return generosDAO;
	}

	/**
	 * @param generosDAO the generosDAO to set
	 */
	public void setGenerosDAO(GenerosDAO generosDAO) {
		this.generosDAO = generosDAO;
	}
	
	

}
