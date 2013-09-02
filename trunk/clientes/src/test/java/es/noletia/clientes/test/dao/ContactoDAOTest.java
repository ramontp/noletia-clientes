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

import es.noletia.clientes.dao.ClienteDAO;
import es.noletia.clientes.dao.ContactoDAO;
import es.noletia.clientes.modelo.Contacto;

/**
 * @author ramon
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/applicationContext.xml"})
public class ContactoDAOTest {

	@Autowired
	private ContactoDAO contactoDAO;
	@Autowired
	private ClienteDAO clienteDAO;

	@Test
	public void testGetter(){
		List<Contacto> lista = contactoDAO.getListaElementos();
		assert(lista != null);
	}
	
	@Test
	public void testAlta(){
		Contacto con = new Contacto();
		con.setContacto("Berta Recio");
		con.setDepartamento("Moral");
		con.setEmail("berta@mariscosrecio.es");
		con.setTelefono("900900901");
		con.setCliente(clienteDAO.getListaElementos().get(0));
		
		contactoDAO.alta(con);
		
		assert(con.getIdcontacto() != null);
	}
	
	/**
	 * @return the contactoDAO
	 */
	public ContactoDAO getContactoDAO() {
		return contactoDAO;
	}

	/**
	 * @param contactoDAO the contactoDAO to set
	 */
	public void setContactoDAO(ContactoDAO contactoDAO) {
		this.contactoDAO = contactoDAO;
	}

	/**
	 * @return the clienteDAO
	 */
	public ClienteDAO getClienteDAO() {
		return clienteDAO;
	}

	/**
	 * @param clienteDAO the clienteDAO to set
	 */
	public void setClienteDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}
}
