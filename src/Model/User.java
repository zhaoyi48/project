package Model;

public class User {
	private int userid;
	private String username;
	private String password;
	private String email;
	private int access;
	
	public User(int userid,String username,String password,String email,int access){
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.email = email;
		this.access = access;
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

	public int getAccess() {
		return access;
	}

	public void setAccess(int access) {
		this.access = access;
	}
	
	
}
