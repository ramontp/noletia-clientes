/**
 * 
 */
package es.noletia.clientes.test.dao;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.noletia.clientes.dao.ClienteDAO;
import es.noletia.clientes.dao.ProvinciaDAO;
import es.noletia.clientes.modelo.Cliente;
import es.noletia.clientes.modelo.Provincia;

/**
 * @author ramon
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/applicationContext.xml"})
public class ClienteDAOTest {

	@Autowired
	private ClienteDAO clienteDAO;
	@Autowired
	private ProvinciaDAO provinciaDAO;
	
	@Test
	public void testGetters(){
		List<Cliente> lista = clienteDAO.getListaElementos();
		assert(lista != null);
		Cliente c = new Cliente();
		c.setIdcliente(Long.valueOf(2));
		c = clienteDAO.getElemento(c);
		
		assert(c.getEmpresa() != null);
	}
	
	//@Test
	public void testAlta(){
		Cliente c = new Cliente();
		c.setEmpresa("IKEA");
		c.setDatosfiscales("Suecia");
		c.setContactado("Sevilla: Gloria");
		c.setFechault(new Date());
		c.setObservaciones("República independiente de tu casa");
		Provincia prov = new Provincia();
		prov.setNombre("Sevilla");
		c.setProvincia(provinciaDAO.getElemento(prov));
		
		clienteDAO.alta(c);
		
		assert(c.getIdcliente() != null);
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
