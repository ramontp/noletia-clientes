/**
 * 
 */
package es.noletia.gestioncfe.action.privado;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;

import es.noletia.gestioncfe.action.ComunAction;
import es.noletia.gestioncfe.interceptor.AdminAware;
import es.noletia.gestioncfe.modelo.Generos;
import es.noletia.gestioncfe.service.GenerosService;
import es.noletia.gestioncfe.util.EscapeChars;

/**
 * @author ramon
 *
 */
@Component
@Scope("prototype")
@Validations
public class AdminGenerosAction extends ComunAction implements AdminAware, Preparable{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
		.getLogger(AdminGenerosAction.class);

	private static final long serialVersionUID = 1L;
	@Autowired
	private GenerosService generosService;
	
	private Long idgenero;
	private String nombreGenero;
	private List<Generos> listaGeneros;
	
	private String mensaje;
	
	@Override
	public void prepare() throws Exception {
		if (listaGeneros == null){
			listaGeneros = generosService.getListaElementos();
		}
	}
	
	@SkipValidation
	public String entradaGenero(){
		return SUCCESS;
	}
	
	public String altaGenero(){
		try{
			Generos genero = new Generos();
			genero.setNombreGenero(EscapeChars.forScriptTagsOnly(nombreGenero));
			generosService.alta(genero);

			//refrescamos la lista de generos
			refrescaListaGeneros();
			setMensaje("El género ha sido dado de alta correctamente en la base de datos");
		} catch (Exception e){
			logger.error("Error en altaGenero.", e);
			setMensaje("Se ha producido un error en la aplicación. Consulte el log de la aplicación");
		}
		return SUCCESS;
	}

	private void refrescaListaGeneros() {
		listaGeneros = generosService.getListaElementos();
	}

	@SkipValidation
	public String borraGenero(){
		try{
			Generos genero = new Generos();
			genero.setIdgenero(idgenero);
			generosService.borra(genero);

			//refrescamos la lista de generos
			refrescaListaGeneros();
			setMensaje("El género ha sido borrado correctamente en la base de datos");
		} catch (Exception e){
			logger.error("Error en borraGenero.", e);
			setMensaje("Se ha producido un error en la aplicación. Consulte el log de la aplicación");
		}
		return SUCCESS;
	}
	
	@SkipValidation
	public String editaGenero(){
		try{
			Generos genero = generosService.getElementoPorId(idgenero);
			nombreGenero = genero.getNombreGenero();
		} catch (Exception e){
			logger.error("Error en editaGenero.", e);
			setMensaje("Se ha producido un error en la aplicación. Consulte el log de la aplicación");
		}
		return SUCCESS;
	}
	
	public String actualizaGenero(){
		try{
			Generos genero = new Generos();
			genero.setIdgenero(idgenero);
			genero.setNombreGenero(EscapeChars.forScriptTagsOnly(nombreGenero));
			generosService.actualiza(genero);
			
			//refrescamos la lista de generos
			refrescaListaGeneros();
			setMensaje("El género ha sido actualizado correctamente");
		} catch (Exception e){
			logger.error("Error en actualizaGenero.", e);
			setMensaje("Se ha producido un error en la aplicación. Consulte el log de la aplicación");
		}
		return SUCCESS;
	}
	
	public String buscaGenero(){
		try{
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("nombre",nombreGenero);
			listaGeneros = generosService.getElementosFiltrados(parametros);
		} catch (Exception e){
			logger.error("Error en buscaGenero.", e);
			setMensaje("Se ha producido un error en la aplicación. Consulte el log de la aplicación");
		}
		return SUCCESS;
	}


	/**
	 * @return the idgenero
	 */
	public Long getIdgenero() {
		return idgenero;
	}
	/**
	 * @param idgenero the idgenero to set
	 */
	public void setIdgenero(Long idgenero) {
		this.idgenero = idgenero;
	}
	/**
	 * @return the nombreGenero
	 */
	public String getNombreGenero() {
		return nombreGenero;
	}
	/**
	 * @param nombreGenero the nombreGenero to set
	 */
	@RequiredStringValidator(message = "El campo nombre no puede estar vacío")
	public void setNombreGenero(String nombreGenero) {
		this.nombreGenero = nombreGenero;
	}
	/**
	 * @return the listaGeneros
	 */
	public List<Generos> getListaGeneros() {
		return listaGeneros;
	}
	/**
	 * @param listaGeneros the listaGeneros to set
	 */
	public void setListaGeneros(List<Generos> listaGeneros) {
		this.listaGeneros = listaGeneros;
	}

	/**
	 * @return the generosService
	 */
	public GenerosService getGenerosService() {
		return generosService;
	}

	/**
	 * @param generosService the generosService to set
	 */
	public void setGenerosService(GenerosService generosService) {
		this.generosService = generosService;
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
