/**
 * 
 */
package es.noletia.clientes.test.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.noletia.clientes.dao.ProvinciaDAO;
import es.noletia.clientes.modelo.Provincia;

/**
 * @author ramon
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/applicationContext.xml"})
public class ProvinciaDAOTest {

	@Autowired
	private ProvinciaDAO provinciaDAO;
	
	@Test
	public void testGet(){
		List<Provincia> lista = provinciaDAO.getListaElementos();
		assert(lista != null);
		
		Provincia prov = lista.get(0);
		Provincia aux = null;
		aux = provinciaDAO.getElemento(prov);
		assert(aux != null);
		
		aux=null;
		aux = provinciaDAO.getElementoPorId(prov.getIdprovincia());
		assert(aux != null);
	}

	/**
	 * @return the provinciaDAO
	 */
	public ProvinciaDAO getProvinciaDAO() {
		return provinciaDAO;
	}

	/**
	 * @param provinciaDAO the provinciaDAO to set
	 */
	public void setProvinciaDAO(ProvinciaDAO provinciaDAO) {
		this.provinciaDAO = provinciaDAO;
	}
	
	
}
