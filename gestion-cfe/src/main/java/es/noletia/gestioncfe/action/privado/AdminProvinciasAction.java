/**
 * 
 */
package es.noletia.gestioncfe.action.privado;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.validation.SkipValidation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;

import es.noletia.gestioncfe.action.ComunAction;
import es.noletia.gestioncfe.interceptor.AdminAware;
import es.noletia.gestioncfe.modelo.Provincias;
import es.noletia.gestioncfe.service.ProvinciasService;
import es.noletia.gestioncfe.util.EscapeChars;

/**
 * @author ramon
 *
 */
@Component
@Scope("prototype")
@Validations
public class AdminProvinciasAction extends ComunAction implements AdminAware, Preparable{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
		.getLogger(AdminProvinciasAction.class);

	private static final long serialVersionUID = 1L;

	@Autowired
	private ProvinciasService provinciasService;

	private Long idprovincia;
	private String nombreProvincia;
	private List<Provincias> listaProvincias;
	
	private String mensaje;

	@SkipValidation
	public String entradaProvincia(){
		return SUCCESS;
	}
	
	public String altaProvincia(){
		try{
			Provincias provincia = new Provincias();
			provincia.setNombreProvincia(EscapeChars.forScriptTagsOnly(nombreProvincia));
			provinciasService.alta(provincia);
			nombreProvincia = null;
			// refrescamos la lista
			refrescaListaProvincias();
			setMensaje("La provincia ha sido dada de alta correctamente en la base de datos");
		} catch (Exception e){
			logger.error("Error en altaProvincia.", e);
			setMensaje("Se ha producido un error en la aplicación. Consulte el log de la aplicación");
		}
		return SUCCESS;
	}
	
	private void refrescaListaProvincias() {
		listaProvincias = provinciasService.getListaElementos();
	}

	@SkipValidation
	public String borraProvincia(){
		try{
			Provincias provincia = new Provincias();
			provincia.setIdprovincia(idprovincia);
			provinciasService.borra(provincia);
			setMensaje("La provincia ha sido eliminada de la base de datos");
			// refrescamos la lista
			refrescaListaProvincias();
		} catch (Exception e){
			logger.error("Error en borraProvincia.", e);
			setMensaje("Se ha producido un error en la aplicación. Consulte el log de la aplicación");
		}
		return SUCCESS;
	}
	
	@SkipValidation
	public String editaProvincia(){
		try{
			Provincias provincia = provinciasService.getElementoPorId(idprovincia);
			nombreProvincia = provincia.getNombreProvincia();
			idprovincia = provincia.getIdprovincia();
		} catch (Exception e){
			logger.error("Error en editaProvincia.", e);
			setMensaje("Se ha producido un error en la aplicación. Consulte el log de la aplicación");
		}
		return SUCCESS;
	}
	
	@SkipValidation
	public String buscaProvincia(){
		try{
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("nombre", nombreProvincia);
			listaProvincias = provinciasService.getElementosFiltrados(parametros);
		} catch (Exception e){
			logger.error("Error en buscaProvincia.", e);
			setMensaje("Se ha producido un error en la aplicación. Consulte el log de la aplicación");
		}
		return SUCCESS;
	}
	
	public String actualizaProvincia(){
		try{
			Provincias provincia = new Provincias();
			provincia.setIdprovincia(idprovincia);
			provincia.setNombreProvincia(EscapeChars.forScriptTagsOnly(nombreProvincia));
			provinciasService.actualiza(provincia);
			nombreProvincia = null;
			// refrescamos la lista
			refrescaListaProvincias();
			setMensaje("Se ha actualizado la provincia correctamente");
		} catch (Exception e){
			logger.error("Error en actualizaProvincia.", e);
			setMensaje("Se ha producido un error en la aplicación. Consulte el log de la aplicación");
		}
		return SUCCESS;
	}
	
	@Override
	public void prepare() throws Exception {
		if (listaProvincias == null){
			listaProvincias = provinciasService.getListaElementos();
		}
		
	}

	/**
	 * @return the nombreProvincia
	 */
	public String getNombreProvincia() {
		return nombreProvincia;
	}

	/**
	 * @param nombreProvincia the nombreProvincia to set
	 */
	@RequiredStringValidator(message = "El campo nombre no puede estar vacío")
	public void setNombreProvincia(String nombreProvincia) {
		this.nombreProvincia = nombreProvincia;
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

	/**
	 * @return the listaProvincias
	 */
	public List<Provincias> getListaProvincias() {
		return listaProvincias;
	}

	/**
	 * @param listaProvincias the listaProvincias to set
	 */
	public void setListaProvincias(List<Provincias> listaProvincias) {
		this.listaProvincias = listaProvincias;
	}

	/**
	 * @return the idprovincia
	 */
	public Long getIdprovincia() {
		return idprovincia;
	}

	/**
	 * @param idprovincia the idprovincia to set
	 */
	public void setIdprovincia(Long idprovincia) {
		this.idprovincia = idprovincia;
	}

	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}


}
