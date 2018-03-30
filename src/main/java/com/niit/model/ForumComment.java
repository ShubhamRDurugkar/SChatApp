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
@SequenceGenerator(name = "forumcommentidseq", sequenceName="forumComment_id_seq", allocationSize = 1)
public class ForumComment {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "forumcommentidseq")
	@Column(name="commentId")
	int commmentID;
	
	@Column(name = "commentText")
	private String commentText;
	
	@Column(name = "loginname")
	private String loginname;
	
	@Column(name = "forumId")
	private int forumId;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-mm-yyyy")
	@Column(name="commentDate")
	Date commentDate;

	public int getCommmentID() {
		return commmentID;
	}

	public void setCommmentID(int commmentID) {
		this.commmentID = commmentID;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public int getForumId() {
		return forumId;
	}

	public void setForumId(int forumId) {
		this.forumId = forumId;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	

}
