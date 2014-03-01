/**
 * 
 */
package es.noletia.gestioncfe.modelo;

import java.io.Serializable;

/**
 * @author ramon
 *
 */
public class Emails implements Serializable{

	private static final long serialVersionUID = -4722765018203506853L;
	
	private Long idemail;
	private String email;
	private Espacios espacio;
	
	
	/**
	 * @return the idemail
	 */
	public Long getIdemail() {
		return idemail;
	}
	/**
	 * @param idemail the idemail to set
	 */
	public void setIdemail(Long idemail) {
		this.idemail = idemail;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
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
	
	
}
