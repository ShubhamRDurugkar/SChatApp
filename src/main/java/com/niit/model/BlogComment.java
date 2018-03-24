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

@Component
@Entity
@Table
@SequenceGenerator(name = "blogcommentidseq", sequenceName="blogComment_id_seq", allocationSize = 1)
public class BlogComment {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "blogcommentidseq")
	@Column(name="CommentId")
	int commmentID;
	
	@Column(name = "commentText")
	private String commentText;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "blogId")
	private int blogId;
	
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	
}
