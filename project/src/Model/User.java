package Model;

public class User {
	private int userid;
	private String username;
	private String password;
	private String email;
	
	public User(int userid,String username,String password,String email){
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	public User(){
		
	}
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
