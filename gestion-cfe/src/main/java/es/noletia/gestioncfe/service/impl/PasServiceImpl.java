/**
 * 
 */
package es.noletia.gestioncfe.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.noletia.gestioncfe.dao.PasDAO;
import es.noletia.gestioncfe.modelo.Pas;
import es.noletia.gestioncfe.service.PasService;

/**
 * @author ramon
 *
 */
@Service
public class PasServiceImpl implements PasService {
	
	@Autowired
	private PasDAO companiasDAO;

	/* (non-Javadoc)
	 * @see es.noletia.gestioncfe.service.CompaniasService#buscarCompanias(java.util.Map)
	 */
	@Override
	public List<Pas> buscarCompanias(Map<String, Object> parametros) {
		// creamos una lista ficticia
		List<Pas> lista = new ArrayList<Pas>();
		Pas c1 = new Pas();
		c1.setNombre("Compañía 1");
		Pas c2 = new Pas();
		c2.setNombre("Compañía 2");
		Pas c3 = new Pas();
		c3.setNombre("Compañía 3");
		lista.add(c1);
		lista.add(c2);
		lista.add(c3);
		
		
		return lista;
	}

	@Override
	public void alta(Pas object) {
		companiasDAO.alta(object);
	}

	@Override
	public void borra(Pas object) {
		companiasDAO.borra(object);
	}

	@Override
	public void actualiza(Pas object) {
		companiasDAO.actualiza(object);
	}

	@Override
	public Pas getElemento(Pas object) {
		return companiasDAO.getElemento(object);
	}
	
	@Override
	public Pas getElementoPorId(Long id){
		return companiasDAO.getElementoPorId(id);
	}
	
	
	@Override
	public List<Pas> getListaElementos() {
		return companiasDAO.getListaElementos();
	}

	@Override
	public List<Pas> getElementosFiltrados(Map<String, Object> parametros) {
		return companiasDAO.getElementosFiltrados(parametros);
	}

	/**
	 * @return the companiasDAO
	 */
	public PasDAO getCompaniasDAO() {
		return companiasDAO;
	}

	/**
	 * @param companiasDAO the companiasDAO to set
	 */
	public void setCompaniasDAO(PasDAO companiasDAO) {
		this.companiasDAO = companiasDAO;
	}

}
