/**
 * 
 */
package es.noletia.gestioncfe.action.privado;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;

import es.noletia.gestioncfe.action.ComunAction;
import es.noletia.gestioncfe.interceptor.AdminAware;
import es.noletia.gestioncfe.modelo.Pas;
import es.noletia.gestioncfe.modelo.Espacios;
import es.noletia.gestioncfe.modelo.Funciones;
import es.noletia.gestioncfe.service.PasService;
import es.noletia.gestioncfe.service.EspaciosService;
import es.noletia.gestioncfe.service.FuncionesService;

/**
 * @author ramon
 *
 */
@Component
@Scope("prototype")
public class AdminFuncionesAction extends ComunAction implements AdminAware{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private FuncionesService funcionesService;
	@Autowired
	private PasService companiasService;
	@Autowired
	private EspaciosService espaciosService;
	
	private Long idfuncion;
	private Long idcompania;
	private Long idespacio;
	private Date fecha;
	private Float recaudacion;
	private String observaciones;
	
	private List<Funciones> listaFunciones;
	private List<Pas> listaCompanias;
	private List<Espacios> listaEspacios;
	
	@SuppressWarnings("unchecked")
	@SkipValidation
	public String listado(){
		// si estamos editando una funcion
		if (session.get("funcion") != null){
			Funciones func = (Funciones)session.get("funcion");
			idfuncion = func.getIdfuncion();
			idcompania = func.getPas().getIdcompania();
			idespacio = func.getEspacio().getIdespacio();
			fecha = func.getFecha();
			recaudacion = func.getRecaudacion();
			observaciones = func.getObservaciones();
			
			session.remove("funcion");
		}
		
		// si hemos realizado una búsqueda
		if (session.get("listaFunciones") != null){
			listaFunciones = (List<Funciones>)session.get("listaFunciones");
			
			session.remove("listaFunciones");
		} else {
			listaFunciones = funcionesService.getListaElementos();
		}
		
		listaCompanias = companiasService.getListaElementos();
		listaEspacios = espaciosService.getListaElementos();
		
		return SUCCESS;
	}
	
	public String altaFuncion(){
		Funciones funcion = new Funciones();
		Pas comp = new Pas();
		comp.setIdcompania(idcompania);
		funcion.setPas(companiasService.getElemento(comp));
		Espacios esp = new Espacios();
		esp.setIdespacio(idespacio);
		funcion.setEspacio(espaciosService.getElemento(esp));
		funcion.setFecha(fecha);
		funcion.setRecaudacion(recaudacion);
		funcion.setObservaciones(observaciones);
		
		funcionesService.alta(funcion);
		
		return SUCCESS;
	}
	
	@SkipValidation
	public String borraFuncion(){
		Funciones funcion = new Funciones();
		funcion.setIdfuncion(idfuncion);
		
		funcionesService.borra(funcion);
		
		return SUCCESS;
	}
	
	@SkipValidation
	public String editaFuncion(){
		Funciones funcion = new Funciones();
		funcion.setIdfuncion(idfuncion);

		session.put("funcion", funcionesService.getElemento(funcion));
		
		return SUCCESS;
	}
	
	public String actualizaFuncion(){
		return SUCCESS;
	}
	
	@SkipValidation
	public String buscaFuncion(){
		Map<String, Object> parametros = new HashMap<String, Object>();
		
		funcionesService.getElementosFiltrados(parametros);
		
		return SUCCESS;
	}

	/**
	 * @return the funcionesService
	 */
	public FuncionesService getFuncionesService() {
		return funcionesService;
	}

	/**
	 * @param funcionesService the funcionesService to set
	 */
	public void setFuncionesService(FuncionesService funcionesService) {
		this.funcionesService = funcionesService;
	}

	/**
	 * @return the idfuncion
	 */
	public Long getIdfuncion() {
		return idfuncion;
	}

	/**
	 * @param idfuncion the idfuncion to set
	 */
	public void setIdfuncion(Long idfuncion) {
		this.idfuncion = idfuncion;
	}

	/**
	 * @return the idcompania
	 */
	public Long getIdcompania() {
		return idcompania;
	}

	/**
	 * @param idcompania the idcompania to set
	 */
	@RequiredFieldValidator
	public void setIdcompania(Long idcompania) {
		this.idcompania = idcompania;
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
	@RequiredFieldValidator
	public void setIdespacio(Long idespacio) {
		this.idespacio = idespacio;
	}

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	@RequiredFieldValidator
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the recaudacion
	 */
	public Float getRecaudacion() {
		return recaudacion;
	}

	/**
	 * @param recaudacion the recaudacion to set
	 */
	@RequiredFieldValidator
	public void setRecaudacion(Float recaudacion) {
		this.recaudacion = recaudacion;
	}

	/**
	 * @return the observaciones
	 */
	public String getObservaciones() {
		return observaciones;
	}

	/**
	 * @param observaciones the observaciones to set
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
	 * @param companiasService the companiasService to set
	 */
	public void setCompaniasService(PasService companiasService) {
		this.companiasService = companiasService;
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
	 * @return the fechaActual
	 */
	public Date getFechaActual() {
		return new Date();
	}

	/**
	 * @param fechaActual the fechaActual to set
	 */
	public void setFechaActual(Date fechaActual) {
	}

	/**
	 * @return the listaCompanias
	 */
	public List<Pas> getListaCompanias() {
		return (listaCompanias != null) ? listaCompanias: companiasService.getListaElementos();
	}

	/**
	 * @param listaCompanias the listaCompanias to set
	 */
	public void setListaCompanias(List<Pas> listaCompanias) {
		this.listaCompanias = listaCompanias;
	}

	/**
	 * @return the listaEspacios
	 */
	public List<Espacios> getListaEspacios() {
		return (listaEspacios != null) ? listaEspacios : espaciosService.getListaElementos();
	}

	/**
	 * @param listaEspacios the listaEspacios to set
	 */
	public void setListaEspacios(List<Espacios> listaEspacios) {
		this.listaEspacios = listaEspacios;
	}

	/**
	 * @return the listaFunciones
	 */
	public List<Funciones> getListaFunciones() {
		return (listaFunciones != null) ? listaFunciones : funcionesService.getListaElementos();
	}

	/**
	 * @param listaFunciones the listaFunciones to set
	 */
	public void setListaFunciones(List<Funciones> listaFunciones) {
		this.listaFunciones = listaFunciones;
	}
}
