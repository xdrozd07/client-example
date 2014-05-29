/**
 * User interface defines the minimal requested requirements on User Identity class
 */

package xdrozd07.dt.wsclient.authentication;


public interface IUser {

	/**
	 * Returns users login
	 * @return
	 */
	public String getLogin();
	
	/**
	 * sets users login
	 * @param login
	 */
	public void setLogin(String login);
	
	/**
	 * returns users password
	 * @return
	 */
	public String getPassword();
	
	/**
	 * sets users password
	 * @param password
	 */
	public void setPassword(String password);	
	
	
}
