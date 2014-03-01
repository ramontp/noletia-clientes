/**
 * 
 */
package es.noletia.gestioncfe.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.noletia.gestioncfe.dao.ProvinciasDAO;
import es.noletia.gestioncfe.modelo.Provincias;
import es.noletia.gestioncfe.service.ProvinciasService;

/**
 * @author ramon
 *
 */
@Service
public class ProvinciasServiceImpl implements ProvinciasService {

	@Autowired
	private ProvinciasDAO provinciasDAO;

	
	/**
	 * @return the provinciasDAO
	 */
	public ProvinciasDAO getProvinciasDAO() {
		return provinciasDAO;
	}

	/**
	 * @param provinciasDAO the provinciasDAO to set
	 */
	public void setProvinciasDAO(ProvinciasDAO provinciasDAO) {
		this.provinciasDAO = provinciasDAO;
	}

	@Override
	public void alta(Provincias object) {
		provinciasDAO.alta(object);
	}

	@Override
	public void borra(Provincias object) {
		provinciasDAO.borra(object);
	}

	@Override
	public void actualiza(Provincias object) {
		provinciasDAO.actualiza(object);
	}

	@Override
	public Provincias getElemento(Provincias object) {
		return provinciasDAO.getElemento(object);
	}

	@Override
	public Provincias getElementoPorId(Long id) {
		return provinciasDAO.getElementoPorId(id);
	}

	@Override
	public List<Provincias> getListaElementos() {
		return provinciasDAO.getListaElementos();
	}

	@Override
	public List<Provincias> getElementosFiltrados(Map<String, Object> parametros) {
		return provinciasDAO.getElementosFiltrados(parametros);
	}

}
