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
@SequenceGenerator(name = "forumidseq", sequenceName = "forum_id_seq", allocationSize = 1)
public class Forum {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "forumidseq")

	@Column(name = "forumId")
	private int forumId;

	@Column(name = "forumName")
	private String forumName;

	@Column(name = "forumContent")
	private String forumContent;

	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-mm-yyyy")
	@Column(name = "createdDate")
	private Date createdDate;

	@Column(name = "username")
	private String username;

	@Column(name = "status")
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getForumId() {
		return forumId;
	}

	public void setForumId(int forumId) {
		this.forumId = forumId;
	}

	public String getForumName() {
		return forumName;
	}

	public void setForumName(String forumName) {
		this.forumName = forumName;
	}

	public String getForumContent() {
		return forumContent;
	}

	public void setForumContent(String forumContent) {
		this.forumContent = forumContent;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
