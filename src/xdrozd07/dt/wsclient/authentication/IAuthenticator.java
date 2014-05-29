/**
 * Interface IAuthenticator defines minimal requests required from authenticator class
 * 
 * Authenticator is used only in FrontController class method getAuthenticator()
 */

package xdrozd07.dt.wsclient.authentication;


public interface IAuthenticator {

	/**
	 * Method authenticates user
	 * @param user
	 * @return
	 */
	public boolean authenticate(IUser user);
}
