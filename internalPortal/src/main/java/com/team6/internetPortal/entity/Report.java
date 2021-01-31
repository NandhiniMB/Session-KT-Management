package com.team6.internetPortal.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "report")
public class Report {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	private Comment comment;
	
	
	@ManyToOne
	private Video video;
	
	@ManyToOne
	private User user;

	public Report(int id, Comment comment, Video video, User user) {
		super();
		this.id = id;
		this.comment = comment;
		this.video = video;
		this.user = user;
	}

}
