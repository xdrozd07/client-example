package xdrozd07.dt.wsclient.authentication;

public class SimpleAuthenticator implements IAuthenticator {

	/**
	 * Implementation of dimple authentication method
	 */
	@Override
	public boolean authenticate(IUser user) {
		
		/*
		 * This is just a simple example how does the authentication works
		 * All users are available to access the system now.
		 * 
		 * this is used only in Front Controller method getAuthenticator();
		 * 
		 */

		
		
		if(user.getLogin().compareTo("Rada") != 0){
			
			return false;
			
		}else{
			return true;
		}
	
			
		
		

	}

}
