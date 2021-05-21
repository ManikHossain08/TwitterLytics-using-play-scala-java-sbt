package models;


/**
 * This class is used to get the details of user
 * It will return name, location and ScreenName of the particular user
 *
 */
public class User {
	
	private String name;
	private String location;
	private String screenName;
	
	
	public User() { 
		
	}
	
	/**
	 * @param name
	 * @param location
	 */
	public User(String name, String location) { 
		this.name = name;
		this.location = location;
	}
	
	/**
	 * @return the name of the user
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name  name of the user
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the location of the user
	 */
	public String getLocation() {
		return location;
	}
	
	/**
	 * @param location  location of the user
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
	/**
	 * @return the screenName of the user
	 */
	public String getScreenName() {
		return screenName;
	}
	/**
	 * @param screenName  screenname of the user
	 */
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	
	

}
