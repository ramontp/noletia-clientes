/**
 * 
 */
package es.noletia.gestioncfe.action.privado;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

import es.noletia.gestioncfe.action.ComunAction;
import es.noletia.gestioncfe.interceptor.AdminAware;
import es.noletia.gestioncfe.modelo.Pas;
import es.noletia.gestioncfe.modelo.Generos;
import es.noletia.gestioncfe.modelo.Provincias;
import es.noletia.gestioncfe.service.PasService;
import es.noletia.gestioncfe.service.GenerosService;
import es.noletia.gestioncfe.service.ProvinciasService;

/**
 * @author ramon
 * 
 */
@Component
@Scope("prototype")
public class AdminCompaniasAction extends ComunAction implements AdminAware{

	private static final long serialVersionUID = 1L;

	@Autowired
	private PasService companiasService;
	@Autowired
	private GenerosService generosService;
	@Autowired
	private ProvinciasService provinciasService;

	private Long idcompania;
	private String nombre;
	private Long idgenero;
	private String contacto;
	private String telefonos;
	private String emails;
	private Long idprovincia;
	private Boolean compromisoECE;
	private Integer nfunciones;
	private String observaciones;

	private List<Pas> listaCompanias;
	private List<Generos> listaGeneros;
	private List<Provincias> listaProvincias;

	@SuppressWarnings("unchecked")
	@SkipValidation
	public String listado() {
		try {
			// si estamos editando
			if (session.get("compania") != null) {
				Pas compania = (Pas) session.get("compania");
				idcompania = compania.getIdcompania();
				nombre = compania.getNombre();
				if (compania.getGenero() != null) {
					idgenero = compania.getGenero().getIdgenero();
				}
				contacto = compania.getContacto();
				telefonos = compania.getTelefonos();
				emails = compania.getEmails();
				if (compania.getProvincia() != null) {
					idprovincia = compania.getProvincia().getIdprovincia();
				}
				compromisoECE = (compania.getCompromisoECE() == 1) ? true
						: false;
				nfunciones = compania.getnFuncionesAdeudadas();
				observaciones = compania.getObservaciones();

				// borramos el dato
				session.remove("compania");
			}

			// si hemos realizado una búsqueda
			if (session.get("listaCompanias") != null) {
				listaCompanias = (List<Pas>) session
						.get("listaCompanias");

				// borramos el dato
				session.remove("listaCompanias");
			} else {
				listaCompanias = companiasService.getListaElementos();
			}

			// para los combos de géneros y provincias
			listaGeneros = generosService.getListaElementos();
			listaProvincias = provinciasService.getListaElementos();
		} catch (Exception e) {
			// limpiamos los elementos de sesión
			session.remove("compania");
			session.remove("listaCompanias");
		}

		return SUCCESS;
	}

	public String altaCompania() {
		Pas compania = new Pas();
		compania.setNombre(nombre);
		Generos gen = new Generos();
		gen.setIdgenero(idgenero);
		compania.setGenero(generosService.getElemento(gen));
		compania.setContacto(contacto);
		compania.setTelefonos(telefonos);
		compania.setEmails(emails);
		Provincias prov = new Provincias();
		prov.setIdprovincia(idprovincia);
		compania.setProvincia(provinciasService.getElemento(prov));
		compania.setCompromisoECE((compromisoECE ? 1 : 0));
		compania.setnFuncionesAdeudadas(nfunciones);
		compania.setObservaciones(observaciones);

		companiasService.alta(compania);

		return SUCCESS;
	}

	@SkipValidation
	public String borraCompania() {
		Pas compania = new Pas();
		compania.setIdcompania(idcompania);
		companiasService.borra(compania);
		return SUCCESS;
	}

	@SkipValidation
	public String editaCompania() {
		Pas compania = new Pas();
		compania.setIdcompania(idcompania);
		session.put("compania", companiasService.getElemento(compania));
		return SUCCESS;
	}

	public String actualizaCompania() {
		Pas compania = new Pas();
		compania.setIdcompania(idcompania);
		compania.setNombre(nombre);
		Generos gen = new Generos();
		gen.setIdgenero(idgenero);
		compania.setGenero(generosService.getElemento(gen));
		compania.setContacto(contacto);
		compania.setTelefonos(telefonos);
		compania.setEmails(emails);
		Provincias prov = new Provincias();
		prov.setIdprovincia(idprovincia);
		compania.setProvincia(provinciasService.getElemento(prov));
		compania.setCompromisoECE((compromisoECE ? 1 : 0));
		compania.setnFuncionesAdeudadas(nfunciones);
		compania.setObservaciones(observaciones);
		companiasService.actualiza(compania);
		return SUCCESS;
	}

	@SkipValidation
	public String buscaCompania() {
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("nombre", nombre);
		parametros.put("idgenero", idgenero);
		parametros.put("contacto", contacto);
		parametros.put("telefonos", telefonos);
		parametros.put("emails", emails);
		parametros.put("idprovincia", idprovincia);
		parametros.put("compromisoECE", (compromisoECE ? 1 : 0));
		parametros.put("nFuncionesAdeudadas", nfunciones);
		parametros.put("observaciones", observaciones);

		session.put("listaCompanias",
				companiasService.getElementosFiltrados(parametros));

		return SUCCESS;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	@RequiredStringValidator(message = "El nombre no puede estar vacío")
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the contacto
	 */
	public String getContacto() {
		return contacto;
	}

	/**
	 * @param contacto
	 *            the contacto to set
	 */
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	/**
	 * @return the telefonos
	 */
	public String getTelefonos() {
		return telefonos;
	}

	/**
	 * @param telefonos
	 *            the telefonos to set
	 */
	public void setTelefonos(String telefonos) {
		this.telefonos = telefonos;
	}

	/**
	 * @return the emails
	 */
	public String getEmails() {
		return emails;
	}

	/**
	 * @param emails
	 *            the emails to set
	 */
	public void setEmails(String emails) {
		this.emails = emails;
	}

	/**
	 * @return the idgenero
	 */
	public Long getIdgenero() {
		return idgenero;
	}

	/**
	 * @param idgenero
	 *            the idgenero to set
	 */
	public void setIdgenero(Long idgenero) {
		this.idgenero = idgenero;
	}

	/**
	 * @return the idprovincia
	 */
	public Long getIdprovincia() {
		return idprovincia;
	}

	/**
	 * @param idprovincia
	 *            the idprovincia to set
	 */
	public void setIdprovincia(Long idprovincia) {
		this.idprovincia = idprovincia;
	}

	/**
	 * @return the compromisoECE
	 */
	public Boolean getCompromisoECE() {
		return compromisoECE;
	}

	/**
	 * @param compromisoECE
	 *            the compromisoECE to set
	 */
	public void setCompromisoECE(Boolean compromisoECE) {
		this.compromisoECE = compromisoECE;
	}

	/**
	 * @return the nfunciones
	 */
	public Integer getNfunciones() {
		return nfunciones;
	}

	/**
	 * @param nfunciones
	 *            the nfunciones to set
	 */
	@IntRangeFieldValidator(min = "0", max = "100", message = "Número de funciones incorrecto")
	public void setNfunciones(Integer nfunciones) {
		this.nfunciones = nfunciones;
	}

	/**
	 * @return the observaciones
	 */
	public String getObservaciones() {
		return observaciones;
	}

	/**
	 * @param observaciones
	 *            the observaciones to set
	 */
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	/**
	 * @return the companiasService
	 */
	public PasService getCompaniasService() {
		return companiasService;
	}

	/**
	 * @param companiasService
	 *            the companiasService to set
	 */
	public void setCompaniasService(PasService companiasService) {
		this.companiasService = companiasService;
	}

	/**
	 * @return the generosService
	 */
	public GenerosService getGenerosService() {
		return generosService;
	}

	/**
	 * @param generosService
	 *            the generosService to set
	 */
	public void setGenerosService(GenerosService generosService) {
		this.generosService = generosService;
	}

	/**
	 * @return the provinciasService
	 */
	public ProvinciasService getProvinciasService() {
		return provinciasService;
	}

	/**
	 * @param provinciasService
	 *            the provinciasService to set
	 */
	public void setProvinciasService(ProvinciasService provinciasService) {
		this.provinciasService = provinciasService;
	}

	/**
	 * @return the idcompania
	 */
	public Long getIdcompania() {
		return idcompania;
	}

	/**
	 * @param idcompania
	 *            the idcompania to set
	 */
	public void setIdcompania(Long idcompania) {
		this.idcompania = idcompania;
	}

	/**
	 * @return the listaCompanias
	 */
	public List<Pas> getListaCompanias() {
		return (listaCompanias != null) ? listaCompanias : companiasService
				.getListaElementos();
	}

	/**
	 * @param listaCompanias
	 *            the listaCompanias to set
	 */
	public void setListaCompanias(List<Pas> listaCompanias) {
		this.listaCompanias = listaCompanias;
	}

	/**
	 * @return the listaGeneros
	 */
	public List<Generos> getListaGeneros() {
		return (listaGeneros != null) ? listaGeneros : generosService
				.getListaElementos();
	}

	/**
	 * @param listaGeneros
	 *            the listaGeneros to set
	 */
	public void setListaGeneros(List<Generos> listaGeneros) {
		this.listaGeneros = listaGeneros;
	}

	/**
	 * @return the listaProvincias
	 */
	public List<Provincias> getListaProvincias() {
		return (listaProvincias != null) ? listaProvincias : provinciasService
				.getListaElementos();
	}

	/**
	 * @param listaProvincias
	 *            the listaProvincias to set
	 */
	public void setListaProvincias(List<Provincias> listaProvincias) {
		this.listaProvincias = listaProvincias;
	}

}
