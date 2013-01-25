public class Usuario {
	protected String username;
	
	
	public Usuario(String username) {
		super();
		this.username = username.replaceAll("[ :]", "");
	}
	protected String getUsername() {
		return username;
	}
	protected void setUsername(String username) {
		this.username = username.replaceAll("[ :]", "");
	}

}
