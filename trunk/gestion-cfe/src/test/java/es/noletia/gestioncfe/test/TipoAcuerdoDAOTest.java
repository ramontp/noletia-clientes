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

import es.noletia.gestioncfe.dao.TipoAcuerdoDAO;
import es.noletia.gestioncfe.modelo.TipoAcuerdo;

/**
 * @author ramon
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/applicationContext.xml"})
public class TipoAcuerdoDAOTest {

	@Autowired
	private TipoAcuerdoDAO tipoacuerdoDAO;
	
	@Test
	public void testTipoAcuerdo() {
		TipoAcuerdo ta = tipoacuerdoDAO.getElementoPorId(Long.valueOf(1));
		assert(ta != null);
		
		List<TipoAcuerdo> lista = tipoacuerdoDAO.getListaElementos();
		assert(lista != null);
	}
	/**
	 * @return the tipoacuerdoDAO
	 */
	public TipoAcuerdoDAO getTipoacuerdoDAO() {
		return tipoacuerdoDAO;
	}
	/**
	 * @param tipoacuerdoDAO the tipoacuerdoDAO to set
	 */
	public void setTipoacuerdoDAO(TipoAcuerdoDAO tipoacuerdoDAO) {
		this.tipoacuerdoDAO = tipoacuerdoDAO;
	}
}
