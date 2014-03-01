/**
 * 
 */
package es.noletia.gestioncfe.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.noletia.gestioncfe.dao.FuncionesDAO;
import es.noletia.gestioncfe.modelo.Funciones;
import es.noletia.gestioncfe.service.FuncionesService;

/**
 * @author ramon
 *
 */
@Service
public class FuncionesServiceImpl implements FuncionesService {
	
	@Autowired
	private FuncionesDAO funcionesDAO;

	/* (non-Javadoc)
	 * @see es.noletia.gestioncfe.service.FuncionesService#buscarFunciones(java.util.Map)
	 */
	@Override
	public List<Funciones> buscarFunciones(Map<String, Object> parametros) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alta(Funciones object) {
		funcionesDAO.alta(object);
	}

	@Override
	public void borra(Funciones object) {
		funcionesDAO.borra(object);
	}

	@Override
	public void actualiza(Funciones object) {
		funcionesDAO.actualiza(object);
	}

	@Override
	public Funciones getElemento(Funciones object) {
		return funcionesDAO.getElemento(object);
	}

	@Override
	public Funciones getElementoPorId(Long id) {
		return funcionesDAO.getElementoPorId(id);
	}

	@Override
	public List<Funciones> getListaElementos() {
		return funcionesDAO.getListaElementos();
	}

	@Override
	public List<Funciones> getElementosFiltrados(Map<String, Object> parametros) {
		return funcionesDAO.getElementosFiltrados(parametros);
	}

	/**
	 * @return the funcionesDAO
	 */
	public FuncionesDAO getFuncionesDAO() {
		return funcionesDAO;
	}

	/**
	 * @param funcionesDAO the funcionesDAO to set
	 */
	public void setFuncionesDAO(FuncionesDAO funcionesDAO) {
		this.funcionesDAO = funcionesDAO;
	}

}
