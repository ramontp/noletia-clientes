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

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;

import es.noletia.gestioncfe.action.ComunAction;
import es.noletia.gestioncfe.interceptor.AdminAware;
import es.noletia.gestioncfe.modelo.Espacios;
import es.noletia.gestioncfe.modelo.Provincias;
import es.noletia.gestioncfe.service.EspaciosService;
import es.noletia.gestioncfe.service.ProvinciasService;

/**
 * @author ramon
 *
 */
@Component
@Scope("prototype")
@Validations
public class AdminEspaciosAction extends ComunAction implements AdminAware{

	private static final long serialVersionUID = 3636394902652165083L;
	@Autowired
	private EspaciosService espaciosService;
	@Autowired
	private ProvinciasService provinciasService;
	
	private Long idespacio;
	private String espacio;
	private String contacto;
	private String telefonos;
	private String emails;
	private Long provincia;
	
	private List<Espacios> listaEspacios;
	private List<Provincias> listaProvincias;
	
	@SuppressWarnings("unchecked")
	@SkipValidation
	public String listado(){
		// comprobamos si estamos editando
		if (session.get("espacio")!= null){
			Espacios esp = (Espacios)session.get("espacio");
			espacio = esp.getEspacio();
			idespacio = esp.getIdespacio();
			contacto = esp.getContacto();
			telefonos = esp.getTelefonos();
			provincia = esp.getProvincia().getIdprovincia();
			//borramos el dato
			session.remove("espacio");
		}
		
		// si hemos realizado una búsqueda
		if (session.get("listaEspacios") != null){
			listaEspacios = (List<Espacios>) session.get("listaEspacios");
			session.remove("listaEspacios");
		} else {
			listaEspacios = espaciosService.getListaElementos();
		}
		// recuperamos la lista de provincias
		listaProvincias = provinciasService.getListaElementos();
		
		return SUCCESS;
	}
	
	public String altaEspacio(){
		Espacios esp = new Espacios();
		esp.setEspacio(espacio);
		esp.setContacto(contacto);
		esp.setTelefonos(telefonos);
		Provincias prov = new Provincias();
		prov.setIdprovincia(provincia);
		esp.setProvincia(provinciasService.getElemento(prov));
		espaciosService.alta(esp);
		return SUCCESS;
	}
	
	@SkipValidation
	public String borraEspacio(){
		Espacios esp = new Espacios();
		esp.setIdespacio(idespacio);
		espaciosService.borra(esp);
		return SUCCESS;
	}
	
	@SkipValidation
	public String editaEspacio(){
		Espacios esp = new Espacios();
		esp.setIdespacio(idespacio);
		session.put("espacio", espaciosService.getElemento(esp));
		return SUCCESS;
	}

	public String actualizaEspacio(){
		Espacios esp = new Espacios();
		esp.setIdespacio(idespacio);
		esp.setEspacio(espacio);
		esp.setContacto(contacto);
		esp.setTelefonos(telefonos);
		Provincias prov = new Provincias();
		prov.setIdprovincia(provincia);
		esp.setProvincia(provinciasService.getElemento(prov));
		espaciosService.actualiza(esp);
		return SUCCESS;
	}
	
	@SkipValidation
	public String buscaEspacio(){
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("espacio", espacio);
		parametros.put("contacto", contacto);
		parametros.put("telefonos", telefonos);
		parametros.put("provincia", provincia);
		listaEspacios = espaciosService.getElementosFiltrados(parametros);
		session.put("listaEspacios", listaEspacios);
		return SUCCESS;
	}

	/**
	 * @return the espaciosService
	 */
	public EspaciosService getEspaciosService() {
		return espaciosService;
	}

	/**
	 * @param espaciosService the espaciosService to set
	 */
	public void setEspaciosService(EspaciosService espaciosService) {
		this.espaciosService = espaciosService;
	}

	/**
	 * @return the idespacio
	 */
	public Long getIdespacio() {
		return idespacio;
	}

	/**
	 * @param idespacio the idespacio to set
	 */
	public void setIdespacio(Long idespacio) {
		this.idespacio = idespacio;
	}

	/**
	 * @return the espacio
	 */
	public String getEspacio() {
		return espacio;
	}

	/**
	 * @param espacio the espacio to set
	 */
	@RequiredStringValidator(message="El espacio no puede estar vacío")
	public void setEspacio(String espacio) {
		this.espacio = espacio;
	}

	/**
	 * @return the contacto
	 */
	public String getContacto() {
		return contacto;
	}

	/**
	 * @param contacto the contacto to set
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
	 * @param telefonos the telefonos to set
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
	 * @param emails the emails to set
	 */
	public void setEmails(String emails) {
		this.emails = emails;
	}

	/**
	 * @return the provincia
	 */
	public Long getProvincia() {
		return provincia;
	}

	/**
	 * @param provincia the provincia to set
	 */
	public void setProvincia(Long provincia) {
		this.provincia = provincia;
	}

	/**
	 * @return the listaEspacios
	 */
	public List<Espacios> getListaEspacios() {
		return (listaEspacios!=null)?listaEspacios:espaciosService.getListaElementos();
	}

	/**
	 * @param listaEspacios the listaEspacios to set
	 */
	public void setListaEspacios(List<Espacios> listaEspacios) {
		this.listaEspacios = listaEspacios;
	}

	/**
	 * @return the listaProvincias
	 */
	public List<Provincias> getListaProvincias() {
		return (listaProvincias!=null)?listaProvincias:provinciasService.getListaElementos();
	}

	/**
	 * @param listaProvincias the listaProvincias to set
	 */
	public void setListaProvincias(List<Provincias> listaProvincias) {
		this.listaProvincias = listaProvincias;
	}

	/**
	 * @return the provinciasService
	 */
	public ProvinciasService getProvinciasService() {
		return provinciasService;
	}

	/**
	 * @param provinciasService the provinciasService to set
	 */
	public void setProvinciasService(ProvinciasService provinciasService) {
		this.provinciasService = provinciasService;
	}

}
