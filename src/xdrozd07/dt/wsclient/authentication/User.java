/**
 * Simple user representation
 */

package xdrozd07.dt.wsclient.authentication;

public class User implements IUser{

	
	private String login;
	private String password;
	
	private boolean administrator;
	
	
	/**
	 * POJO constructor
	 */
	public User(){
		
	}
	
	/**
	 * returns login of this user
	 */
	@Override
	public String getLogin() {
		return login;
	}

	/**
	 * sets login to this user
	 */
	@Override
	public void setLogin(String login) {
		this.login = login;		
	}

	/**
	 * returns password of this user
	 */
	@Override
	public String getPassword() {
		return password;
	}

	/**
	 * sets password of this user
	 */
	@Override
	public void setPassword(String password) {
		this.password = password;		
	}

	/**
	 * returns true if this user is administrator
	 * @return
	 */
	public boolean isAdministrator() {
		return administrator;
	}

	/**
	 * sets administrator property value to this user
	 * @param administrator
	 */
	public void setAdministrator(boolean administrator) {
		this.administrator = administrator;
	}

}
