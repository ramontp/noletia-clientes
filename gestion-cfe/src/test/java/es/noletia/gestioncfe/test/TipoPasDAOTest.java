/**
 * 
 */
package es.noletia.gestioncfe.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.noletia.gestioncfe.dao.TipoPasDAO;
import es.noletia.gestioncfe.modelo.TipoPas;

/**
 * @author ramon
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/applicationContext.xml"})
public class TipoPasDAOTest {

	@Autowired
	private TipoPasDAO tipopasDAO;
	
	@Test
	public void testGetters(){
		TipoPas tp = new TipoPas();
		tp.setIdtipopas(Long.valueOf(1));
		assert(tipopasDAO.getElemento(tp) != null);
		assert(tipopasDAO.getElementoPorId(Long.valueOf(1)) != null);
		assert(tipopasDAO.getListaElementos() != null);
	}

	/**
	 * @return the tipopasDAO
	 */
	public TipoPasDAO getTipopasDAO() {
		return tipopasDAO;
	}

	/**
	 * @param tipopasDAO the tipopasDAO to set
	 */
	public void setTipopasDAO(TipoPasDAO tipopasDAO) {
		this.tipopasDAO = tipopasDAO;
	}
}
