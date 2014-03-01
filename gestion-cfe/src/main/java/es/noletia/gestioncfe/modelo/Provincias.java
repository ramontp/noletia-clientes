/**
 * 
 */
package es.noletia.gestioncfe.modelo;

import java.io.Serializable;

/**
 * @author ramon
 *
 */
public class Provincias implements Serializable{
	
	private static final long serialVersionUID = 2009628399435430544L;
	
	private Long idprovincia;
	private String nombreProvincia;
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
	 * @return the nombreProvincia
	 */
	public String getNombreProvincia() {
		return nombreProvincia;
	}
	/**
	 * @param nombreProvincia the nombreProvincia to set
	 */
	public void setNombreProvincia(String nombreProvincia) {
		this.nombreProvincia = nombreProvincia;
	}
	
}
