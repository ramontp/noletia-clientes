/**
 * 
 */
package es.noletia.gestioncfe.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author ramon
 *
 */
public class ComunAction extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = -6524362382396044138L;
	protected Map<String, Object> session;
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

}
