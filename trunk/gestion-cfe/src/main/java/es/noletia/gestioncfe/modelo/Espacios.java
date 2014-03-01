/**
 * 
 */
package es.noletia.gestioncfe.modelo;

import java.io.Serializable;
import java.util.List;

/**
 * @author ramon
 *
 */
public class Espacios implements Serializable{
	
	private static final long serialVersionUID = -3692338038472614860L;

	private Long idespacio;
	private String espacio;
	private String contacto;
	private String telefonos;
	private Provincias provincia;
	private TipoAcuerdo tipoacuerdo;
	private String descripcionacuerdo;
	private List<Emails> listaemails;

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
	 * @return the provincia
	 */
	public Provincias getProvincia() {
		return provincia;
	}
	/**
	 * @param provincia the provincia to set
	 */
	public void setProvincia(Provincias provincia) {
		this.provincia = provincia;
	}
	/**
	 * @return the tipoacuerdo
	 */
	public TipoAcuerdo getTipoacuerdo() {
		return tipoacuerdo;
	}
	/**
	 * @param tipoacuerdo the tipoacuerdo to set
	 */
	public void setTipoacuerdo(TipoAcuerdo tipoacuerdo) {
		this.tipoacuerdo = tipoacuerdo;
	}
	/**
	 * @return the descripcionacuerdo
	 */
	public String getDescripcionacuerdo() {
		return descripcionacuerdo;
	}
	/**
	 * @param descripcionacuerdo the descripcionacuerdo to set
	 */
	public void setDescripcionacuerdo(String descripcionacuerdo) {
		this.descripcionacuerdo = descripcionacuerdo;
	}
	/**
	 * @return the listaemails
	 */
	public List<Emails> getListaemails() {
		return listaemails;
	}
	/**
	 * @param listaemails the listaemails to set
	 */
	public void setListaemails(List<Emails> listaemails) {
		this.listaemails = listaemails;
	}
	
}
