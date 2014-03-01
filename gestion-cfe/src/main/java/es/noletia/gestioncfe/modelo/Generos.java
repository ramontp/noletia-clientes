/**
 * 
 */
package es.noletia.gestioncfe.modelo;

import java.io.Serializable;

/**
 * @author ramon
 *
 */
public class Generos implements Serializable{

	private static final long serialVersionUID = -8678157276242149179L;
	
	private Long idgenero;
	private String nombreGenero;
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
	public void setNombreGenero(String nombreGenero) {
		this.nombreGenero = nombreGenero;
	}
	
}
