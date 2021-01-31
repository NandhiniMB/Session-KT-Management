package com.team6.internetPortal.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "like_table")
public class Like {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	
	@Column
	private Date  liked_at;
	
	@ManyToOne
	private User liked_user;
	
	@ManyToOne
	private Video video;
	
	public Like(long id, User liked_user, Video video, Date liked_at) {
		super();
		this.id = id;
		this.liked_user = liked_user;
		this.video = video;
		this.liked_at = liked_at;
	}
}
