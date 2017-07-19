package com.nhanvo.model;

import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name="user", schema="springdemo", catalog="")
public class UserEntity {
	
	private int id;
	private String nickname;
	private String password;
	private String firstName;
	private String lastName;
	private Collection<BlogEntity> blogsById;
	
	@Id
	@Column(name = "id", nullable = false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Basic
	@Column(name = "nickname", nullable = false, length = 45)
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	@Basic
	@Column(name = "password", nullable = false, length = 45)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Basic
	@Column(name = "first_name", nullable = true, length = 45)
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Basic
	@Column(name = "last_name", nullable = true, length = 45)
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@OneToMany(mappedBy = "userByUserId")
	public Collection<BlogEntity> getBlogsById() {
		return blogsById;
	}
	public void setBlogsById(Collection<BlogEntity> blogsById) {
		this.blogsById = blogsById;
	}
	
	
	
}
