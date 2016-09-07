package lib;
public class User {
	private String username = null;

	public User(String name) {
		this.username = name;
	}

	public void setUserName(String name) {
		this.username = name;	
	}

	public String getUserName() {
		return this.username;
	}

	public String toString() {
		return "UserName = " + this.username;
	}
};