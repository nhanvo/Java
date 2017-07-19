package com.nhanvo.model;

import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "blog", schema = "springdemo", catalog = "")
public class BlogEntity {
	private int id;
	private String title;
	private String content;	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date pubDate;
	private UserEntity userByUserId;
	
	@Id
	@Column(name = "id", nullable = false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Basic
	@Column(name = "title", nullable = false, length = 100)
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Basic
	@Column(name = "content", nullable = true, length = 255)
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Basic
	@Column(name = "pub_date", nullable = false)
	public Date getPubDate() {
		return pubDate;
	}
	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}
	
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
	public UserEntity getUserByUserId() {
		return userByUserId;
	}
	public void setUserByUserId(UserEntity userByUserId) {
		this.userByUserId = userByUserId;
	}
}
