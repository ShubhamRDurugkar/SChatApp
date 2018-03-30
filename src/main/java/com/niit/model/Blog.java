package com.niit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Component
@Entity
@Table
@SequenceGenerator(name = "blogidseq", sequenceName="blog_id_seq", allocationSize = 1)
public class Blog {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "blogidseq")
	@Column(name = "blogId")
	private int blogId;
	
	@Column(name = "blogName")
	private String blogName;
	
	@Column(name = "blogContent")
	private String blogContent;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-mm-yyyy")
	@Column(name = "createDate")
	private Date createDate;
	
	@Column(name = "loginname")
	private String loginname;
	
	@Column(name = "status")
	private String status;

	@Column(name="likes")
	private int likes;
	
	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public String getBlogName() {
		return blogName;
	}

	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}

	public String getBlogContent() {
		return blogContent;
	}

	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

}
