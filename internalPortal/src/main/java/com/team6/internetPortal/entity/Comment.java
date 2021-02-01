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
@Table(name = "comment")
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
    private String comment;
	
	@Column
	private Date  commented_on;
	
	@ManyToOne
	private User commentor;
	
	@ManyToOne
	private Video  video;

	public Comment(int id, String comment, Date commented_on, User commentor, Video video) {
		super();
		this.id = id;
		this.comment = comment;
		this.commented_on = commented_on;
		this.commentor = commentor;
		this.video = video;
	}
	
	
	
}
