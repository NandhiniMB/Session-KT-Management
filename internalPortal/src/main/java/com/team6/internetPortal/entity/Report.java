package com.team6.internetPortal.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
@Table(name = "report")
public class Report {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Comment comment;
	
	
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Video video;
	
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User user;

	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Report(int id, Comment comment, Video video, User user) {
		super();
		this.id = id;
		this.comment = comment;
		this.video = video;
		this.user = user;
	}

	public Report() {
		
	}

	
	

}
