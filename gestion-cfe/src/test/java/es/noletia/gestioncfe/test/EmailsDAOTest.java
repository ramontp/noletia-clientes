/**
 * 
 */
package es.noletia.gestioncfe.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.noletia.gestioncfe.dao.EmailsDAO;
import es.noletia.gestioncfe.dao.EspaciosDAO;
import es.noletia.gestioncfe.modelo.Emails;

/**
 * @author ramon
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/applicationContext.xml"})
public class EmailsDAOTest {

	@Autowired
	private EmailsDAO emailsDAO;
	@Autowired
	private EspaciosDAO espaciosDAO;

	
	public void testAlta(){
		//alta
		Emails em = new Emails();
		
		em.setEmail("aaaa@aaaa.es");
		em.setEspacio(espaciosDAO.getElementoPorId(Long.valueOf(1)));
		
		emailsDAO.alta(em);
		assert(true);
	}
	
	@Test
	public void testGetBaja(){
		emailsDAO.borra(emailsDAO.getElementoPorId(Long.valueOf(1)));
		assert(true);
	}
	
	/**
	 * @return the emailsDAO
	 */
	public EmailsDAO getEmailsDAO() {
		return emailsDAO;
	}

	/**
	 * @param emailsDAO the emailsDAO to set
	 */
	public void setEmailsDAO(EmailsDAO emailsDAO) {
		this.emailsDAO = emailsDAO;
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
