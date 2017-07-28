package com.xian.room.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
/**
 * 用户基础信息
 */
public class User implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(nullable = true)
    private String name;
    @Column(nullable = false)
     private String email;
    @Column(nullable = true)
    private String nickName;
    @Column(nullable = true)
    private String mobile;
    @Column(nullable = true)
    private String birth;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User( String name, String email, String nickName, String mobile, String birth) {
		super();
		this.name = name;
		this.email = email;
		this.nickName = nickName;
		this.mobile = mobile;
		this.birth = birth;
	}
    
    
    
}
