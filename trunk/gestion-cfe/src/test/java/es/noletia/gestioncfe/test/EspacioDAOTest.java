package es.noletia.gestioncfe.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.noletia.gestioncfe.dao.EmailsDAO;
import es.noletia.gestioncfe.dao.EspaciosDAO;
import es.noletia.gestioncfe.dao.ProvinciasDAO;
import es.noletia.gestioncfe.dao.TipoAcuerdoDAO;
import es.noletia.gestioncfe.modelo.Emails;
import es.noletia.gestioncfe.modelo.Espacios;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/applicationContext.xml"})
public class EspacioDAOTest  {

	@Autowired
	private ProvinciasDAO provinciasDAO;
	@Autowired
	private TipoAcuerdoDAO tipoacuerdoDAO;
	@Autowired
	private EspaciosDAO espaciosDAO;
	@Autowired
	private EmailsDAO emailsDAO;
	
	
	public void testAlta() {
		Espacios obj = new Espacios();
		
		obj.setEspacio("Prueba de espacio");
		obj.setContacto("Contacto con tacto");
		obj.setProvincia(provinciasDAO.getElementoPorId(Long.valueOf(1)));
		obj.setTelefonos("telefonos");
		obj.setTipoacuerdo(tipoacuerdoDAO.getElementoPorId(Long.valueOf(1)));
		obj.setDescripcionacuerdo("descripcion del acuerdo");
		
		espaciosDAO.alta(obj);
		
		//insertamos dos emails de prueba
		Emails em1 = new Emails();
		em1.setEmail("aaaa@aaaa.es");
		em1.setEspacio(obj);
		
		Emails em2 = new Emails();
		em2.setEmail("bbbbb@bbb.es");
		em2.setEspacio(obj);
		
		emailsDAO.alta(em1);
		emailsDAO.alta(em2);
		
		assert(true);
	}
	
	@Test
	public void testGetListado(){
		List<Espacios> lista = espaciosDAO.getListaElementos();
		assert(lista != null);
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

}
