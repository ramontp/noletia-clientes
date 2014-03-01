/**
 * 
 */
package es.noletia.gestioncfe.modelo;

import java.util.Date;

/**
 * @author ramon
 *
 */
public class Funciones {
	
	private Long idfuncion;
	private Pas pas;
	private Espacios espacio;
	private Date fecha;
	private Float recaudacion;
	private String observaciones;
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
	 * @return the pas
	 */
	public Pas getPas() {
		return pas;
	}
	/**
	 * @param pas the pas to set
	 */
	public void setPas(Pas compania) {
		this.pas = compania;
	}
	/**
	 * @return the espacio
	 */
	public Espacios getEspacio() {
		return espacio;
	}
	/**
	 * @param espacio the espacio to set
	 */
	public void setEspacio(Espacios espacio) {
		this.espacio = espacio;
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

}
