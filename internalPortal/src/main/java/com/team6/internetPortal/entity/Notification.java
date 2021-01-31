package com.team6.internetPortal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "notification")
public class Notification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	private User user;
	
	@Column
	private String description;
	
	@Column
	private boolean is_read;

	public Notification(long id, User user, String desc, boolean is_read) {
		super();
		this.id = id;
		this.user = user;
		this.description = description;
		this.is_read = is_read;
	}
	
	
	
	
}
