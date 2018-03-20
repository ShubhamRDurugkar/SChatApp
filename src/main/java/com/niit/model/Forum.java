package com.niit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="Forum")
public class Forum {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@SequenceGenerator(name = "generator", sequenceName="forum_seq", allocationSize = 1)
	@Column(name = "forumId")
	private int forumId;
	
	@Column(name = "forumName")
	private String forumName;
	
	@Column(name = "forumContent")
	private String forumContent;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "createdDate")
	private Date createdDate;
	
	@Column(name = "username")
	private String username;
	
	/*@Column(name = "status")
	private String status;
*/
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

	/*public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}*/
}
