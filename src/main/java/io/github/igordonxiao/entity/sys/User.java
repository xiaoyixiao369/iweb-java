package io.github.igordonxiao.entity.sys;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="sys_user")
public class User implements Serializable{
	private static final long serialVersionUID = 192879408189044L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	@Column(name="user_name",length=50,nullable=false)
	private String userName;
	@Column(name="password",length=255,nullable=false)
	private String password;
	@Column(name = "nick_name")
	private String nickName;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public User() {
		super();
	}
	
	public User(String username, String password) {
		super();
		this.userName = username;
		this.password = password;
	}
	public User(String username) {
		super();
		this.userName = username;
	}
	public User(Long id) {
		super();
		this.id = id;
	}
}
