/**
 * 
 */
package es.noletia.gestioncfe.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.noletia.gestioncfe.dao.GenerosDAO;
import es.noletia.gestioncfe.modelo.Generos;

/**
 * @author ramon
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/applicationContext.xml"})
public class GenerosDAOTest {

	@Autowired
	private GenerosDAO generosDAO;
	
	
	public void testAlta(){
		Generos gen = new Generos();
		gen.setNombreGenero("Prueba");
		generosDAO.alta(gen);
		assert(true);
	}
	
	@Test
	public void testGetElementos(){
		List<Generos> lista = generosDAO.getListaElementos();
		assert(lista != null);
	}
	
	public void testGetElemento(){
		Generos gen = new Generos();
		gen.setIdgenero(Long.valueOf(4));
		gen = generosDAO.getElemento(gen);
		assert(true);
	}
	
	public void testBorra(){
		Generos gen = new Generos();
		gen.setNombreGenero("Otra Prueba");
		generosDAO.alta(gen);
		generosDAO.borra(gen);
		List<Generos> lista = generosDAO.getListaElementos();
		gen = lista.get(lista.size()-1);
		generosDAO.borraPorId(gen.getIdgenero());
	}
	
	public void testActualiza(){
		Generos gen = new Generos();
		gen.setNombreGenero("Otra Prueba");
		generosDAO.alta(gen);
		gen.setNombreGenero("Nombre Actualizado");
		generosDAO.actualiza(gen);
		
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
