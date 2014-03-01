/**
 * 
 */
package es.noletia.gestioncfe.modelo;

/**
 * @author ramon
 *
 */
public class Pas {
	
	private Long idcompania;
	private String nombre;
	private Generos genero;
	private String contacto;
	private String telefonos;
	private String emails;
	private Provincias provincia;
	private Integer compromisoECE;
	private Integer nFuncionesAdeudadas;
	private String observaciones;
	

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the genero
	 */
	public Generos getGenero() {
		return genero;
	}

	/**
	 * @param genero the genero to set
	 */
	public void setGenero(Generos genero) {
		this.genero = genero;
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
	 * @return the compromisoECE
	 */
	public Integer getCompromisoECE() {
		return compromisoECE;
	}

	/**
	 * @param compromisoECE the compromisoECE to set
	 */
	public void setCompromisoECE(Integer compromisoECE) {
		this.compromisoECE = compromisoECE;
	}

	/**
	 * @return the nFuncionesAdeudadas
	 */
	public Integer getnFuncionesAdeudadas() {
		return nFuncionesAdeudadas;
	}

	/**
	 * @param nFuncionesAdeudadas the nFuncionesAdeudadas to set
	 */
	public void setnFuncionesAdeudadas(Integer nFuncionesAdeudadas) {
		this.nFuncionesAdeudadas = nFuncionesAdeudadas;
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
	 * @return the idcompania
	 */
	public Long getIdcompania() {
		return idcompania;
	}

	/**
	 * @param idcompania the idcompania to set
	 */
	public void setIdcompania(Long idcompania) {
		this.idcompania = idcompania;
	}
	
	
}
