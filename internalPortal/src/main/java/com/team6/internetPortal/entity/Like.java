package com.team6.internetPortal.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "like_table")
public class Like {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	
	@Column
	private Date  likedAt;
	
	@ManyToOne
	private User likedUser;
	
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Video video;
	
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Date getLikedAt() {
		return likedAt;
	}


	public void setLikedAt(Date likedAt) {
		this.likedAt = likedAt;
	}


	public User getLikedUser() {
		return likedUser;
	}


	public void setLikedUser(User likedUser) {
		this.likedUser = likedUser;
	}


	public Video getVideo() {
		return video;
	}


	public void setVideo(Video video) {
		this.video = video;
	}

	public Like() {}

	public Like(long id, User likedUser, Video video, Date likedAt) {
		super();
		this.id = id;
		this.likedUser = likedUser;
		this.video = video;
		this.likedAt = likedAt;
	}
}
