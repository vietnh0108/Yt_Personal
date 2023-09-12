package Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ReportFavoriteUser implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private Serializable group;
	private String id;
	private String password;
	private String fullname;
	private String email;

	public ReportFavoriteUser() {
		super();
	}

	

	public ReportFavoriteUser(Serializable group, String id, String password, String fullname, String email) {
		this.group = group;
		this.id = id;
		this.password = password;
		this.fullname = fullname;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Serializable getGroup() {
		return group;
	}

	public void setGroup(Serializable group) {
		this.group = group;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
}
