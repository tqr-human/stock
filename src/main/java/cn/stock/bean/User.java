package cn.stock.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class User implements Serializable{
	private static final long serialVersionUID = -1376216905288707683L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(name="user_name",length=100)
	private String userName;
	@Column(name="password",length=200)
	private String password;
	@Column(name = "status")
	private Integer status;
	@OneToMany(mappedBy = "creater")
	private Set<WV> wvCreate = new HashSet<>();
	@OneToMany(mappedBy = "verifier")
	private Set<WV> wvVerify = new HashSet<>();
	@OneToMany(mappedBy = "creater")
	private Set<DV> dvCreate = new HashSet<>();
	@OneToMany(mappedBy = "verifier")
	private Set<DV> dvVerify = new HashSet<>();
	@OneToMany(mappedBy = "creater")
	private Set<Stock_Log> logsCreate = new HashSet<>();
	@OneToMany(mappedBy = "verifier")
	private Set<Stock_Log> logsVerify = new HashSet<>();
	@Column
	private String passwordConfirm;

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public User(String userName) {
		this.userName = userName;
	}

	public User() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
