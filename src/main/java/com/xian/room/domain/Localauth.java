package com.xian.room.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
/**
 * 本地密码授权
 *  id | user_id | username | password
 */
public class Localauth implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
	
    @Column(nullable = false)
    private Long user_id;
    
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    
    private User user;
    
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
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
	public Localauth() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Localauth(long user_id, String username, String password) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
	}
    
}
